/*----------------------------------------------------------------
 *  Author:   K. Walsh
 *  Edited:   Aidan Fahey
 *  Email:    kwalsh@holycross.edu
 *  Written:  7/13/2015
 *  
 *  Minesweeper game. This class implements the game window and most
 *  of the game logic.
 *----------------------------------------------------------------*/

import GUI.*;

/**
 * A <i>Game</i> object manages all information about a minesweeper game as it
 * is being played and displayed on the screen. This includes information about
 * all of the cells (this is stored in a 2-D array of Cell objects), how many
 * flags have been planted, how many mines have been deployed, etc. Game extends
 * Window so it can be drawn on the screen. It also extends EventListener, so it
 * can respond to user interaction.
 */
public class Game extends Window implements EventListener {

    /**
     * Number of cells tall the game board will be.
     */
    public static final int NUM_ROWS = 20;

    /**
     * Number of cells wide the game board will be.
     */
    public static final int NUM_COLS = 30;

    // Example game screen layout:
    // +---------------------------------------------------------+
    // |      M A R G I N = 50                                   |
    // | M  + - - - - - - - - - - - - - - - - - - - - - - - + M  |
    // | A  |                                               | A  |
    // | R  |                                               | R  |
    // | G  |                Grid of Cells                  | G  |
    // | I  |                                               | I  |
    // | N  |                                               | N  |
    // | =  |       600 = NUM_COLS * Cell.SIZE wide         | =  |
    // | 50 |                      by                       | 50 |
    // |    |       400 = NUM_ROWS * Cell.SIZE tall         |    |
    // |    |                                               |    |
    // |    |                                               |    |
    // |    |                                               |    |
    // |    + - - - - - - - - - - - - - - - - - - - - - - - +    |
    // |            SPACE     S   SPACE   S    SPACE             |
    // |    + - - - - - - - + P + - - - + P + - - - - - - - +    |
    // |    |    Status     | A | Timer | A |     Help      |    |
    // |    |       Box     | C |       | C |      Box      |    |
    // |    + - - - - - - - + E + - - - + E + - - - - - - - +    |
    // |     M A R G I N = 50                                    |
    // +-- ------------------------------------------------------+

    /**
     * Width of the game window, in pixels.
     * Equal to 2*MARGIN + GRID_WIDTH
     * or 2*MARGIN + 2*SPACE + StatusBox.WIDTH, Timer.WIDTH, HelpBox.WIDTH,
     * whichever is larger.
     */
    public static final int WIDTH = 700;

    /**
     * Height of the game window, in pixels.
     * Equal to 2*MARGIN + SPACE
     *     + GRID_HEIGHT
     *     + max(StatusBox.Height, Timer.HEIGHT, HelpBox.HEIGHT)
     */
    public static final int HEIGHT = 600; 

    /**
     * Width of the grid part of the window, in pixels.
     * Equal to NUM_COLS * Cell.SIZE.
     */
    public static final int GRID_WIDTH = NUM_COLS * Cell.SIZE;

    /**
     * Height of the grid part of the window, in pixels.
     * Equal to NUM_ROWS * Cell.SIZE.
     */
    public static final int GRID_HEIGHT = NUM_ROWS * Cell.SIZE;

    /**
     * Margin around the edges of the canvas.
     */
    private static final int MARGIN = 50;

    /**
     * Space between elements on the canvas.
     */
    private static final int SPACE = 25;

    // A 2-D array of Cell objects to keep track of the board state.
    private Cell[][] cells = new Cell[NUM_ROWS][NUM_COLS];

    private int numMines = 0;    // number of mines deployed
    private int numRevealed = 0; // number of cells revealed so far

    // Whether or not the game has been won.
    private boolean gameWon = false;

    // Whether or not the game has been lost
    private boolean gameLost = false;

    // Name of the user playing the game.
    private String username;

    // The difficulty level of the game, used for tracking top scores.
    private String difficulty;

    // The status box that appears in the top left.
    private StatusBox status;

    // The timer that appears in the top middle.
    private Timer timer;

    // The help box that appears in the top right.
    private HelpBox help;

    /**
     * Constructor: Initializes a new game, but does not deploy any mines, plant
     * any flags, etc. The difficulty is either "easy", "medium", or "hard", and
     * will be used to load the proper top scores file. Name is used as the
     * user's name.
     */
    public Game(String name, String difficulty) {
        super("Minesweeper!", WIDTH, HEIGHT);

        this.username = name;
        this.difficulty = difficulty;

        // Create the background
        setBackgroundColor(Canvas.DARK_GRAY);

        // Create a border around the grid
        Box border = new Box(MARGIN-1.5, MARGIN-1.5, GRID_WIDTH+3, GRID_HEIGHT+3);
        border.setBackgroundColor(null);
        border.setBorderColor(Canvas.BLACK);
        add(border);

        // Create the info boxes
        help = new HelpBox(
                WIDTH - MARGIN - HelpBox.WIDTH,
                HEIGHT - MARGIN - HelpBox.HEIGHT);
        add(help); // creates a help box

        status = new StatusBox(this, MARGIN, HEIGHT - MARGIN - HelpBox.HEIGHT); // creates a status box
        add(status);
        
                
        timer = new Timer(MARGIN + StatusBox.WIDTH + SPACE, HEIGHT - MARGIN - HelpBox.HEIGHT); // creates a timer
        add(timer);
        timer.startCounting();

        for(int x = 0; x < 20; x++) {
            for (int y = 0; y < 30; y++) {
                cells[x][y] = new Cell(MARGIN + Cell.SIZE * y, MARGIN + Cell.SIZE * x);
                add(cells[x][y]);
            } // end of for loop
        } // end of for loop

        int row, col;
        row = 5;
        col = 8;
        cells[row][col] = new Cell(MARGIN+Cell.SIZE*col, MARGIN+Cell.SIZE*row);
        add(cells[row][col]);
        row = 17;
        col = 13;
        cells[row][col] = new Cell(MARGIN+Cell.SIZE*col, MARGIN+Cell.SIZE*row);
        add(cells[row][col]);
        row = 13;
        col = 22;
        cells[row][col] = new Cell(MARGIN+Cell.SIZE*col, MARGIN+Cell.SIZE*row);
        add(cells[row][col]);

    } // end of Game

