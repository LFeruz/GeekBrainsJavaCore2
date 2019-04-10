package ru.geekbrains.lesson4;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Network Chat");
        primaryStage.setScene(new Scene(new StackPane(), 300, 300));
        primaryStage.show();
    }
}
