//**************************************************************************
// PickSongs.java
// Author: 
// Date:
// Class: CSCI 131
// Purpose: Interactively generate a randomized playlist from a list of songs.
//**************************************************************************

public class PickSongs {

    public static void main(String[] args) {

        // Load data from a file containing names of songs. 
        String[] songs = Playlist.readFromFile("songs.txt");

        // Print all the songs, in whatever order they happen to be, in a nicely
        // formatted list.
        StdOut.println("Here are the available songs:");
        // TODO: add code here.

        // Make a playlist containing n songs.
        StdOut.print("How many songs do you want in your playlist? ");
        int n = StdIn.readInt();
        String[] playlist = Playlist.generatePlaylist(songs, n);

        // Print the resulting playlist in a nicely formatted list.
        StdOut.println("Here is your playlist:");
        // TODO: add code here.

        // Extra credit: For each available title in the song list, calculate
        // how many times it appears in the playlist, and print the results.
        // Also make an array of the frequency each song is played, and make a
        // bar graph showing these frequencies. Ideally, the songs should be get
        // approximately equal play time, but by random chance some songs may
        // appear more often then others.
        // TODO: Add code here (extra credit).
    }
}
