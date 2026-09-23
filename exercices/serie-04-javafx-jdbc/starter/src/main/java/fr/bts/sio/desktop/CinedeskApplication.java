package fr.bts.sio.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public final class CinedeskApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/catalog-view.fxml"));
        Scene scene = new Scene(loader.load(), 960, 600);
        scene.getStylesheets().add(getClass().getResource("/styles/cinedesk.css").toExternalForm());
        stage.setTitle("CinéDesk — Starter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
