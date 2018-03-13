package HanYo;

import HanYo.DB_Connector;

import java.io.*;
import java.sql.*;

public class DB_Statements {
    //Declare a statement
    private static Statement stmt = null;
    //Declare and create a connection
    private static Connection con = DB_Connector.connect();
    //Declare a resultset
    private static ResultSet rs = null;
    //Declare a preparedStatement
    private static PreparedStatement pst = null;

    //Insert data constructor
    public void insertData() {
        /*
        EmployeeTable employeeTable = new EmployeeTable(41, "Henrik", 100);
        String query1 = "insert into employeeTable (emp) values(?)";
        String query2 = "select * from employeeTable";
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(employeeTable);

            byte[] employeeAsByte = baos.toByteArray();

            pst = con.prepareStatement(query1);
            ByteArrayInputStream bais = new ByteArrayInputStream(employeeAsByte);

            pst.setBinaryStream(1, bais,employeeAsByte.length);

            pst.executeUpdate("\n--Query1 executed--");



        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\n--Query1 did not execute");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\n--Query1 did not execute");
        }
        try{
            stmt = con.createStatement();

            rs = stmt.executeQuery(query2);
            while(rs.next()) {
                byte[] st = (byte[]) rs.getObject(1);
                ByteArrayInputStream baip = new ByteArrayInputStream(st);
                ObjectInputStream ois = new ObjectInputStream(baip);
                EmployeeTable emp = (EmployeeTable) ois.readObject();
            }
            System.out.println("\n--Retrive executed--");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\n--Retrive did not execute--");
            System.out.println("\n--IOException--");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\n--Retrive did not execute--");
            System.out.println("\n--SQLException--");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("\n--Retrive did not execute--");
            System.out.println("\n--ClassNotFoundException--");
        }*/
    }
}
