/*************************
* Name: Aidan Fahey
* Email: amfahe25@g.holycross.edu
* Date: 3/20/22
*
* Prints a row of X's next to the name of an animal
*
* Example: java LabeledBar
**************************/
public class LabeledBar {
    public static void labeledBar(String label, int n) {
        StdOut.print(label + " ");
        Bar.repeatedlyPrintX(n);
    } // end of labeledBar
    public static void main(String[] args) {
        labeledBar("dog", 10);
        labeledBar("cat", 5);
        labeledBar("rat", 7);
    } // end of main
} // end of class
