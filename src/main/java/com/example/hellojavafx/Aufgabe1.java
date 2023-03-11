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

public class Aufgabe1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //First Element
        HBox hbox1 = new HBox(23);
        Label label1 = new Label("Wer bin ich?");
        TextField txtfield1 = new TextField();
        hbox1.getChildren().addAll(label1, txtfield1);

        //Second Element
        HBox hbox2 = new HBox(23);
        Label label2 = new Label("Hobbys");
        CheckBox cb_read = new CheckBox("Lesen");
        CheckBox cb_coding = new CheckBox("Programmieren");
        CheckBox cb_netflix = new CheckBox("Netflix");
        VBox vbox_hobbies = new VBox(3, cb_read, cb_coding, cb_netflix);
        hbox2.getChildren().addAll(label2, vbox_hobbies);

        //Third Element
        HBox hbox3 = new HBox(23);
        Label label3 = new Label("Lieblingstier");
        RadioButton rb_dog = new RadioButton("Hund");
        RadioButton rb_cat = new RadioButton("Katze");
        RadioButton rb_mouse = new RadioButton("Maus");
        ToggleGroup tg_animals = new ToggleGroup();
        rb_dog.setToggleGroup(tg_animals);
        rb_cat.setToggleGroup(tg_animals);
        rb_mouse.setToggleGroup(tg_animals);
        VBox vbox_animals = new VBox(3, rb_dog, rb_cat, rb_mouse);
        hbox3.getChildren().addAll(label3, vbox_animals);

        //Fourth Element
        HBox hbox4 = new HBox(23);
        Label label4 = new Label("Lieblingsfarbe");
        ChoiceBox<String> chbox_color = new ChoiceBox<>();
        chbox_color.getItems().addAll("Rot", "Gelb", "Gruen", "Blau", "Lila", "Orange");
        hbox4.getChildren().addAll(label4, chbox_color);

        //Fifth Element
        HBox hbox5 = new HBox(23);
        Button button_show = new Button("Anzeigen");
        hbox5.getChildren().add(button_show);

        //Sixth Element
        HBox hbox6 = new HBox(23);
        Label label_name = new Label("");
        Label label_animal = new Label("");
        Label label_hobbies = new Label("");
        Label label_color = new Label("");
        VBox vbox_text = new VBox(label_name, label_animal, label_hobbies, label_color);
        hbox6.getChildren().add(vbox_text);

        // Button EventHandler
        button_show.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                // Name
                String name = txtfield1.getText();
                label_name.setText(
                        name.equals("")
                                ? "Ich bin anonym unterwegs."
                                : "Ich heiße " + name + "."
                        );

                // Animal
                String animal = "Mein Lieblingstier ist ";
                RadioButton selected = (RadioButton) tg_animals.getSelectedToggle();
                animal = animal + (selected == null
                        ? "keines."
                        : selected.getText() == "Hund"
                            ? "der Hund."
                            : selected.getText() == "Katze"
                                ? "die Katze."
                                : "die Maus.");
                label_animal.setText(animal);

                // Hobbies
                String hobbies = "Ich habe keine Hobbies.";
                List<String> hobbylist = new ArrayList<>();
                if(cb_read.isSelected()) hobbylist.add(cb_read.getText());
                if(cb_coding.isSelected()) hobbylist.add(cb_coding.getText());
                if(cb_netflix.isSelected()) hobbylist.add(cb_netflix.getText());
                String delim = ", ";
                StringJoiner joiner = new StringJoiner(delim);
                hobbylist.forEach(joiner::add);
                label_hobbies.setText(
                        hobbylist.size() == 1
                            ? "Mein Hobby ist " + joiner + "."
                            : hobbylist.size() > 1
                                ? "Meine Hobbies sind " + joiner + "."
                                : hobbies
                );

                // Color
                String color = "Meine Lieblingsfarbe ist ";
                color = color + (chbox_color.getValue() == null
                        ? "keine."
                        : chbox_color.getValue() + ".");
                label_color.setText(color);


            }
        });

        //Main Content
        VBox main_vbox = new VBox(23);
        main_vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5, hbox6);

        main_vbox.setPadding(new Insets(15));

        //Scene
        Scene scene = new Scene(main_vbox ,320, 420);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Wer bin ich?");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
