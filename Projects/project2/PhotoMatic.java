/****************************************************************************
* Author: Aidan Fahey
* Date: 3/14/21
* Email: amfahe25@g.holycross.edu
*
* Prints an image and has various commands
*
* Ex: java PhotoMatic Presidents.jpg
*****************************************************************************/

import java.awt.Color;

public class PhotoMatic {
    public static void main(String args[]) {

        Picture picA = new Picture("Presidents.jpg");
        int w = picA.width();
        int h = picA.height();

        String inputFileName = args[0];

        StdOut.println("Welcome to PhotoMatic!");
        StdOut.println(args[0] + " size is " + w + " x " + h + " pixels.");
        StdOut.println("Possible options are:");
        StdOut.println("  show             -- display the image");
        StdOut.println("  grayscale        -- convert the image to grayscale");
        StdOut.println("  sepia            -- convert the image to sepia tone colors");
        StdOut.println("  save NAME        -- save the image using NAME as the filename");
        StdOut.println("  quit             -- quit the program");

        while (true) {
            StdOut.println("What would you like to do?");
            String choice = StdIn.readString();
            if (choice.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                System.exit(0);

            } else if (choice.equalsIgnoreCase("show")) {
                StdOut.println("Ok");
                picA.show();

            } else if (choice.equalsIgnoreCase("grayscale")) {
                StdOut.println(args[0] + " has been converted to grayscale.");
                Picture grayPic = new Picture(w, h);
                for (int y = 0; y < h; y++) {
                    for (int x = 0; x < w; x++) {
                        Color hue;
                        hue = picA.get(x, y);
                        int r = hue.getRed();
                        int g = hue.getGreen();
                        int b = hue.getBlue();
                        int z = (int) Math.round(0.299 * r + 0.587 * g + 0.114 * b);
                        Color gray = new Color (z, z, z);
                        grayPic.set(x, y, gray);
                    }
                }
                grayPic.save("Presidents.jpg");

            } else if (choice.equalsIgnoreCase("sepia")) {
                StdOut.println(args[0] + " has been converted to sepia.");
                double radius = 0.5 * Math.sqrt(w * w + h  *h);
                Picture sepiaPic = new Picture(w, h);
                for (int y = 0; y < h; y++) {
                    for (int x = 0; x < w; x++) {
                        Color hue;
                        hue = picA.get(x, y);
                        int r = hue.getRed();
                        int g = hue.getGreen();
                        int b = hue.getBlue();
                        double distanceFromCenter = Math.sqrt((x - w / 2) * (x - w / 2) + (y - h / 2 ) * (y - h / 2));
                        double darkenFactor = 1.0 - Math.pow(distanceFromCenter/radius, 3);
                        int tr = (int)Math.round(darkenFactor*(0.393 * r + 0.769 * g + 0.189 * b));
                        int tg = (int)Math.round(darkenFactor*(0.349 * r + 0.686 * g + 0.168 * b));
                        int tb = (int)Math.round(darkenFactor*(0.272 * r + 0.534 * g + 0.131 * b));
                        if (tr > 255) tr = 255;
                        if (tg > 255) tg = 255;
                        if (tb > 255) tb = 255;
                        Color sepia = new Color(tr, tg, tb);
                        sepiaPic.set(x, y, sepia);
                    }
                }
                sepiaPic.save("Presidents.jpg");

            } else if (choice.equalsIgnoreCase("censor")) {
                int left = StdIn.readInt();
                int top = StdIn.readInt();
                int right = StdIn.readInt();
                int bottom = StdIn.readInt();
                Color black = new Color(0, 0, 0);
                Picture censorPic = new Picture(w, h);
                StdOut.println("Ok");
                censorPic.save("Presidents.jpg");

            } else if (choice.equalsIgnoreCase("sharpen")) {

            } else if (choice.equalsIgnoreCase("save")) {
                String fileName = StdIn.readString();
                StdOut.println("Saving image as " + fileName);
                picA.save(fileName);

            } else {
                StdOut.println("Sorry, I don't know how to " + choice + ", try a different option.");
            }

        } // End of while loop

    } // End of main

} // End of class
