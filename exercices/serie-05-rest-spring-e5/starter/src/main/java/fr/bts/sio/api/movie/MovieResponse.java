package fr.bts.sio.api.movie;

public record MovieResponse(
        long id,
        String title,
        int releaseYear,
        int duration,
        long genreId,
        boolean archived
) {
}
