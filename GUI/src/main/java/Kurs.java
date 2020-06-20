import java.util.ArrayList;

public class Kurs {
    private int kurs_identifier;
    private String kursname;
    private String raum;


    public Kurs(String kursname, int kurs_identifier, String raum) {


        this.kursname = kursname;

        this.kurs_identifier = kurs_identifier;
        this.raum=raum;
    }





    public String getKursname() {
        return kursname;
    }

    public void setKursname(String kursname) {
        this.kursname = kursname;
    }

    public String getRaum() {
        return raum;
    }

    public void setRaum(String raum) {
        this.raum = raum;
    }
}
