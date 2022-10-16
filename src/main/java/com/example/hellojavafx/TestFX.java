package com.example.hellojavafx;

import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author stroz
 */
public class TestFX extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        VBox vbox = new VBox();
        Button button = new Button("Knopf");

        vbox.getChildren().add(button);

        TextField txt = new TextField();

        vbox.getChildren().add(txt);

        vbox.setSpacing(15);
        //vbox.setPadding(new Insets(15));
        vbox.setAlignment(Pos.CENTER);
        stage.setTitle("Clicker-Tracker");
        Scene szene = new Scene(vbox);
        stage.setScene(szene);
        stage.show();
    }
    
}
