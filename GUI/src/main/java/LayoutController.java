import javafx.collections.FXCollections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TabPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LayoutController implements Initializable {

    University uni= new University();
    TabPane tabPane = new TabPane();



    @FXML
    private Tab tabStudenten;

    @FXML
    private Tab students;
    @FXML
    private TableView<Student> studentsTable;


    @FXML
    private TableColumn<Student, String> matrikelNummer;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TableColumn<Student, String> vorname;

    @FXML
    private TableColumn<Student, String> kurs;




    @FXML
    private TableColumn<Student, String> javaLevel;

    @FXML
    void newObject(ActionEvent event) {
        if(tabStudenten.isSelected()) {
            try {
                Stage stage = new Stage();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newPerson.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                newPersonController controller = fxmlLoader.<newPersonController>getController();
                controller.setUni(uni);
                stage.setTitle("Register");
                stage.setScene(new Scene(root, 450, 450));
                stage.show();
            } catch (Exception e) {
                System.out.println("Can't load new Person window");
            }
        }

    }


    @FXML
    private Tab tabKurse;


    @FXML
    private TableView<Kurs> kursTable;

    @FXML
    private TableColumn<Kurs, String> Kursname;

    @FXML
    private TableColumn<Kurs, String> Raumnummer;

    @FXML
    void deletePerson(ActionEvent event) {

        if(tabStudenten.isSelected()) {
            ObservableList<Student> selectedStundent = studentsTable.getSelectionModel().getSelectedItems();

            selectedStundent.forEach((a) -> {
                uni.deleteStudent(a);
            });
        }
        if(tabKurse.isSelected()) {
            ObservableList<Kurs> selectedKurse = kursTable.getSelectionModel().getSelectedItems();

            selectedKurse.forEach((e) -> {
                kursListe.remove(e);
            });
        }
    }






    ObservableList<Student> studentenListe = FXCollections.observableArrayList();
    ObservableList<Kurs> kursListe= FXCollections.observableArrayList();


    public void initialize(URL url, ResourceBundle rb) {



        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        vorname.setCellValueFactory(new PropertyValueFactory<Student, String>("prename"));
        kurs.setCellValueFactory(new PropertyValueFactory<Student, String>("kursNumber"));
        javaLevel.setCellValueFactory(new PropertyValueFactory<Student, String>("javaSkill"));
        matrikelNummer.setCellValueFactory(new PropertyValueFactory<Student, String>("matrikelnummer"));

        studentenListe = uni.newStudentList();




        studentsTable.setItems(studentenListe);


        studentsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);





        Kursname.setCellValueFactory(new PropertyValueFactory<Kurs, String>("kursname"));
        Raumnummer.setCellValueFactory(new PropertyValueFactory<Kurs, String>("raum"));

        kursListe= uni.newKursList();

        kursTable.setItems(kursListe);




    }


}