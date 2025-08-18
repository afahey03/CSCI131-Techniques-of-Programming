/*----------------------------------------------------------------
 *  Author:
 *  Email:
 *  Date:
 *
 *  Animation of two stars, one bouncing horizontally, and a ball
 *  at a random location bouncing diagonally.
 *
 *  Example: java Bounce
 *----------------------------------------------------------------*/

public class Bounce {

    public static void main(String args[]) {

        Star s = new Star(0.5, 0.5, 0.03, 9);
        s.setColor(StdDraw.ORANGE);

        Star z = new Star(0.25, 0.8, 0.03, 7);
        z.setColor(StdDraw.RED);
        z.setVelocity(0.75, 0);

        Ball b = new Ball(Math.random(), Math.random(), 0.03);
        b.setColor(StdDraw.GREEN);
        b.setVelocity(0.75, 0.75);

        // Loop the animation forever.
        while (true) {

            z.move(20);
            b.move(20);
            
            z.bounce();
            b.bounce();

            s.rotateAngle(0.02);
            
            // Draw the scene on the StdDraw canvas.
            StdDraw.clear(StdDraw.WHITE);
            s.draw();
            z.draw();
            b.draw();

            // Show the canvas on the screen.
            StdDraw.show(20); // 20ms duration for animation
        }
    }
}