    public int getNumMinesDeployed() { // gives the number of mines deployed
        return numMines;
    } // end of getNumMinesDeployed

    public int getNumCellsRemaining() { // gives the number of remaining cells
        return NUM_ROWS * NUM_COLS - numRevealed;
    } // end of getNumCellsRemaining

    public void deployMines(int mines) {
        while (mines > numMines) {
            int x = StdRandom.uniform(0, NUM_ROWS-1);
            int y = StdRandom.uniform(0, NUM_COLS-1);
            if (!cells[x][y].isMine) {
                cells[x][y].makeMine();
                numMines++;
                if (x != 0 && y != 0) {
                    cells[x-1][y-1].incrementNeighborMineCount();
                }
                if (x != 0) {
                    cells[x-1][y].incrementNeighborMineCount();
                }
                if (y != 0) {
                    cells[x][y-1].incrementNeighborMineCount();
                }
                if (x != NUM_ROWS && y != 0) {
                    cells[x+1][y-1].incrementNeighborMineCount();
                }
                if (x != 0 && y != NUM_COLS) {
                    cells[x-1][y+1].incrementNeighborMineCount();
                }
                if (x != NUM_ROWS && y != NUM_COLS) {
                    cells[x+1][y+1].incrementNeighborMineCount();
                }
                if (x != NUM_ROWS) {
                    cells[x+1][y].incrementNeighborMineCount();
                }
                if (y != NUM_COLS) {
                    cells[x][y+1].incrementNeighborMineCount();
                }
            } // end of if statement
        } // end of while loop

    } // end of deployMines

    /**
     * Respond to a mouse click. This function will be called each time the user
     * clicks on the game window. The x, y parameters indicate the screen
     * coordinates where the user has clicked, and the button parameter
     * indicates which mouse button was clicked (either "left", "middle", or
     * "right"). The function should update the game state according to what the
     * user has clicked.
     * @param x the x coordinate where the user clicked, in pixels.
     * @param y the y coordinate where the user clicked, in pixels.
     * @param button either "left", "middle", or "right".
     */
    public void mouseClicked(double x, double y, String button) {
        // User clicked the mouse, see what they want to do.

        // If game is over, then ignore the mouse click.
        if (gameWon || gameLost)
            return;

        // If the user middle-clicked, ignore it.
        if (!button.equals("left") && !button.equals("right"))
            return;

        // If the user clicked outside of the game grid, ignore it.
        if (x < MARGIN || y < MARGIN
                || x >= MARGIN + GRID_WIDTH || y >= MARGIN + GRID_HEIGHT) {
            return;
                }
        
        // Calculate which cell the user clicked.
        int row = (int)((y - MARGIN) / Cell.SIZE);
        int col = (int)((x - MARGIN) / Cell.SIZE);

        StdOut.printf("You clicked row %d column %d with button %s\n", row, col, button);

        if (button.equals("left")) {
            cells[row][col].reveal();
        } // end of if statement

        if (button.equals("left") && cells[row][col].coastIsClear()) {
            numRevealed++; 
        } // end of if statement

        if (button.equals("left") && cells[row][col].isMine()) {
            for (int i = 0; i < NUM_ROWS; i++) { // Loop through remaining cells and reveal the unclicked mines
                for (int j = 0; j < NUM_COLS; j++) {
                    if (cells[i][j].isMine) {
                    cells[i][j].reveal();
                    } // end of if statement
                } // end of inner nested for-loop
            } // end of nested for-loop
            gameLost = true;
            timer.stopCounting(); 
            numMines--;
            numRevealed++;
            StdOut.println("You lose!");
        } // end of if statement

        if (getNumCellsRemaining() == numMines) {
            gameWon = true;
            timer.stopCounting();
            StdOut.println("You win!");
        } // end of if statement

    } // end of mouseClicked

    /**
     * Respond to key presses. This function will be called each time the user
     * presses a key. The parameter indicates the character the user pressed.
     * The function should update the game state according to what character the
     * user has pressed. 
     * @param c the character that was typed.
     */
    public void keyTyped(char c)
    {
        // User pressed a key, see what they want to do.
        switch (c) {
            case 'q': 
            case 'Q': 
                hide(); // user wants to quit
                break;
            default:
                break; // anything else is ignored
        }
    }

    /**
     * Paint the background for this window on the canvas. Don't call this
     * directly, it is called by the GUI system automatically. This function
     * should draw something on the canvas, if you like. Or the background can
     * be blank.
     * @param canvas the canvas on which to draw.
     */
    public void repaintWindowBackground(GUI.Canvas canvas) {

    }
}
