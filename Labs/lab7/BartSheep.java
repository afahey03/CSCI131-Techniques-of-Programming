/*************************
* Name: Aidan Fahey
* Email: amfahe25@g.holycross.edu
* Date: 3/20/22
*
* Prints "I will not bring sheep to class." a times
*
* Example: java BartSheep
**************************/
public class BartSheep {
    public static void main(String args[]) {

        StdOut.println("How many sentences would you like?");
        int a = StdIn.readInt();

        for (int i = 0; i < a; i++) {
            StdOut.println("I will not bring sheep to class.");
        } // end of for loop

    } // end of main
} // end of class
