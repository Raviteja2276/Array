import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");

            System.out.println("database successfully opened");
            stmt = c.createStatement();
            String sql = "CREATE TABLE COMPANY15"+
                    "(ID INT PRIMARY KEY NOT NULL,"+
                    "NAME VARCHAR(10) NOT NULL, "+
                    "AGE INT NOT NULL,"+
                    "ADDRESS VARCHAR(50), "+
                    "SALARY INT )";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName()+":"+e.getMessage());
            System.exit(0);

        }
        System.out.println("table created successfully");
    }
}

