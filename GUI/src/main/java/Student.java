public class Student {
    private int studentID;
    private String name;
    private String prename;
    private int kursNumber;
    private int javaSkill;
    private int matrikelnummer;

    public int getMatrikelnummer() {
        return matrikelnummer;
    }

    public void setMatrikelnummer(int matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }

    public int getKursNumber() {
        return kursNumber;
    }

    public void setKursNumber(int kursNumber) {
        this.kursNumber = kursNumber;
    }

    public int getJavaSkill() {
        return javaSkill;
    }

    public void setJavaSkill(int javaSkill) {
        this.javaSkill = javaSkill;
    }

    public Student(int studentID, String name, String prename, int kursNumber, int javaSkill, int matrikelnummer) {
        this.studentID= studentID;
        this.name = name;
        this.prename = prename;
        this.kursNumber = kursNumber;
        this.javaSkill = javaSkill;
        this.matrikelnummer = matrikelnummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }
}
