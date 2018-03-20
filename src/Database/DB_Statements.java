package Database;

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

       private String path ="jdbc:postgresql://localhost/";
   private String name = "RecyclingSystemUnero";
   private String username = "postgres";
   private String password = "12345";

    //Create Database
    public boolean createDatabase(){
        // Open the database.
        try {

            // Load the postgresql driver. I am unclear on why we have to do this
            // when we're already linking  with the postgres library (isn't that
            // enough?). But if you don't do this the executable may fail to find
            // the driver class.
            Class.forName("org.postgresql.Driver");

            // First, we try the database name provided by the user.
            // Note that I'm using the option to connect to an existing schema, not
            // the default public schema. If you don't care, you can drop the option.
            // Postgres may silently ignore this (grr) if the schema doesn't exist.
            con = DriverManager.getConnection(path + name +
                    "?currentSchema = " + name, username, password);

            System.out.println(name + " connected");
        }
        catch (Exception e) {

            System.out.println("Could not connect to database: " + path + name);
            System.out.println("Now trying to connect to the default database.");

            // Failed to connect. This may mean it doesn't exist, so let's try to
            // create one. But there's a catch: To create a database in Java, we
            // first have to be connected to another database. By default, PostgresQL
            // creates a default database on installation called "postgres". We'll
            // use that one.
            //
            // Isn't this all stupid? Why can't I simply tell Postgres to create it without
            // having to go through this rigamarole? Or better yet, if it doesn't exist
            // when I try to connect, create it by default? Whaa, whaa, whaa.
            try {

                con = DriverManager.getConnection(path + "postgres", username, password);
                System.out.println("Connected with the default database.");

                // We're connected to the default DB, and Postgres. Now we can create our own DB.
                try {
                    // Note the absence of the "path" in the CREATE command. Apparently Postgres
                    // needs to create the new database in the default path; there may be some
                    // way to tell it to put it elsewhere, but that's another issue. For now,
                    // if you specify a path in the CREATE command it will bomb out.
                    Statement statement = con.createStatement();
                    statement.execute("CREATE DATABASE " + name);

                    // Now close the default DB so that we can connect to the new DB.
                    con.close();

                    // Connect to "our" database.
                    con = DriverManager.getConnection(path+name, username, password);
                    System.out.println("Connected with the new database.");

                    // If you want to create a new schema in the database...
                    // For uniqueness, I just use the database name as the schema name. YMMV.
                    statement = con.createStatement();
                    statement.execute("CREATE SCHEMA IF NOT EXISTS " + name);
                    con.setSchema(name);

                    // It worked.
                    System.out.println("Database " + name + " created.");
                }
                catch(Exception e2)
                {
                    // Bomb out on connecting to our database.
                    System.out.println("Could not connect with new database: \n" + e2);
                    return false;
                }
            }
            catch (Exception e3)
            {
                // Huh? We can't even connect to the default database. Bail out.
                System.out.println("Could not connect with default database: \n" + e3);

                return false;
            }
        }


        // Make sure we're using our schema -- so we aren't using the public schema.
        // Again, if you don't care, delete this try/catch block.
        try {
            Statement statement = con.createStatement();

            // Note that "conn.setSchema(name);" doesn't necessarily connect to the
            // schema we request! I don't know why, I just know that it silently fails
            // when I do it (gotcha again!). So here we use a execute command instead.

            // Set which schema we're going to use
            statement.execute("SET search_path to " + name);

        } catch (Exception badSchema) {
            System.out.println("Failed to set schema. Exception:\n"
                    + badSchema);
            return false;
        }

        // Success!
        return true;
    }
}

    //Insert data constructor
    //public void insertData() {
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


