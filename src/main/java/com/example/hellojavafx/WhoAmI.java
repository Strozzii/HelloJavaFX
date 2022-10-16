package com.example.hellojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class WhoAmI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        VBox vbox = new VBox(23);

        //First element
        HBox hbox1 = new HBox(15);
        Label whoami = new Label("Wer bin ich?");
        hbox1.getChildren().add(whoami);
        TextField txt1 = new TextField();
        hbox1.getChildren().add(txt1);

        //Second element
        HBox hbox2 = new HBox(15);
        Label hobbies = new Label("Hobbys");
        CheckBox cb1 = new CheckBox("Lesen");
        CheckBox cb2 = new CheckBox("Programmieren");
        CheckBox cb3 = new CheckBox("Netflix");
        VBox hobby_checkboxes = new VBox(cb1,cb2,cb3);
        hbox2.getChildren().add(hobbies);
        hbox2.getChildren().add(hobby_checkboxes);

        //Third element
        HBox hbox3 = new HBox(15);
        Label tiere = new Label("Lieblingstier");
        ToggleGroup tier_group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Hund");
        RadioButton rb2 = new RadioButton("Katze");
        RadioButton rb3 = new RadioButton("Maus");
        rb1.setToggleGroup(tier_group);
        rb2.setToggleGroup(tier_group);
        rb3.setToggleGroup(tier_group);
        VBox tiere_radiobuttons = new VBox(rb1,rb2,rb3);
        hbox3.getChildren().add(tiere);
        hbox3.getChildren().add(tiere_radiobuttons);

        //Fourth element
        HBox hbox4 = new HBox(15);
        Label farbe = new Label("Lieblingsfarbe");
        ChoiceBox<String> cb_farbe = new ChoiceBox<String>();
        cb_farbe.getItems().add("Rot");
        cb_farbe.getItems().add("Gelb");
        cb_farbe.getItems().add("Grün");
        cb_farbe.getItems().add("Blau");
        cb_farbe.getItems().add("Lila");
        cb_farbe.getItems().add("Orange");
        cb_farbe.getItems().add("Weiss");
        hbox4.getChildren().add(farbe);
        hbox4.getChildren().add(cb_farbe);

        //Fifth element
        VBox vbox_output = new VBox();
        Button button_output = new Button("Anzeigen");
        vbox_output.getChildren().add(button_output);

        //Sixth element
        Label l1 = new Label();
        Label l2 = new Label();
        Label l3 = new Label();
        Label l4 = new Label();
        VBox output = new VBox(l1, l2, l3, l4);

        //Eventhandler for button
        button_output.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                //Mein Name ist
                String n = txt1.getText();
                String name = n.equals("") ? "Ich bin anonym unterwegs."
                                                     : "Ich heiße " + n + ".";
                //Lieblingstier
                RadioButton r = (RadioButton) tier_group.getSelectedToggle();
                String x = r == null ? "keines."
                                     : r.getText();
                String tier = "Mein Lieblingstier ist ";
                if(x.equals("Katze") || x.equals("Maus")){
                    x = "die " + x;
                } else if (x.equals("Hund")) {
                    x = "der " + x;
                }
                tier = tier + x;

                //List of Hobbies
                List<String> hobbyList = new ArrayList<>();
                String delimiter = ", ";
                String hobbys = "Ich habe keine Hobbys.";
                if(cb1.isSelected()){
                    hobbyList.add(cb1.getText());
                }
                if(cb2.isSelected()){
                    hobbyList.add(cb2.getText());
                }
                if(cb3.isSelected()){
                    hobbyList.add(cb3.getText());
                }

                StringJoiner joiner = new StringJoiner(delimiter);
                hobbyList.forEach(item -> joiner.add(item));

                if(hobbyList.size() == 1){
                    hobbys = "Mein Hobby ist " + joiner.toString() + ".";
                } else if(hobbyList.size() > 1) {
                    hobbys = "Meine Hobbys sind " + joiner.toString() + ".";
                }

                //Lieblingsfarbe
                String c = cb_farbe.getValue();
                String farbe = c == null ? "Meine Lieblingsfarbe ist keine."
                                                           : "Meine Lieblingsfarbe ist " + c + ".";

                //Texte der Labels setzen
                l1.setText(name);
                l2.setText(tier);
                l3.setText(hobbys);
                l4.setText(farbe);
            }
        });

        //Adding elements to Layout
        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
        vbox.getChildren().add(hbox3);
        vbox.getChildren().add(hbox4);
        vbox.getChildren().add(vbox_output);
        vbox.getChildren().add(output);
        vbox.setPadding(new Insets(15));

        //Stage config
        Scene scene = new Scene(vbox, 320, 400);
        stage.setScene(scene);
        stage.setTitle("Wer bin ich?");
        stage.setResizable(false);
        stage.show();
    }
}
