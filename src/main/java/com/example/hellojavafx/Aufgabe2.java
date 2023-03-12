package com.example.hellojavafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Aufgabe2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Kunde anlegen");

        // UI Elements

        // Kunden-ID
        Label kundenIdLabel = new Label("Kunden-ID");
        TextField kundenIdField = new TextField();
        final int kundenID = (int)(Math.random() * 10000000);
        kundenIdField.setText("" + kundenID);
        kundenIdField.setEditable(false);
        kundenIdField.setFocusTraversable(false);
        kundenIdField.setMouseTransparent(true);

        // Anrede
        Label anredeLabel = new Label("Anrede");
        ObservableList<String> anredeList = FXCollections.observableArrayList(
                "Keine Angabe", "Frau", "Herr", "Divers"
        );
        ComboBox<String> anredeComboBox = new ComboBox<>(anredeList);
        anredeComboBox.setValue("Keine Angabe");
        anredeComboBox.requestFocus();

        // Vorname
        Label vornameLabel = new Label("Vorname");
        TextField vornameField = new TextField();
        vornameField.setPromptText("Max");

        // Nachname
        Label nachnameLabel = new Label("Nachname");
        TextField nachnameField = new TextField();
        nachnameField.setPromptText("Mustermann");

        // Straße und Hausnummer
        Label strasseLabel = new Label("Straße und Hausnummer");
        TextField strasseField = new TextField();
        strasseField.setPromptText("Musterstraße 123");

        // Postleitzahl
        Label plzLabel = new Label("Postleitzahl");
        TextField plzField = new TextField();
        plzField.setPromptText("12345");

        // Ort
        Label ortLabel = new Label("Ort");
        TextField ortField = new TextField();
        ortField.setPromptText("Musterstadt");

        // Land
        Label landLabel = new Label("Land");
        ObservableList<String> landList = FXCollections.observableArrayList(
                "Deutschland", "Österreich"
        );
        ComboBox<String> landComboBox = new ComboBox<>(landList);
        landComboBox.setValue("Deutschland");

        // Bundesland
        Label bundeslandLabel = new Label("Bundesland");
        ObservableList<String> bundeslandList = FXCollections.observableArrayList(
                Laender.gibBundeslaender(landComboBox.getValue())
        );
        ComboBox<String> bundeslandComboBox = new ComboBox<>(bundeslandList);

        landComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                bundeslandComboBox.getItems().clear();
                ObservableList<String> bundeslandList = FXCollections.observableArrayList(
                        Laender.gibBundeslaender(landComboBox.getValue())
                );
                bundeslandComboBox.setItems(bundeslandList);
            }
        });

        // Telefonnummer
        Label nummerLabel = new Label("Telefonnummer");
        TextField nummerField = new TextField();
        nummerField.setPromptText("01234-56789");
        nummerField.setMinWidth(300);

        // E-Mail
        Label mailLabel = new Label("E-Mail");
        TextField mailField = new TextField();
        mailField.setPromptText("max.mustermann@mustermail.de");
        mailField.setMinWidth(300);

        // Bank
        Label bankLabel = new Label("Bankverbindung");
        CheckBox bankCheckBox = new CheckBox("Wie Kunde");
        TextField inhaberField = new TextField();
        TextField ibanField = new TextField();
        TextField bicField = new TextField();
        TextField bankField = new TextField();
        inhaberField.setPromptText("Kontoinhaber");
        ibanField.setPromptText("IBAN");
        bicField.setPromptText("BIC");
        bankField.setPromptText("Bank");

        bankCheckBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(bankCheckBox.isSelected()){
                    inhaberField.setText(vornameField.getText() + " " + nachnameField.getText());
                } else {
                    inhaberField.clear();
                }
            }
        });

        // Buttons
        Button saveButton = new Button("Speichern");
        Button abortButton = new Button("Abbrechen");

        // Content
        HBox hboxKundenID = new HBox(5, kundenIdLabel, kundenIdField);

        HBox hboxAnrede = new HBox(5, anredeLabel, anredeComboBox);

        VBox vboxVorname = new VBox(vornameLabel, vornameField);
        VBox vboxNachname = new VBox(nachnameLabel, nachnameField);
        HBox hboxName = new HBox(5, vboxVorname, vboxNachname);

        VBox vboxStrasse = new VBox(strasseLabel, strasseField);
        HBox hboxStrasse = new HBox(5, vboxStrasse);

        VBox vboxPLZ = new VBox(plzLabel, plzField);
        VBox vboxOrt = new VBox(ortLabel, ortField);
        HBox hboxOrt = new HBox(5, vboxPLZ, vboxOrt);

        VBox vboxLand = new VBox(landLabel, landComboBox);
        VBox vboxBundesland = new VBox(bundeslandLabel, bundeslandComboBox);
        HBox hboxLand = new HBox(5, vboxLand, vboxBundesland);

        VBox vboxNummer = new VBox(nummerLabel, nummerField);
        HBox hboxNummer = new HBox(5, vboxNummer);

        VBox vboxMail = new VBox(mailLabel, mailField);
        HBox hboxMail = new HBox(5, vboxMail);

        HBox hboxBank = new HBox(10, bankLabel, bankCheckBox);
        VBox vboxbank = new VBox(5, hboxBank, inhaberField, ibanField, bicField, bankField);
        HBox hboxBankData = new HBox(5, vboxbank);

        HBox hboxButton = new HBox(5, saveButton, abortButton);


        VBox main_vbox = new VBox(23, hboxKundenID, hboxAnrede, hboxName, hboxStrasse, hboxOrt, hboxLand, hboxNummer, hboxMail, hboxBankData, hboxButton);
        main_vbox.setPadding(new Insets(20));
        Scene scene = new Scene(main_vbox);
        primaryStage.setScene(scene);
        primaryStage.show();







    }
}
