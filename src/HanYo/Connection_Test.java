package HanYo;

import java.sql.Connection;

public class Connection_Test {
    public static void main(String[] args) {
        Connection conn = DB_Connector.connect();


        DB_Statements statements = new DB_Statements();
        //statements.insertData();
        statements.createDatabase();


    }
}
