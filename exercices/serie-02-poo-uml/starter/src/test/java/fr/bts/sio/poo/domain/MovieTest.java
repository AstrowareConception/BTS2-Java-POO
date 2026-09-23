package fr.bts.sio.poo.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("À activer dans l'atelier 2")
class MovieTest {
    private final Clock clock = Clock.fixed(Instant.parse("2026-01-15T10:00:00Z"), ZoneOffset.UTC);

    @Test
    void createsNormalizedValidMovie() {
        Movie movie = Movie.create("  Alien  ", 1979, 117, Genre.SCIENCE_FICTION, clock);

        assertAll(
                () -> assertEquals("Alien", movie.title()),
                () -> assertEquals(1979, movie.releaseYear()),
                () -> assertEquals(117, movie.duration()),
                () -> assertFalse(movie.archived())
        );
    }

    @Test
    void rejectsBlankTitle() {
        assertThrows(IllegalArgumentException.class,
                () -> Movie.create("  ", 2020, 90, Genre.DRAMA, clock));
    }

    @Test
    void rejectsImpossibleDuration() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Movie.create("Test", 2020, 0, Genre.DRAMA, clock)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Movie.create("Test", 2020, 601, Genre.DRAMA, clock))
        );
    }

    @Test
    void considersMovieLongFrom120Minutes() {
        assertTrue(Movie.create("Long", 2020, 120, Genre.DRAMA, clock).isLong());
        assertFalse(Movie.create("Court", 2020, 119, Genre.DRAMA, clock).isLong());
    }
}
