package fr.bts.sio.quality;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public final class CatalogAnalytics {
    public List<MovieData> filter(List<MovieData> movies, Predicate<MovieData> predicate) {
        throw new UnsupportedOperationException("À implémenter");
    }

    public List<MovieData> byNewestThenTitle(List<MovieData> movies) {
        throw new UnsupportedOperationException("À implémenter");
    }

    public OptionalDouble averageDuration(List<MovieData> movies) {
        throw new UnsupportedOperationException("À implémenter");
    }

    public Map<String, List<MovieData>> groupByGenre(List<MovieData> movies) {
        throw new UnsupportedOperationException("À implémenter");
    }

    public List<MovieSummary> topRated(List<MovieData> movies, int limit) {
        throw new UnsupportedOperationException("À implémenter");
    }
}
