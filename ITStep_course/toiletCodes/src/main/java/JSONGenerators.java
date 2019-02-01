import Classes.Comment;
import Classes.Place;
import Classes.ToiletCode;
import Utils.KmlCreator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class JSONGenerators {

    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
        // TODO code application logic here

        Gson gson = new GsonBuilder().create();

        System.out.println("adding new code to existing place: \n" + gson.toJson(new ToiletCode(1234,"code1234")));

        System.out.println("adding commnent: \n" + gson.toJson(new Comment(4321,"author1234","comment text")));

        System.out.println("adding new marker: \n" + gson.toJson(new Place(new ToiletCode("1234"),new LatLng(14.2134,95.156489))));
/*       
        Place placeA = new Place(1);
        Place placeB = new Place(2);
        Place placeC = new Place(3);
        
        placeA.setName("placeA");
        placeB.setName("placeB");
        placeC.setName("placeC");
        
        placeA.setId(1);
        placeB.setId(2);
        placeC.setId(3);
        
        placeA.setLl(new LatLng(11.11111,11.11111));
        placeB.setLl(new LatLng(22.2222,22.22222));
        placeC.setLl(new LatLng(33.3333,33.33333));
        
        
        ArrayList<Place> places = new ArrayList();
        places.add(placeA);
        places.add(placeB);
        places.add(placeC);
        
        new KmlCreator(places);
*/

    }
}
