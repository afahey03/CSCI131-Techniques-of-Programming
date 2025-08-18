/*----------------------------------------------------------------
 *  TODO: Aidan Fahey
 *
 *  Checks whether the MultiplyDice game follows Benford's law.
 *
 *  Usage: java Benford count
 *  Example: java Benford 1000 3
 *----------------------------------------------------------------*/

public class Benford {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        long score = 1;
        int count = 0;
        long leadingDigit = 0;

        for (int counter = n; counter > 0; counter = counter - 1) {
            for (int i = 1; i < 21; i++) {
                int roll = StdRandom.uniform(1, 7);
                score = score * roll;
                leadingDigit = score;
                while (leadingDigit > 10) {
                leadingDigit = leadingDigit / 10; 
                }
                if (leadingDigit == k) {
                    count++;
                }
            }
        } // end of first for-loop


        System.out.println("Out of " + n + " games, a " + k + " appears as the leading digit");
        System.out.println("of the score " + count + " times, or " + (count * 100.0/n) + "% of the time.");

    } // end of main

} // end of Benford
