/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Classes.Comment;
import Classes.Place;
import Classes.ToiletCode;
import com.google.maps.model.LatLng;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class DbController {

    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/toiletcodes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private final String USER = "root";
    private final String PASS = "1111";

    private Connection conn = null;

    PreparedStatement insertCode;
    PreparedStatement insertComment;
    PreparedStatement insertMarker;
    PreparedStatement selectComments;
    PreparedStatement selectPlaceDetails;
    PreparedStatement selectCodes;
    PreparedStatement selectDataForKml;
    ResultSet rs;

    public DbController() throws InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException {
        Class.forName(JDBC_DRIVER).newInstance();
        this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void insertCode(Place place) throws Exception {
        try {

            insertCode = conn.prepareStatement("insert into dt_codes (fk_place, code) values (?,?)");
            insertCode.setInt(1, place.getId());
            insertCode.setString(2, place.getToiletCode().getCode());

            insertCode.executeUpdate();

        } catch (SQLException ex) {
            throw new Exception(ex);
        } finally {
            try {
                insertCode.close();
                conn.close();
            } catch (SQLException ex) {

            }
        }

    }

    public void insertCode(ToiletCode code) throws Exception {
        try {
            insertCode = conn.prepareStatement("insert into dt_codes (fk_place, code) values (?,?)");
            insertCode.setInt(1, code.getPlaceId());
            insertCode.setString(2, code.getCode());
            // TODO insert date
            insertCode.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception(ex);
        } finally {
            try {
                insertCode.close();
                conn.close();
            } catch (SQLException ex) {

            }
        }
    }

    public void insertComment(Comment comment) throws Exception {
        try {
            insertComment = conn.prepareStatement("insert into dt_comments (fk_place, author, comment) values (?,?,?)");

            insertComment.setInt(1, comment.getPlaceId());
            insertComment.setString(2, comment.getAuthor());
            insertComment.setString(3, comment.getText());

            insertComment.executeUpdate();

        } catch (SQLException ex) {
            throw new Exception(ex);
        } finally {
            try {
                insertComment.close();
                conn.close();
            } catch (SQLException ex) {

            }
        }
    }

    public void insertMarker(Place place) throws Exception {

        try {
            insertMarker = conn.prepareStatement("insert into dt_place (latitude, longtitude, name, formatted_address) values (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            insertMarker.setDouble(1, place.getLl().lat);
            insertMarker.setDouble(2, place.getLl().lng);
            insertMarker.setString(3, place.getName());
            insertMarker.setString(4, place.getVicinity());

            insertMarker.executeUpdate();

            ResultSet generatedKeys = insertMarker.getGeneratedKeys();

            if (generatedKeys.next()) {
                place.setId(generatedKeys.getInt(1));
            } else {
                System.out.println("failed to retrieve generatedKey");
            }

            this.insertCode(place);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            throw new Exception(e);
        } finally {
            try {
                insertMarker.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public Place getPlaceDetails(Place place) throws Exception {
        try {
            selectPlaceDetails = conn.prepareStatement("select * from dt_place where pk_place = ?");
            selectPlaceDetails.setInt(1, place.getId());

            rs = selectPlaceDetails.executeQuery();

            while (rs.next()) {
                place.setName(rs.getString("name"));
                place.setVicinity(rs.getString("formatted_address"));
                rs.close();
            }

            place.setComments(this.getComments(place));
            place.setCodes(this.getCodes(place));

        } catch (SQLException ex) {
            Logger.getLogger(DbController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            selectPlaceDetails.close();
            conn.close();
        }

        return place;
    }

    private ArrayList<Comment> getComments(Place place) throws Exception {
        ArrayList<Comment> comments = new ArrayList();
        try {
            selectComments = conn.prepareStatement("select * from dt_comments where fk_place = ?");
            selectComments.setInt(1, place.getId());

            rs = selectComments.executeQuery();

            while (rs.next()) {
                // pk_comments, fk_place, author, comment
                // int id, int placeId, String user,  String text
                comments.add(new Comment(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
            }

        } catch (SQLException ex) {
            throw new Exception(ex);
        } finally {
            try {
                selectComments.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return comments;

    }

    private ArrayList<ToiletCode> getCodes(Place place) throws Exception {
        ArrayList<ToiletCode> codes = new ArrayList();
        try {
            selectCodes = conn.prepareStatement("select * from dt_code where fk_place = ?");
            selectCodes.setInt(1, place.getId());

            rs = selectCodes.executeQuery();

            while (rs.next()) {
                // pk_comments, fk_place, author, comment
                // int id, int placeId, String user,  String text
                codes.add(new ToiletCode(rs.getInt("fk_place"), rs.getString("code")));
            }

        } catch (SQLException ex) {
            throw new Exception(ex);
        } finally {
            try {
                selectComments.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return codes;

    }

    public ArrayList<Place> getDataForKml() throws SQLException {
        ArrayList<Place> places = null;
        selectDataForKml = conn.prepareStatement("select * from dt_place");
        rs = selectDataForKml.executeQuery();
        
        while (rs.next()){
            Place place = new Place(rs.getInt("pk_place"));
            place.setName(rs.getString("name"));
            place.setLl(new LatLng(rs.getDouble("latitude"),rs.getDouble("longtitude")));
            places.add(place);
        }
        
        return places;
    
    }

}
