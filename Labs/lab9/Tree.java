/*----------------------------------------------------------------
 *  Author: Aidan Fahey
 *  Email: amfahe25@g.holycross.edu
 *  Written: 4/5/22
 *  
 *  Draw a tree, recursively. The number of branching levels is given by a
 *  command line argument.  The incremental angle increase of each branch is
 *  given by a second argument.
 *
 *  Example: java Tree 5 45
 *----------------------------------------------------------------*/

import java.awt.Color;

public class Tree {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Oops, you should provide exactly two arguments, like this:");
            System.out.println("  java Tree 4 40.0");
            System.exit(1);
        }
        int levels = Integer.parseInt(args[0]);  // Number of levels to draw
        double increment = Double.parseDouble(args[1]);
        StdOut.printf("Drawing a tree with %d levels and angle increment of %f\n", levels, increment);
        StdDraw.setXscale(0, 120);               // Scale the drawing window
        StdDraw.setYscale(0, 120);
        // Draw tree with angle of the trunk given by 90 degrees,
        // the angle of branches given by increment
        // and number of levels given by levels
        double x = 60;
        double y = 10;
        double length = 50;
        double angle = 90.0;
        drawTree(x, y, length, angle, increment, levels); 
    }

    // *********************************************************************
    // drawTree(x, y, length, angle, increment, levels)
    // Purpose: Draw a tree at position (x, y) in the drawing
    //     window, with trunklength given by length, the angle of the
    //     tree trunk given by angle, the angle of the branches
    //     relative to the trunk given by increment, and the number of levels
    //     given by levels.
    // ******************************************************************
    public static void drawTree(double x, double y, double length, 
            double angle, double increment, int levels) {

        // Compute endpoint and midpoint of trunk
        double xEnd = x + Math.cos(Math.toRadians(angle))*length;
        double yEnd = y + Math.sin(Math.toRadians(angle))*length;
        double xMid = x + Math.cos(Math.toRadians(angle))*length/2;
        double yMid = y + Math.sin(Math.toRadians(angle))*length/2;

        if (levels == -1) {
            return;
        
        } else {

            StdDraw.line(x, y, xEnd, yEnd);
            StdOut.println("Drawing level " + levels + " tree.");
            
            drawTree(xEnd, yEnd, length / 2, angle + increment, increment, levels);

            drawTree(xEnd, yEnd, length / 2, angle + increment, increment, levels);

        } 
    } 
} 
