package Classes;

import com.google.maps.model.LatLng;
import java.util.ArrayList;

public class Place {

    private int id;
    private String name;
    private String vicinity;
    private int rating;
    private ToiletCode code;
    private LatLng ll;
    private String openHours;
    private ArrayList<Comment> comments;
    private ArrayList<ToiletCode> codes;

    public Place(int id, String name, String vicinity, int rating, ToiletCode code, LatLng ll, String openHours, ArrayList<ToiletCode> codes, ArrayList<Comment> comments) {
        this.id = id;
        this.name = name;
        this.vicinity = vicinity;
        this.rating = rating;
        this.code = code;
        this.ll = ll;
        this.openHours = openHours;
        this.codes = codes;
        this.comments = comments;
    }

    public Place(ToiletCode code, LatLng ll) {
        this.code = code;
        this.ll = ll;
    }

    public Place(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ToiletCode getToiletCode() {
        return code;
    }

    public void setToiletCode(ToiletCode code) {
        this.code = code;
    }

    public LatLng getLl() {
        return ll;
    }

    public void setLl(LatLng ll) {
        this.ll = ll;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public ToiletCode getCode() {
        return code;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setCode(ToiletCode code) {
        this.code = code;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<ToiletCode> getCodes() {
        return codes;
    }

    public void setCodes(ArrayList<ToiletCode> codes) {
        this.codes = codes;
    }

}
