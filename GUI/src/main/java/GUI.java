import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;






public class GUI extends Application {

    ObservableList<Student> studentenListe = FXCollections.observableArrayList();
    ObservableList<Kurs> kursListe= FXCollections.observableArrayList();
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Layout.fxml"));



        // Szene
        Scene scene = new Scene(root);

        // +++++++++++++++++++++++++++++++++++++++++++++
        // Stage konfigurieren
        // +++++++++++++++++++++++++++++++++++++++++++++

        // Titel setzen
        stage.setTitle("AxxG - FXML Beispiel");

        // Szene setzen

        stage.setScene( scene);



        stage.setTitle("Hello JavaFX");
        stage.show();

    }


    public static void main(String[] args) {

        launch(args);

    }







}
