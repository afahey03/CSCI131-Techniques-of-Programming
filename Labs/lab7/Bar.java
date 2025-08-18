/*************************
* Name: Aidan Fahey
* Email: amfahe25@g.holycross.edu
* Date: 3/24/22
*
* Repeatedly prints X n times
*
* Example: java Bar
**************************/
public class Bar {
    public static void repeatedlyPrintX(int n) {
        for (int i = 0; i < n; i++) {
            StdOut.print("X");
        } // end of for loop
        StdOut.println();
    } // end of repeatedlyPrintX
    public static void main(String[] args) {
        repeatedlyPrintX(10);
        repeatedlyPrintX(5);
        repeatedlyPrintX(7);
    } // end of main
} // end of class
