/*************************
* Name: Aidan Fahey
* Email: amfahe25@g.holycross.edu
* Date: 3/24/22
*
* Prints rectangles of given widths and heights
*
* Example: java Rect
**************************/
public class Rect {
    public static void printRectangle(int width, int height) {
        for (int i = 0; i < height; i++) {
            Bar.repeatedlyPrintX(width);
        } // end of for loop
    } // end of printRectangle
    public static void main(String[] args) {
        printRectangle(3, 2);
        printRectangle(5, 3);
        printRectangle(8, 1);
    } // end of main
} // end of class
