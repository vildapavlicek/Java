/**
 *
 */
package HttpHandlers;

import Classes.Comment;
import Classes.Place;
import Utils.DbController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;


public class GetComments implements HttpHandler {

    Place place;
    Gson gson = new GsonBuilder().create();

    public void handle(HttpExchange httpExchange) throws IOException {
       /* ArrayList<Comment> comments = new ArrayList();
        try {    
            this.mapRequest(httpExchange);
            comments = new DbController().getComments(place);
        } catch (IOException | InstantiationException | ClassNotFoundException | IllegalAccessException | SQLException ex) {
            httpExchange.sendResponseHeaders(500, -1);
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            httpExchange.sendResponseHeaders(500, -1);
        }
        String responseBody = gson.toJson(comments);
        httpExchange.sendResponseHeaders(200, responseBody.length());
        try (OutputStream os = httpExchange.getResponseBody()) {
            os.write(responseBody.getBytes());
            os.flush();
            os.close();
        } */
    }

    private void mapRequest(HttpExchange he) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(he.getRequestBody(), "utf-8"));
        this.place = gson.fromJson(br.readLine(), Place.class);
    }
}
