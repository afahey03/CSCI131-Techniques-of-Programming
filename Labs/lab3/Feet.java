/*----------------------------------------------------------------
 *  Author:   K. Walsh
 *  Email:    kwalsh@holycross.edu
 *  Written:  8/28/2021
 *  Editor:   Aidan Fahey
 *  Email:    amfahe25@g.holycross.edu
 *  Edited    2/14/2022
 *  Picks a random number and prints an example creature with that many feet, or prints the animal with the number of feet entered
 *
 *  Example: java Feet or java Feet 4
 *  Output: A starfish has 5 feet.
 *----------------------------------------------------------------*/

public class Feet {
  public static void main(String[] args) {
    int n; // number of feet
    String example; // name of creature with that many feet

    if (args.length == 1)
      n = Integer.parseInt(args[0]); // Choose desired number.
    else
      n = (int) (Math.random() * 17); // Calculate random number.

    // Determine an appropriate creature.
    // NOTE: We use the empty-string ("") to indicate
    // that no creature is known with that many feet.
    if (n == 0)
      example = "A snake";
    else if (n == 1)
      example = "A mollusc";
    else if (n == 2)
      example = "A duck";
    else if (n == 4)
      example = "A horse";
    else if (n == 5)
      example = "A starfish";
    else if (n == 6)
      example = "An ant";
    else if (n == 8)
      example = "An octopus";
    else if (n == 10)
      example = "A lobster";
    else if (n == 14)
      example = "An isopod";
    else if (n == 16)
      example = "A caterpillar";
    else if (n % 2 == 0 && n >= 30 && n <= 298) // Print "A centipede" when entering an even number [30-298]
      example = "A centipede";
    else if (n % 2 == 0 && n >= 300 && n <= 750) // Print "A millipede" when entering an even number [300-750]
      example = "A millipede";
    else
      example = ""; // no such creature

    // Print response, or an error message if no example was found.
    if (!example.equals(""))
      System.out.println(example + " has " + n + " feet.");
    else
      System.out.println("Sorry, I can't think of a creature with " + n + " feet.");

  } // end of main
} // end of Feet
