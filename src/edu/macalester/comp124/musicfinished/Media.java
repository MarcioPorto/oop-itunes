package edu.macalester.comp124.musicfinished;

/**
 * A media object in an iTunes library that may be a
 * podcast, song, video, etc.
 * 
 * @author shilad
 */
public class Media {
	
	private String filePath;
	private String name;
	private int count;
	
	public Media(String filePath, String name, int count) {
		this.filePath = filePath;
		this.name = name;
		this.count = count;
	}

	public Media(String filePath, String name) {
        this(filePath, name, 0);
	}

	public String toString() {
		return "media: " + name + " at " + filePath + " with count " + count;
	}

	public boolean matchesQuery(String query) {
		return getName().toLowerCase().contains(query.toLowerCase());
	}

    public String getName() {
        return name;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        Media media = (Media) o;
        return (filePath.equals(media.filePath) && name.equals(media.name));
    }
}
