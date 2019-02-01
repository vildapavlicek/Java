package HttpHandlers;

import Classes.Place;
import Utils.DbController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import static com.google.maps.GeoApiContext.Builder;

public class PostMarker implements HttpHandler {

    Place place;

    GeoApiContext context = new Builder()
            .apiKey("AIzaSyBrzyoOT1mogGapm8JMUCDlkJc_aToO_X4")
            .build();

    Gson gson = new GsonBuilder().create();

    public void handle(HttpExchange httpExchange) throws IOException {

        try {
            this.mapRequest(httpExchange);
            this.getPlaceDetails();
            System.out.println(gson.toJson(this.place));
            new DbController().insertMarker(place);

            httpExchange.sendResponseHeaders(201, -1);
        } catch (InterruptedException | ApiException | IOException | InstantiationException | ClassNotFoundException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            httpExchange.sendResponseHeaders(500, -1);
        } catch (Exception ex) {
            httpExchange.sendResponseHeaders(500, -1);
        }
    }

    private void mapRequest(HttpExchange he) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(he.getRequestBody(), "utf-8"));
        this.place = gson.fromJson(br.readLine(), Place.class);
    }

    private void getPlaceDetails() throws InterruptedException, ApiException, IOException {
        PlacesSearchResponse psr = PlacesApi.nearbySearchQuery(this.context, this.place.getLl()).radius(15).type(PlaceType.RESTAURANT).custom("language", "cs").await();

        this.place.setName(psr.results[0].name);
        this.place.setVicinity(psr.results[0].vicinity);
        this.place.setOpenHours("openHours");

    }
}
