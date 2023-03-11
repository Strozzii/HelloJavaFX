package com.example.hellojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Clicker extends Application {

    int count = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(20));

        //Button
        HBox hbox_button = new HBox();
        Button button = new Button("Drück mich!");
        button.setPadding(new Insets(20));
        hbox_button.getChildren().add(button);
        hbox_button.setAlignment(Pos.CENTER);
        hbox_button.setPadding(new Insets(10));

        //Label
        Label anzahl_Klicks = new Label("Anzahl Klicks: " + count);
        HBox hbox_anzahl = new HBox(20, anzahl_Klicks);

        //Button Funktionalität
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                count++;
                anzahl_Klicks.setText("Anzahl Klicks: " + count);
            }
        });

        //Textfeld
        Label name = new Label("Name");
        TextField txt_name = new TextField("Luca");
        txt_name.setPromptText("Dein Vorname");
        HBox hbox_name = new HBox(20, name, txt_name);
        hbox_name.setAlignment(Pos.CENTER);

        //Label Ausgabe Klicks
        Label ausgabe = new Label("");

        //Andere Buttons
        Button b1 = new Button("Auswertung");
        Button b2 = new Button("Zurücksetzen");
        HBox hbox_buttons = new HBox(5, b1, b2);
        hbox_buttons.setAlignment(Pos.CENTER);
        b1.setPadding(new Insets(6));
        b2.setPadding(new Insets(6));

        //Auswertung Funktion
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ausgabe.setText(txt_name.getText() + " hat " + count + "-mal geklickt.");
            }
        });

        //Zurücksetzen Funktion
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                count = 0;
                anzahl_Klicks.setText("Anzahl Klicks: 0");
                ausgabe.setText("");

            }
        });

        //Elemente der Layout-VBox hinzufügen
        vbox.getChildren().add(hbox_button);
        vbox.getChildren().add(hbox_anzahl);
        vbox.getChildren().add(hbox_name);
        vbox.getChildren().add(ausgabe);
        vbox.getChildren().add(hbox_buttons);


        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
