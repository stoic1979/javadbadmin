import java.sql.*;

public class Db {

    private static Db instance = null;
    private Connection conn    = null;

    private Db() {
        System.out.println("connecting to db...");
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:surma.sqlite");      
        }catch(Exception exp) {
            exp.printStackTrace();
            //we cant continue without db
            System.exit(1);
        }
    }

    public static Connection con() { 
        if(instance == null) instance = new Db();
        return instance.conn; 
    }

    public void close() {
        if(conn == null) return;

        try {
            conn.close();
            conn = null;
        }catch(Exception exp) {
            exp.printStackTrace();
        }
    }

}/*Db*/
