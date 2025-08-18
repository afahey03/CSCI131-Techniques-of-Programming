/*----------------------------------------------------------------
 * Author: Aidan Fahey
 * Email: amfahe25@g.holycross.edu
 * Written: 4/21/2022
 *
 * A class used for drawing a "box" sprite. 
 *
 * Example: java Box
 *----------------------------------------------------------------*/

import java.awt.Color;

public class Box {

    private double x, y;
    private double width, height;
    private Color border, fill;

    public Box(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.border = StdDraw.BLACK;
        this.fill = StdDraw.RED;
    }

    public void draw() {
        StdDraw.setPenColor(fill);
        StdDraw.filledRectangle(x, y, width/2, height/2);
        StdDraw.setPenColor(border);
        StdDraw.rectangle(x, y, width/2, height/2);
    }

    public double getLeft() {
        double leftEdge = x - width/2;
        return leftEdge;
    }

    public double getRight() {
        double rightEdge = x + width/2;
        return rightEdge;
    }

    public double getBottom() {
        double bottomEdge = y - height/2;
        return bottomEdge;
    }

    public double getTop() {
        double topEdge = y + height/2;
        return topEdge;
    }

    public boolean contains(double px, double py) {
        boolean contain = true;
        if (this.getLeft() <= px && px <= this.getRight() && this.getBottom() <= py && py <= this.getTop()) {
            contain = true;
        }
            return contain;
    }

    public void setFillColor(Color c) {
        this.fill = c;
    }

    public void setBorderColor(Color c) {
        this.border = c;
    }

    public boolean touching(Box other) {
        if (this.getBottom() > other.getTop()) {
            return false;
        }
        if (this.getTop() < other.getBottom()) {
            return false;
        }
        if (this.getLeft() > other.getRight()) {
            return false;
        }
        if (this.getRight() < other.getLeft()) {
            return false;
        }
        return true;
    }

}

