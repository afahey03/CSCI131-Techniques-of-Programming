/*----------------------------------------------------------------
 *  Author:   K. Walsh
 *  Email:    kwalsh@holycross.edu
 *  Written:  7/4/2015
 *  Updated:  7/7/2015 - added better comments
 *  
 *  A simulation of an n-sided dice roll.
 *
 *  Example: java Dice 6
 *
 *----------------------------------------------------------------*/

public class Dice {
   public static void main(String args[]) {

      int n = Integer.parseInt(args[0]);

      double r = Math.random();
      double bigger = r * n;
      long answer = Math.round(bigger + 0.5);
      System.out.println("Using a 6 sided dice, you rolled a " + answer + ".");
   }
}
