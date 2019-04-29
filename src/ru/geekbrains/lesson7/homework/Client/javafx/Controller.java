package ru.geekbrains.lesson4.javafx;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    public TextArea messages;

    @FXML
    public TextField messageText;

    @FXML
    public Button sendButton;

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void onSendClicked() {
        // TODO реализовать добавление сообщений в TextArea messages


        showModalAlert("Network chat",
                "Message",
                "Message text",
                Alert.AlertType.INFORMATION,
                getRootStyleSheetUrl()
                );
    }

    private String getRootStyleSheetUrl() {
        ObservableList<String> stylesheets = primaryStage.getScene().getStylesheets();
        if (stylesheets != null && !stylesheets.isEmpty()) {
            return stylesheets.get(0);
        }
        return null;
    }

    private static void showModalAlert(String title, String header, String message, Alert.AlertType alertType, String cssUrl) {
        Alert alert = new Alert(alertType);

        if (cssUrl != null) {
            alert.getDialogPane().getStylesheets().add(cssUrl);
        }

        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);

        alert.showAndWait();
    }
}
