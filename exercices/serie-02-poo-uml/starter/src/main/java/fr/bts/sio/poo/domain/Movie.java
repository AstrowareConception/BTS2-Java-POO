package fr.bts.sio.poo.domain;

import java.time.Clock;

/**
 * Squelette de l'atelier 2. Le domaine ne doit dépendre ni de la console,
 * ni d'une base, ni de JavaFX.
 */
public final class Movie {
    private final Long id;
    private String title;
    private final int releaseYear;
    private int duration;
    private final Genre genre;
    private boolean archived;

    private Movie(Long id, String title, int releaseYear, int duration, Genre genre) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.genre = genre;
    }

    public static Movie create(String title, int releaseYear, int duration, Genre genre, Clock clock) {
        throw new UnsupportedOperationException("À implémenter");
    }

    public static Movie restore(long id, String title, int releaseYear, int duration,
                                Genre genre, boolean archived, Clock clock) {
        throw new UnsupportedOperationException("À implémenter");
    }

    public void rename(String newTitle) {
        throw new UnsupportedOperationException("À implémenter");
    }

    public void changeDuration(int newDuration) {
        throw new UnsupportedOperationException("À implémenter");
    }

    public void archive() {
        throw new UnsupportedOperationException("À implémenter");
    }

    public boolean isLong() {
        throw new UnsupportedOperationException("À implémenter");
    }

    public Long id() { return id; }
    public String title() { return title; }
    public int releaseYear() { return releaseYear; }
    public int duration() { return duration; }
    public Genre genre() { return genre; }
    public boolean archived() { return archived; }
}
