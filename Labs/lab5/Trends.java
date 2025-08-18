import java.util.Arrays;

//**************************************************************************
// Trends.java
// Author: Aidan Fahey
// Date: 2/28/22
// Class: CSCI 131
// Purpose: Compute a few basic statistics for a list of integers, using a
// completely-full array to hold the values. Data is taken from a file of
// climate data.
//**************************************************************************

public class Trends {

    public static void main(String[] args) {

        // Load data from a file containing historical climate data for
        // Worcester, MA. The data consists of a single number, the montly
        // average temperature, for each month starting in January 1900.
        StdOut.println("Loading data from worcester-temperature.txt ...");
        In infile = new In("worcester-temperature.txt");
        double[] data = infile.readAllDoubles();

        StdOut.print("Do you want to see all the data? [y or n] ");
        if (StdIn.readString().equalsIgnoreCase("y")) {
            // Print all temperature data, with spaces, and a newline between every 12 numbers.
            StdOut.println("There are " + data.length + " values in the array.");
            for (int i = 0; i < data.length; i++) {
                if (i % 12 == 0)
                    StdOut.println();
                StdOut.print(data[i] + " ");
            }
            StdOut.println( );
        }

        StdOut.println("The earliest year of data is from 1900.");
        int numYears = data.length / 12; // Number of years.
        int endYear = 2020; // Ending year.
        StdOut.println("The most recent year of data is from " + endYear + ".");
        StdOut.println("There are " + numYears + " years worth of data in all.");

        // Print out some statistics...

        // Print out average of all the data.
        double sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        double average = sum / (double)data.length;

        StdOut.print("Average temperature overall: " + average);
            
        StdOut.println( );                // Leave one blank line

        double firstDecadeSum = 0;
        for (int i = 0; i < 119; i++) {
            firstDecadeSum += data[i];
        }
        double firstDecadeAvg = firstDecadeSum / 120;

        StdOut.print("Average temperature for 1900-1909: " + firstDecadeAvg);
        StdOut.println( );                // Leave one blank line

        double lastDecadeSum = 0;
        for (int i = 1331; i < 1451; i++) {
            lastDecadeSum += data[i];
        }
        double lastDecadeAvg = lastDecadeSum / 120;

        StdOut.print("Average temperature for last decade: " + lastDecadeAvg);
        StdOut.println( );                // Leave one blank line

        // Let the user pick a month and year, and print out the data for just
        // that one month.
        StdOut.print("Pick a month and year, e.g. \"6 1999\": ");
        int month = StdIn.readInt();
        int year = StdIn.readInt();
        int yearValue = year - 1900;
        int total = yearValue + month;
        double yearAvg = data[total - 1];
        if (month > 12 || month < 1 || year > 2020 || year < 1900 ) {
            StdOut.println("Sorry, I don't have data for " + month + "/" + year + ".");
        } else {
            StdOut.println("Average temperature for " + month + '/' + year + ": " + yearAvg);
        }
        StdOut.println( );                // Leave one blank line

        // Declare and allocate an array of doubles to hold yearly averages.
        double[] yearlyAvg = new double[numYears];

        // Each value in the yearlyAvg array will represent the average over an
        // entire year worth of data. There will be one value for 1900, one
        // value for 1901, one value for 1902, etc., up to and including
        // endYear. For each year, calculate the average for the 12 months of
        // that year, and store this result in the appropriate place in the
        // yearlyAvg array.

        numYears = 1452 / 12;
        double yearlyTotal = 0;
        for (int i = 1; i <= numYears; i++) {
            int max = i * 12;
            int min = max - 12;
            for (int k = min; k <= month; k++) {
                yearlyTotal = yearlyTotal + data[i];
                double twelveMonthAvg = yearlyTotal / 12;
                yearlyAvg[i] = twelveMonthAvg;
            }
        }

        // Print all of the yearly averages.
        for (int yr = 1900; yr <= endYear; yr++) {
            StdOut.print("Average yearly temperature for " + yr + ": ");
            StdOut.println(yearlyAvg[yr-1900]);
        }

        // Examine each year from 1900 to endYear, inclusive. If that year was
        // particularly hot (more than 2 degrees above the overall average) or
        // particularly cold (more than 2 deegrees below the overall average),
        // then print a message saying so. Also identify and print out the
        // record-setting years (a year that is hotter or colder than all all
        // previous years).
        // TODO: Add code here.

    }
}
