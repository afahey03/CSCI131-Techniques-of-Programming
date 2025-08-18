// Author: Aidan Fahey
// Date: 2/25/2022
//
// Makes the Star of David

public class Engraving {

    public static void main(String[] args) {
        Laser.PLAYBACK_SPEED = 20; // this makes the simulated animation go quick!
        
        Laser.setSpeed(10);

            // Make the Star of David
            Laser.setPower(0);
            Laser.goTo(25, 49, 0);
            Laser.setPower(5);
            Laser.goTo(7, 9, 0);
            Laser.goTo(43, 9, 0);
            Laser.goTo(25, 49, 0);
            Laser.setPower(0);
            Laser.goTo(25, 1, 0);
            Laser.setPower(5);
            Laser.goTo(7, 39, 0);
            Laser.goTo(43, 39, 0);
            Laser.goTo(25, 1, 0);
            


        Laser.setPower(0);
        Laser.goTo(25, 49, 0);

        // To make a circle, we repeatedly: drive a tiny distance, turn a tiny
        // bit, drive a tiny distance, turn a tiny bit, etc. We move the laser
        // slowly at high power, to burn through the work piece.
        // The angle (2 degees) and distance (0.85 mm) were chosen by trial and
        // error.
        Laser.setSpeed(3);
        Laser.setPower(5);
        for (int i = 0; i < 360; i += 2) {
            Laser.move(0.85); // 0.85 mm
            Laser.turn(-2); // 2 degree clockwise
        }

        // Move quickly back to the bottom left corner, with laser off.
        Laser.setSpeed(10);
        Laser.setPower(0);
        Laser.goTo(0, 0, 0);

    } // end main

} // end Engraving
