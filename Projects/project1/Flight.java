/**********************************************************************************************************
* Name: Aidan Fahey
* Email: amfahe25@g.holycross.edu
* Partners: None
* 
* Objective: Calculate the distance between London and Czestochowa
*
* Example: java Flight 51.5072 N 0.1276 W 50.811817 N 19.120310 E
***********************************************************************************************************/

public class Flight {
     public static void main(String args[]) {

        final double earthRadius = 3963.1676;

        double lat1 = Double.parseDouble(args[0]);
        char homeNorthSouth = args[1].charAt(0);
        double long1 = Double.parseDouble(args[2]);
        char homeEastWest = args[3].charAt(0);

        double lat2 = Double.parseDouble(args[4]);
        char destNorthSouth = args[5].charAt(0);
        double long2 = Double.parseDouble(args[6]);
        char destEastWest = args[7].charAt(0);

        StdOut.println("Home latitude is " + lat1 + " " + homeNorthSouth + ".");
        StdOut.println("Home longitude is " + long1 + " " + homeEastWest + ".");

        StdOut.println("Destination latitude is " + lat2 + " " + destNorthSouth + ".");
        StdOut.println("Destination longitude is " + long2 + " " + destEastWest + ".");
    
        if (!args[1].equals("N") || !args[1].equals("S") || !args[5].equals("N") || !args[5].equals("S"));
        if (!args[3].equals("E") || !args[3].equals("W") || !args[7].equals("E") || !args[7].equals("W")); 

        if (lat1 < 0);
        if (lat1 > 90);
        if (long1 < 0);
        if (long1 > 180);
        if (lat2 < 0);
        if (lat2 > 90);
        if (long2 < 0);
        if (long2 > 180);

        if (homeNorthSouth == 'S') {
            lat1 = lat1 * -1.0;
        } // end of negative home N/S if-statement
        if (homeEastWest == 'W') {
            long1 = long1 * -1.0;
        } // end of negative home E/W if-statement
        if (destNorthSouth == 'S') {
            lat2 = lat2 * -1.0;
        } // end of negative destination N/S if-statement
        if (destEastWest == 'W') {
            long2 = long2 * -1.0;
        } // end of negative destination E/W if-statement

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(long2 - long1);
        double haver = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double endOfFormula = 2 * Math.atan2(Math.sqrt(haver), Math.sqrt(1 - haver));
        double distance = earthRadius * endOfFormula;

        String url = "https://www.mapquestapi.com/staticmap/v4/getmap?key=t8xhSEnIxadDAwSL0fSuJer5JAWqGPZ5&size=400,400&type=map&bestfit=51.5072,0.1276,50.811817,19.120310&pois=A,51.5072,0.1276%7CB,50.811817,19.120310&polyline=color:0xff0000%7Cwidth:3%7C42.2381,71.8109,27.175,78.0422";

        StdOut.println("The distance from home to destination is " + distance + " miles.");
        StdOut.println("Would you like to see a map of your trip?");
        String answer = StdIn.readString();

        if (answer.equalsIgnoreCase("Yes")) {
            StdOut.println("You said yes!");

            StdOut.println("Right-click this link or copy it to your browser:");
            StdOut.println(url);
            StdDraw.picture(0.5, 0.5, url);
        } // end of map if-statement

    } // end of main
} // end of public class