import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class newPersonController  implements Initializable {
    University uni;


    @FXML
    private ChoiceBox<String> choicebox;

    @FXML
    private TextField nameTextfield;

    @FXML
    private TextField PrenameTextfield;

    @FXML
    private Slider javaSkill;

    @FXML
    void createnewStudent(ActionEvent event) {


        uni.addnewStudent(0,nameTextfield.getText(), PrenameTextfield.getText(), choicebox.getValue(),javaSkill.getMinorTickCount(), 2);



    }




    public void setUni(University uni){
        this.uni= uni;
        ObservableList<Kurs> kursList=uni.getKursList();
        ObservableList<String> kursNameList = FXCollections.observableArrayList();

        for(Kurs e : kursList) {
            kursNameList.add(e.getKursname());
        }

        ArrayList<String> test = new ArrayList<>();
        test.add("Hallo");

        choicebox.setItems(kursNameList);



    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
