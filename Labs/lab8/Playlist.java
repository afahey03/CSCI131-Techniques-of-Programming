// Author: Aidan Fahey
// Date: 4/1/2022
//
// This is a library of functions for working with "Playlists", lists of songs.
// It is meant to be used as part of other programs.

public class Playlist {

    /* Given the name of a file, this function opens the file and reads
     * information about songs from the file, then returns an array containing
     * the list of the song details (in whatever order the songs appeared in the
     * file).
     *
     * Each line in the file should have details about one song, e.g.
     *     "Happy -- Pharrell Williams -- 3:24".
     * The format is:
     *    "Name of Song -- Name of Artist -- Song Duration"
     * Where the three pieces are separated by space-doubledash-space.
     *
     * Each entry in the list of songs returned will have this same format.
     */
    public static String[] readFromFile(String filename) {
        StdOut.printf("Loading song titles from %s ... ", filename);
        // First, we just count how many lines are in the file.
        In f = new In(filename);
        int numSongs = 0;
        while (f.hasNextLine()) {
            numSongs++;
            f.readLine(); // read and discard this line
        }
        f.close();
        StdOut.printf(" found %d songs\n", numSongs);
        // Next, create an array, open the file again, and read all the song
        // info. Close the file. Then return the array of song info.
        // TODO: Add code here.
        String[] songs;
        In g = new In(filename);
        while (g.hasNextLine()) {
            g.readLine();

        }

        return null; // TODO: REMOVE THIS LINE!
    }

    /* Given details about a song, this function extracts and returns just the
     * song title. For example, given "Happy -- Pharrell Williams -- 3:24", it
     * will return "Happy".
     */
    public static String getSongTitle(String song) {
        // Title is the part before the first space-doubledash-space sparator.
        int pos = song.indexOf(" -- ");
        return song.substring(0, pos);
    }

    /* Given details about a song, this function extracts and returns just the
     * artist name. For example, given "Happy -- Pharrell Williams -- 3:24", it
     * will return "Pharrell Williams".
     */
    public static String getSongArtist(String song) {
        // Artist is the part between the two space-doubledash-space sparators.
        int posA = song.indexOf(" -- ");
        int posB = song.lastIndexOf(" -- ");
        return song.substring(posA + 4, posB);
    }

    /* Given details about a song, this function extracts and returns just the
     * song duration. For example, given "Happy -- Pharrell Williams -- 3:24", it
     * will return "3:24".
     */
    public static String getSongDuration(String song) {
        // Duration is the part after the last space-doubledash-space sparator.
        int pos = song.lastIndexOf(" -- ");
        return song.substring(pos + 4);
    }

    /* Given a list of song details, this function shuffles the list into a
     * different, seemingly random order.
     */
    public static void shuffle(String[] songs) {
        // TODO: Add code here.

    }

    /* Given a list of song details, this function picks pick one at random and
     * return it. The list must not be empty, otherwise this will fail and
     * crash.
     */
    public static String pickSongAtRandom(String[] songs) {
        return songs[StdRandom.uniform(0, songs.length)];
    }

    /* Given a list of song details and a number n, this function picks n songs
     * at random to create a new playlist. The new playlist is returned. The
     * number n must be positive. Songs might be repeated in the playlist (e.g.
     * if n is larger than the number of songs available, or just by random
     * chance), and some songs might not be included at all in the playlist
     * (e.g. if n is smaller than the number of songs available, or just by
     * random chance).
     */
    // TODO: Add code here.
    // Extra Credit: Avoid picking the same song twice in a row.

    // TODO: Add other functions, as needed.
    

    public static void main(String[] args) {
        StdOut.println("Sorry, this class is a library meant to be used as part of other programs.");
    }

}
