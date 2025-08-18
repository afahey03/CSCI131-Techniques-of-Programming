/*----------------------------------------------------------------
 *  Author:   K. Walsh
 *  Email:    kwalsh@holycross.edu
 *  Written:  7/6/2015
 *  
 *  Calculates the impact velocity of a hailstone, taking into account
 *  the terminal velocity.
 *
 *  Example: java Hail 0.02 2000 
 *  Output:
 *    Gravitational acceleration: 9.81 m/s^2
 *         Density of atmosphere: 1.225 kg/m^3
 *                Density of ice: 934.0 kg/m^3
 *           Coefficient of drag: 0.5
 *         Diameter of hailstone: 0.02 m
 *           Radius of hailstone: 0.01 m
 *    Cross-section of hailstone: 3.1415926535897936E-4 m^2
 *             Mass of hailstone: 0.003912330051270489 kg
 *           Height of hailstone: 2000.0 m
 *             Terminal velocity: 19.972814176336016 m/s
 *            Free-fall velocity: 198.09088823063013 m/s
 *                Final velocity: 19.972814176336016 m/s
 *
 *----------------------------------------------------------------*/

public class Hail {

    // Acceleration due to gravity, in m/s^2 (meters per second squared).
    public static final double GRAVITY = 9.81;

    // Density of fluid atmosphere, in kg/m^3 (kilograms per cubic meter).
    public static final double AIR_DENSITY = 1.225;

    // Density of ice, in kg/m^3 (kilograms per cubic meter).
    public static final double ICE_DENSITY = 934.0;

    // Coefficient of drag for a typical hailstone (unitless).
    public static final double DRAG = 0.5;

    public static void main(String args[]) {

        double diameter; // diameter of the falling object (m)
        double height; // height of the falling object (m)

        double radius; // radius of the falling object (m)
        double area; // projected area of the falling object (m^2)
        double volume; // volume of the falling object (m^3)
        double mass; // mass of the falling object (kg)

        double freefallVelocity; // result of free-fall velocity calculation
        double terminalVelocity; // result of terminal velocity calculation
        double impactVelocity; // final velocity at time of impact

        // Get input parameters from command-line arguments.
        diameter = Double.parseDouble(args[0]);
        height = Double.parseDouble(args[1]);

        // Calculate properties of the hailstone.

        radius = diameter / 2;
        volume = 4.0 / 3 * Math.PI * Math.pow(radius, 3.0);
        mass = volume * ICE_DENSITY;
        area = Math.PI * Math.pow(radius, 2.0);

        // Calculate velocities.
        freefallVelocity = Math.sqrt(2 * GRAVITY * height);
        terminalVelocity = Math.sqrt(2 * mass * GRAVITY) / Math.sqrt(area * AIR_DENSITY * DRAG);
        impactVelocity = Math.min(freefallVelocity, terminalVelocity);

        // Print the inputs, intermediate calculations, and the results.
        System.out.println("Gravitational acceleration: " + GRAVITY + " m/s^2");
        System.out.println("Density of atmosphere: " + AIR_DENSITY + " kg/m^3");
        System.out.println("Density of ice: " + ICE_DENSITY + " kg/m^3");
        System.out.println("Coefficient of drag: " + DRAG);
        System.out.println("Diameter of hailstone: " + diameter + " m");
        System.out.println("Radius of hailstone: " + radius + " m");
        System.out.println("Cross-section of hailstone: " + area + " m^2");
        System.out.println("Mass of hailstone: " + mass + " kg");
        System.out.println("Height of hailstone: " + height + " m");
        System.out.println("Terminal velocity: " + terminalVelocity + " m/s");
        System.out.println("Free-fall velocity: " + freefallVelocity + " m/s");
        System.out.println("Final velocity: " + impactVelocity + " m/s");
    }
}
