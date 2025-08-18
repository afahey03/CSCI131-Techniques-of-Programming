//**************************************************************************
// ShuffleSongs.java
// Author: 
// Date:
// Class: CSCI 131
// Purpose: Shuffle the songs in a playlist.
//**************************************************************************

public class ShuffleSongs {

    public static void main(String[] args) {

        // Load data from a file containing names of songs. 
        String[] songs = Playlist.readFromFile("songs.txt");

        // Shuffle them into random order.
        Playlist.shuffle(songs);

        // Print out the shuffled list.
        // Number each line of output for the user's convenience, and align the
        // columns, e.g.:
        // ###  Title                  Artist                           mm:ss
        //   1. Happy                  Pharrell Williams                 3:24
        //   2. Southern Cross         Crosby, Stills, Nash and Young    2:30
        // .... ...                    ...                              ..:..
        StdOut.printf("###  %-30s %-30s mm:ss\n", "Title", "Artist");
        for (int i = 0; i < songs.length; i++) {
            StdOut.printf("%3d. %-30s %-30s %5s\n",
                    i+1,
                    Playlist.getSongTitle(songs[i]),
                    Playlist.getSongArtist(songs[i]),
                    Playlist.getSongDuration(songs[i]));
        }

        // Also calculate and print the minimum, maximum, average, and total
        // duration of the songs.
        int[] durations = new int[songs.length]; // length of each song, in seconds
        // TODO: Add code here to fill out the array then calculate and print...
        // StdOut.printf("   Shortest song: %7s\n", ...);
        // StdOut.printf("    Longest song: %7s\n", ...);
        // StdOut.printf("    Average song: %7s\n", ...);
        // StdOut.printf("  Total duration: %7s\n", ...);
    }
}
