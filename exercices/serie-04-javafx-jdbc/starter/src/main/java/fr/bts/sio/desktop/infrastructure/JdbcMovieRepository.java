package fr.bts.sio.desktop.infrastructure;

import fr.bts.sio.desktop.application.MovieRepository;
import fr.bts.sio.desktop.domain.MovieRow;

import java.util.List;
import java.util.Optional;

public final class JdbcMovieRepository implements MovieRepository {
    private final ConnectionFactory connectionFactory;

    public JdbcMovieRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public MovieRow save(MovieRow movie) {
        throw new UnsupportedOperationException("Atelier 4 : INSERT préparé et clé générée");
    }

    @Override
    public Optional<MovieRow> findById(long id) {
        throw new UnsupportedOperationException("Atelier 4 : SELECT et mapping");
    }

    @Override
    public List<MovieRow> search(String query) {
        throw new UnsupportedOperationException("Atelier 4 : recherche préparée");
    }

    @Override
    public void archive(long id) {
        throw new UnsupportedOperationException("Atelier 4 : UPDATE contrôlé");
    }
}
