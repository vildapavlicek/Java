package Classes;

import java.time.LocalDateTime;

public class ToiletCode {

    //private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH24:mm:SS");
    private int placeId;
    private String code;
    private int codeRating;
    private LocalDateTime lastUpdate;

    public ToiletCode(String code) {
        this.code = code;
        this.lastUpdate = LocalDateTime.now();

    }

    public ToiletCode(int placeId, String code) {
        this.placeId = placeId;
        this.code = code;
        this.lastUpdate = LocalDateTime.now();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;

    }

    public int getCodeRating() {
        return codeRating;
    }

    public void setCodeRating(int codeRating) {
        this.codeRating = codeRating;
    }

    public LocalDateTime getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(LocalDateTime dateTime) {
        this.lastUpdate = dateTime;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

}
