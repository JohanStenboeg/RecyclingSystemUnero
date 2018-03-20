package Database;



import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connector {

    private static String url = "jdbc:postgresql://localhost:5432/";
    private static String user = "postgres";
    private static String pass = "12345";
    private static Connection conn = null;

    public static Connection connect() {
        System.out.println("\n--Conecting to PostgreSQL JDBC");

        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (conn != null) {
            System.out.println("\n--Connection successful--");
        } else {
            System.out.println("\n--Connection failed--");
        }
        return conn;
    }
}
