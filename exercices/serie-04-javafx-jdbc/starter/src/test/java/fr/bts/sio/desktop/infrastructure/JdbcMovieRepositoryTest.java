package fr.bts.sio.desktop.infrastructure;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled("À activer après avoir créé le mécanisme de migration et le repository")
class JdbcMovieRepositoryTest {
    @TempDir
    Path temporaryDirectory;

    @Test
    void createsIsolatedDatabaseForEachTest() {
        Path database = temporaryDirectory.resolve("catalog.sqlite");
        ConnectionFactory factory = new ConnectionFactory(database.toString());

        assertTrue(database.getParent().toFile().exists());
        // À compléter : appliquer le schéma, insérer, relire et vérifier les contraintes.
    }
}
