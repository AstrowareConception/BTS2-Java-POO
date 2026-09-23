package fr.bts.sio.desktop.application;

import fr.bts.sio.desktop.domain.MovieRow;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    MovieRow save(MovieRow movie);
    Optional<MovieRow> findById(long id);
    List<MovieRow> search(String query);
    void archive(long id);
}
