package org.prodigy_sd_02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("guessGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 540, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());


        stage.setTitle("Guessing Random Number");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}