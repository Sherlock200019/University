import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
public class University {
    ObservableList<Kurs> kursList = FXCollections.observableArrayList();


    ObservableList<Student> studentsList = FXCollections.observableArrayList();
    Datenbank datenbank;

    public ObservableList<Kurs> getKursList() {
        return kursList;
    }

    public ObservableList<Student> getStudentsList() {
        return studentsList;
    }

    public University() {
        datenbank= new Datenbank();

    }

    public ObservableList<Kurs> newKursList(){
        ResultSet rs =datenbank.getValues("KURS_NAME, KURS_NR", "KURSE");
//        ResultSet rstwo= datenbank.getValues("RAUM_BEZEICHNUNG, RAUM_NR","RAUM","KURS_NR"+rs.getString("KURS_NR"));
        try {
            while (rs.next()) {
                kursList.add(new Kurs(rs.getString("KURS_NAME"), rs.getInt("KURS_NR"), "Dummy: E1.23"));
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return kursList;

    }

    public ObservableList<Student> newStudentList(){
        ResultSet rs =datenbank.getValues("MATRIKELNUMMER, KURS_ID, NAME, PRENAME, JAVAKNOWLEDGE", "STUDENTEN");
        try {
            while (rs.next()) {
                studentsList.add(new Student(  0, rs.getString("NAME"), rs.getString("PRENAME"), rs.getInt("KURS_ID"), rs.getInt("JAVAKNOWLEDGE"), rs.getInt("MATRIKELNUMMER")));
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return studentsList;

    }

    public void addnewStudent(int studentID, String name, String prename, String kursname, int javaSkill, int matrikelnummer){
        studentsList.add(new Student(studentID, name, prename, 0, javaSkill, matrikelnummer));
        datenbank.insertValues(" MATRIKELNUMMER, PRENAME, NAME,  JAVAKNOWLEDGE, KURS_ID", matrikelnummer+", '"+prename+"', '"+name+"', "+javaSkill+", Kurs_NR ", "STUDENTEN" , "KURSE",  "KURS_NAME", "'"+kursname+"'");

    }
    public void deleteStudent(Student student){
        studentsList.remove(student);


    }

    public void addnewKurs(String kursname, int kurs_identifier, String raum){
        kursList.add(new Kurs(kursname, kurs_identifier, raum));

    }
    public void deleteKurs(Student student){
        kursList.remove(student);

    }



}
