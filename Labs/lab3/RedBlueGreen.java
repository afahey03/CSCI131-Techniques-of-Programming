/*----------------------------------------------------------------
 *  Author:   K. Walsh
 *  Email:    kwalsh@holycross.edu
 *  Written:  7/4/2015
 *  Updated:  7/7/2015 - renamed from Dice to RedBlueGreen
 *  Editor:   Aidan Fahey
 *  Email:    amfahe25@g.holycross.edu
 *  Edited:   2/14/2022
 *  
 *  User picks a color and the program simulates rolling two dice.
 *
 *  Example: java RedBlueGreen blue
 *  Output: You picked blue and rolled a pair of 3s.
 *----------------------------------------------------------------*/

public class RedBlueGreen {
    public static void main(String[] args) {
        // Error check: ensure one command-line argument was provided.
        if (args.length != 1) {
            System.out.println("Please provide one command line argument.");
            System.out.println("For example: java RedBlueGreen blue");
            System.exit(1);
        }

        // Put the command-line argument into a variable.
        String pick = args[0]; // the user's guess
        if (!pick.equalsIgnoreCase("red") && !pick.equalsIgnoreCase("blue") && !pick.equalsIgnoreCase("green")) {
            System.out.println("Error: Please pick red, blue, or green");
            System.exit(1);
        }

        // Pick two random integers each between 1 and 6, inclusive.
        int a = (int) (1 + Math.random() * 6); // first dice
        int b = (int) (1 + Math.random() * 6); // second dice
        int c = 0;
        if (a == b) {
            c = (2 * a); // allows for two dice to be the same value
        } else {
            c = (a + b);
        }

        String rgb = "";
        if (c == 8) {
            rgb = "green"; // designates numbers to colors
        } else if (c % 2 == 0) {
            rgb = "blue";
        } else if (c % 2 == 1) {
            rgb = "red";
        }
        // Print the results.
        if (a == b) {
            System.out.print("You picked " + pick);
            System.out.println(" and rolled a pair of " + a + "s.");
            System.out.println("The sum is " + c + ".");
            System.out.println("The result is " + rgb + ".");
        } else {
            System.out.print("You picked " + pick);
            System.out.println(" and rolled a " + a + " and a " + b + ".");
            System.out.println("The sum is " + c + ".");
            System.out.println("The result is " + rgb + ".");
        }
        if (pick.equals(rgb) && c == 8) {
            System.out.println("You win!");
            System.out.println("Your prize is $4.");
        } else if (pick.equals(rgb)) {
            System.out.println("You win!");
            System.out.println("Your prize is $1.");
        } else if (!pick.equals(rgb)) {
            System.out.println("Sorry, you lost!");
        }

    } // end of main
} // end of RedBlueGreen
