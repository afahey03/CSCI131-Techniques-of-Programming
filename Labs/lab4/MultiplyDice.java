/*----------------------------------------------------------------
 *  Author: Aidan Fahey
 * 
 *  Goal: Roll and multiply dice 20 times and find the result's leading digit
 *
 *  Example: java MultiplyDice
 *----------------------------------------------------------------*/

public class MultiplyDice {

    public static void main(String[] args) { 

        long score = 1;
        long leadingDigit = 0;

        for (int i = 1; i < 21; i++) {
            int roll = StdRandom.uniform(1, 7);
            score = score * roll;
            System.out.println("You rolled " + roll + ", your score is now " + score + ".");
        } // end of for loop

        leadingDigit = score;
        while (leadingDigit > 10) {
            leadingDigit = leadingDigit / 10;
        }
        
        System.out.println("The leading digit is " + leadingDigit + ".");

    } // end of main

} // end of class MultiplyDice
