package fr.bts.sio.desktop.ui;

import fr.bts.sio.desktop.domain.MovieRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public final class CatalogController {
    @FXML private TextField searchField;
    @FXML private TableView<MovieRow> movieTable;
    @FXML private Label statusLabel;

    private final ObservableList<MovieRow> rows = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        movieTable.setItems(rows);
        statusLabel.setText("Starter prêt — à vous de construire le catalogue");
    }

    @FXML
    private void onSearch() {
        throw new UnsupportedOperationException("Atelier 2 : déléguer au service");
    }

    @FXML
    private void onAddMovie() {
        throw new UnsupportedOperationException("Atelier 2 : ouvrir le formulaire");
    }
}
