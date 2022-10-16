package com.example.hellojavafx;

import javafx.application.Application;
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
        int count = 0;
        Label anzahl_Klicks = new Label("Anzahl Klicks: " + count);
        HBox hbox_anzahl = new HBox(20, anzahl_Klicks);

        //Textfeld
        Label name = new Label("Name");
        TextField txt_name = new TextField("Luca");
        txt_name.setPromptText("Dein Vorname");
        HBox hbox_name = new HBox(20, name, txt_name);
        hbox_name.setAlignment(Pos.CENTER);

        //Label Ausgabe Klicks
        Label ausgabe = new Label("ifhsfsf");

        //Andere Buttons
        Button b1 = new Button("Auswertung");
        Button b2 = new Button("Zurücksetzen");
        HBox hbox_buttons = new HBox(5, b1, b2);
        hbox_buttons.setAlignment(Pos.CENTER);


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
