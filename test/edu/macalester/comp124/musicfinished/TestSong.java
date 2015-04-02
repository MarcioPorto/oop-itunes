package edu.macalester.comp124.musicfinished;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestSong {

    @Test
    public void testToString() {
        Song song = new Song("/home/shilad/foo.mp3", "Giant Steps", "John Coltrane", "Naima");
        String s = song.toString();
        assertTrue(s.contains("Giant Steps"));
        assertTrue(s.contains("Naima"));
        assertTrue(s.contains("Coltrane"));
        assertTrue(s.contains("foo.mp3"));
    }
}
