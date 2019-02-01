package Classes;

public class Comment {

    int placeId;
    private String author;
    private int id;
    private String text;

    public Comment(int id, int placeId, String author,  String text) {
        this.placeId = placeId;
        this.author = author;
        this.id = id;
        this.text = text;
    }

    public Comment(int placeId, String author,  String text) {
        this.placeId = placeId;
        this.author = author;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }
    
    

}
