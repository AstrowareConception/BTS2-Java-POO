package fr.bts.sio.quality;

import java.util.Objects;

public record MovieData(
        long id,
        String title,
        int releaseYear,
        int duration,
        String genre,
        double rating,
        boolean archived
) {
    public MovieData {
        Objects.requireNonNull(title, "title");
        Objects.requireNonNull(genre, "genre");
    }
}
