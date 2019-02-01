/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Student
 */
public class DbHandler {
// JDBC driver name and database URL

    final public byte LOGIN = 1;
    final public byte DBSELECT = 2;
    final public byte DBUPDATE = 3;
    final public byte DBINSERT = 4;

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/cinemadb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1111";

    PreparedStatement select;
    PreparedStatement update;
    PreparedStatement insert;

    Connection conn = null;

    public void DbProcess(byte type) throws ClassNotFoundException, SQLException { // prejmenuj to -_- !!! smazat nebude se pouzivat

        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        this.conn = DriverManager.getConnection(DB_URL, USER, PASS);

        Statement stmt = null;
        try {

            switch (type) {
                case LOGIN:
                    select = conn.prepareStatement("select password from cinemadb.users where name = '?'");
                    ResultSet rs = select.executeQuery();
            }

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT idcinemas, name, street, building_num, city FROM cinemas";
            //STEP 5: Extract data from result set
            try (ResultSet rs = stmt.executeQuery(sql)) {
                //STEP 5: Extract data from result set
                while (rs.next()) {
                    //Retrieve by column name
                    int idcinemas = rs.getInt("idcinemas");
                    String name = rs.getString("name");
                    String street = rs.getString("street");
                    String building_num = rs.getString("building_num");
                    String city = rs.getString("city");

                    //Display values
                    System.out.print("ID: " + idcinemas);
                    System.out.print(", Age: " + name);
                    System.out.print(", First: " + street);
                    System.out.println(", Last: " + building_num);
                    System.out.println(", Last: " + city);
                }
                //STEP 6: Clean-up environment
            }
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

    }//end dbprocess

    public boolean checkLogin(String user, String pwd) throws ClassNotFoundException, SQLException {
        String tempPwd = null;
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
        select = conn.prepareStatement("select password from cinemadb.users where name = ? ;");
        select.setString(1, user);
        try (ResultSet rs = select.executeQuery()) {
            while (rs.next()) {
                tempPwd = rs.getString("password");
            }
        }
        select.close();
        conn.close();

        try {
            if (select != null) {
                select.close();
            }
        } catch (SQLException se2) {
        }// nothing we can do
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return pwd.equals(tempPwd);
    }

    /**
     * This method returns all data in ArrayList containing HashMaps with
     * column: value pairs
     *
     * @return ArrayList data of resultset
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList dbAll() throws ClassNotFoundException, SQLException {
        ArrayList<HashMap> results = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
        select = conn.prepareStatement("SELECT c.name, c.street, c.building_num, c.city, m.name, m.director, m.year, m.description, s.screen_datetime FROM cinemas as c, movies as m, screen_times as s where c.idcinemas = s.cinema_id and s.movie_id = m.idmovies;");
        try (ResultSet rs = select.executeQuery()) {

            ResultSetMetaData rsmt = rs.getMetaData();
            HashMap<String, Object> row = new HashMap<>();

            int colsNum = rsmt.getColumnCount();

            while (rs.next()) {
                for (int i = 0; i <= colsNum; i++) {
                    row.put(rsmt.getColumnName(i), rs.getObject(i));
                    results.add(row);
                }
            }

        }

        select.close();
        conn.close();

        try {
            if (select != null) {
                select.close();
            }
        } catch (SQLException se2) {
        }// nothing we can do
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return results;

    }

    public void dbCinemas() {
    }

    public void dbMovies() {
    }

    public void dbScreenTimes() {
    }

}//end FirstExample
