
package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbProcessor {

    private Connection con;
    private PreparedStatement insert;
    private PreparedStatement select;
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/filestorage?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PWD = "1111";

    public DbProcessor() {
        try {
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DbProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(String fileuri, String pwd) throws SQLException {
        con = DriverManager.getConnection(JDBC_URL, USER, PWD);
        insert = con.prepareStatement("insert into files (fileuri, pwd) values (?,?)", Statement.RETURN_GENERATED_KEYS);
        insert.setString(1, fileuri);
        insert.setString(2, pwd);

        insert.executeUpdate();

        int pk = -1;
        try (ResultSet rs = insert.getGeneratedKeys()) {

            while (rs.next()) {
                pk = rs.getInt(1);
            }

        }

        return pk;
    }

}
