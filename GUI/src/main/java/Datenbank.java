import java.sql.*;
import java.util.ArrayList;


public class Datenbank {
        Connection conn = null;
        String db = "jdbc:hsqldb:hsql://localhost/studenten;ifexists=true";
        String user = "SA";
        String password = "";
        Statement stmt;

        public Datenbank() {


            try {
                // Create database connection

                conn = DriverManager.getConnection(db, user, password);

                // Create and execute statement
                stmt = conn.createStatement();

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }


        }


        public ResultSet getValues(String column, String goaltabel, String condition) {
            ArrayList<Kurs> list = new ArrayList<Kurs>();

            try {
                ResultSet rs = stmt.executeQuery("select " + column + " from " + goaltabel + " where" + condition);
                return rs;

            } catch (SQLException e) {
                System.err.println(e.getMessage());
                return null;
            }
        }

        public ResultSet getValues(String column, String goaltabel) {
                ArrayList<Kurs> list= new ArrayList<Kurs>();

                try {
                    ResultSet rs = stmt.executeQuery("select "+column+" from "+goaltabel);
                    return rs;

                }catch(SQLException e){
                    System.err.println(e.getMessage());
                    return null;
                }


        }

        public void insertValues(String column,String values, String goalTabel){
            try {


                stmt.executeQuery("insert into "+goalTabel+ "("+column+") values ("+values+")");
            }catch(SQLException e){
                System.err.println(e.getMessage());

            }
        }

    public void insertValues(String column,String values, String goalTabel, String keyTabel, String keyColumn, String keyValue){
        try {


            stmt.executeQuery("insert into "+goalTabel+ "("+column+") SELECT "+values+ "FROM "+keyTabel+" WHERE "+keyColumn+" ="+keyValue);
        }catch(SQLException e){
            System.err.println(e.getMessage());

        }
    }


    public void close(){

            try {
                // Close connection
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        }
    }

