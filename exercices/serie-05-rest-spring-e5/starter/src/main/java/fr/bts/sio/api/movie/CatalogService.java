package fr.bts.sio.api.movie;

import java.util.List;

public interface CatalogService {
    List<MovieResponse> search(String query, int page, int size);
    MovieResponse findById(long id);
    MovieResponse create(CreateMovieRequest request);
    void archive(long id);
}
