package fr.bts.sio.api.movie;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Implémentation temporaire permettant de démarrer l'API.
 * À remplacer par le domaine, le service applicatif et le repository des ateliers.
 */
@Service
public final class StarterCatalogService implements CatalogService {
    private final AtomicLong ids = new AtomicLong();

    @Override
    public List<MovieResponse> search(String query, int page, int size) {
        return List.of();
    }

    @Override
    public MovieResponse findById(long id) {
        throw new UnsupportedOperationException("Atelier 2 : traduire l'absence en 404");
    }

    @Override
    public MovieResponse create(CreateMovieRequest request) {
        return new MovieResponse(ids.incrementAndGet(), request.title().strip(),
                request.releaseYear(), request.duration(), request.genreId(), false);
    }

    @Override
    public void archive(long id) {
        throw new UnsupportedOperationException("Atelier 2 : implémenter l'archivage");
    }
}
