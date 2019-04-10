package ru.geekbrains.lesson4.javafx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Пример простейшего JavaFX приложения
 * Можно использовать как основу для ДЗ
 */
public class JavaFxApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/scene.fxml"));
        Parent root = loader.load();
        Controller ctrl = loader.getController();
        ctrl.setPrimaryStage(primaryStage);

        primaryStage.setTitle("Network Chat");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinHeight(450);
        primaryStage.setMinWidth(600);
        primaryStage.show();
    }
}
