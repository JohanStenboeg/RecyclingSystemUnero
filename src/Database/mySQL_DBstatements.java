package Database;

import Entity.EnumPantTyper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mySQL_DBstatements {


    //    Declare a Statement
    private static Statement stmt = null;

    //    Declare & create a connection
    private static Connection con = mySQL_DBconnector.connect();

    //    Declare a result set
    private static ResultSet rs = null;


    //    Method to create a new Database
    public void createDB() {

        //    SQL statement
        String query = "create database if not exists RecyclingSystemUnero";
        try {

            //    create statement
            stmt = con.createStatement();

            //    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n ---RecyclingSystemUnero Database was created---");
        }

        //    handle sql exceptions
        catch(SQLException ex) {
            System.out.println("\n ---statement did not execute (create database)---");
            ex.printStackTrace();
        }
    }

    //    method to use a database
    public void useDB() {

        //    SQL statement
        String query = "use RecyclingSystemUnero";
        try {

            //    create statement
            stmt = con.createStatement();

            //    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n---Using RecyclingSystemUnero---");
        }

        //    handle sql exceptions
        catch(SQLException ex) {
            System.out.println("\n---Statement did not execute (Use database)---");
            ex.printStackTrace();
        }
    }

    //Drop Database
    public void dropDB() {

        //    SQL statement
        String query = "drop schema RecyclingSystemUnero";
        try {

            //    create statement
            stmt = con.createStatement();

            //    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n ---RecyclingSystemUnero Database dropped---");
        }

        //    handle sql exceptions
        catch (SQLException ex) {
            System.out.println("\n ---statement did not execute (drop database)---");
            ex.printStackTrace();
        }
    }

    public void antalFlaskerTableCreate() {

        //    SQL statement
        String query = "create table if not exists AntalFlasker" + "("+
               "ID INT (1),"+
                "pantA INT(255), " +
                "pantB INT (255), " +
                "pantC INT (255) " +
                ");";
        try {

            //    create statement
            stmt = con.createStatement();

            //    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n---AntalFlasker Table oprettet---");
        }

        //    handle sql exceptions
        catch(SQLException ex) {
            System.out.println("\n---Statement did not execute (create table)---");
            ex.printStackTrace();
        }
    }

    public void pantIndiDB(EnumPantTyper type){
        String query = "";
        if (type == EnumPantTyper.pantA){
             query = "update AntalFlasker set pantA=pantA +1 where id = 1";
        }
        if  (type == EnumPantTyper.pantB){
             query = "update AntalFlasker set pantB=pantB +1 where id = 1";
        }
        if (type == EnumPantTyper.pantC){
             query = "update AntalFlasker set pantC=pantC +1 where id = 1";

        }
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("  Flaske tilføjet");
        }catch(SQLException ex){
            System.out.println("\n---Flaske blev ikke tilføjet---");
            ex.printStackTrace();
        }
    }
    public void InsertITable2(){
        String query ="";
        query = "insert into AntalFlasker (id, pantA, pantB, pantC) values (1,0,0,0);";

    try {
        stmt = con.createStatement();

        stmt.executeUpdate(query);

        System.out.println(" Dag tilføjet");
    }catch(SQLException ex){
        System.out.println("\n---Dag blev ikke tilføjet---");
        ex.printStackTrace();
    }

}
}
