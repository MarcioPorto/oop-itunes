package edu.macalester.comp124.music;

import acm.program.ConsoleProgram;

/**
 * Searches the "iTunes Music Library.xml" file for a query.
 */
public class MusicSearcher extends ConsoleProgram {
    public static final String PATH = "itunes/iTunes Music Library.xml";

    public void run() {
        summarize();
        while (true) {
            String query = readLine("Enter search query, or stop to stop: ");
            if (query.equals("stop")) {
                break;
            }
            search(query);
        }
    }

    public void summarize() {
        ITunesReader reader = new ITunesReader(PATH);
        int numSongs = 0;
        while (true) {
            Song song = reader.readNextSong();
            if (song == null) {
                break;
            }
            numSongs++;
            if (song.getCount() >= 100) {
                println("popular song: " + song);
            }
        }
        println("num songs: " + numSongs);

    }

    public void search(String query) {
        ITunesReader reader = new ITunesReader(PATH);
        long start = System.currentTimeMillis();
        while (true) {
            Song song = reader.readNextSong();
            if (song == null) {
                break;
            }
            if (song.matchesQuery(query)) {
                println("  matching song: " + song.toString());
            }
        }
        long end = System.currentTimeMillis();
        double seconds = (end - start) / 1000.0;
        println("This search took " + seconds + " seconds");
    }
}

