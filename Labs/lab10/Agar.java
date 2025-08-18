/*----------------------------------------------------------------
 *  Author: TODO
 *  Email: TODO
 *  Written: TODO 
 * 
 *  A game similar to https://agar.io/, in which the user controls a round blob
 *  with the mouse and tries to eat smaller round blobs and avoid spikey shapes.
 *
 *  Example: java Agar
 *----------------------------------------------------------------*/

public class Agar {

    // Create a small ball with random position and velocity.
    public static Ball launchRandomBall() {
        Ball q = new Ball(Math.random(), Math.random(), 0.04);
        q.setColor(StdDraw.BLUE);
        q.aimTowards(Math.random(), Math.random(), 0.3);
        return q;
    }

    // Make the player blob eat the food blob by growing larger.
    public static void eat(Ball player, Ball food) {
        player.grow(food.size());
        System.out.printf("Yum! Now I am %.5f big!\n", player.size());
    }

    // Poison the player blob by shrinking it.
    public static void poison(Ball player) {
        player.grow(-player.size()/4.0);
        StdOut.printf("Ack! I shrank to %.5f small!\n", player.size());
    }

    public static void main(String args[]) {

        // Create a medium-sized ball for the player.
        Ball player = new Ball(0.5, 0.5, 0.07);
        player.setColor(StdDraw.RED);

        Ball foodOne = launchRandomBall();
        Ball foodTwo = launchRandomBall();

        Star poison = new Star(0.5, 0.5, 0.03, 9);
        poison.setColor(StdDraw.GREEN);
        poison.aimTowards(Math.random(), Math.random(), 0.15);

        // Loop the animation forever.
        while (true) {

            // Update player so it is aiming towards the mouse.
            player.aimTowards(StdDraw.mouseX(), StdDraw.mouseY(), 1.0/6.0);

            // Make the player bounce off the edge of the screen.
            player.bounce();

            foodOne.bounce();
            foodTwo.bounce();
            poison.bounce();
            // Move the player.
            player.move(20);

            foodOne.move(20);
            foodTwo.move(20);

            poison.move(10);

            if (player.covering(foodOne)) {
                eat(player, foodOne);
                foodOne = launchRandomBall();
            }
            if (player.covering(foodTwo)) {
                eat(player, foodTwo);
                foodTwo = launchRandomBall();
            }

            if (player.touching(poison)) {
                poison(player);
                poison.setPosition(Math.random(), Math.random());
            }

            // Draw the scene on the StdDraw canvas.
            StdDraw.clear(StdDraw.WHITE);
            foodOne.draw();
            foodTwo.draw();

            poison.draw();
            // Draw the player.
            player.draw();

            // Show the canvas on the screen.
            StdDraw.show(20);
        }

    }
}
