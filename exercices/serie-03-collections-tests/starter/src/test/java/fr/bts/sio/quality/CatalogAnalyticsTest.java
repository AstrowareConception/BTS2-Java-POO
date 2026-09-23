package fr.bts.sio.quality;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("À retirer progressivement dans l'atelier 4")
class CatalogAnalyticsTest {
    private final CatalogAnalytics analytics = new CatalogAnalytics();
    private final List<MovieData> movies = List.of(
            new MovieData(1, "Alien", 1979, 117, "Science-fiction", 8.5, false),
            new MovieData(2, "Parasite", 2019, 132, "Drame", 8.6, false),
            new MovieData(3, "Cléo de 5 à 7", 1962, 90, "Drame", 8.0, false),
            new MovieData(4, "Film archivé", 2024, 100, "Drame", 9.9, true)
    );

    @Test
    void filtersUsingProvidedPredicate() {
        List<MovieData> result = analytics.filter(movies, movie -> !movie.archived());
        assertEquals(List.of(1L, 2L, 3L), result.stream().map(MovieData::id).toList());
    }

    @Test
    void sortsNewestThenTitleWithoutMutatingInput() {
        List<MovieData> result = analytics.byNewestThenTitle(movies);
        assertEquals(List.of(4L, 2L, 1L, 3L), result.stream().map(MovieData::id).toList());
        assertEquals(1L, movies.getFirst().id());
    }

    @Test
    void returnsEmptyAverageForEmptyCatalog() {
        assertTrue(analytics.averageDuration(List.of()).isEmpty());
    }

    @Test
    void groupsByGenre() {
        var result = analytics.groupByGenre(movies);
        assertEquals(3, result.get("Drame").size());
        assertEquals(1, result.get("Science-fiction").size());
    }

    @Test
    void topRatedRejectsNegativeLimit() {
        assertThrows(IllegalArgumentException.class,
                () -> analytics.topRated(movies, -1));
    }
}
