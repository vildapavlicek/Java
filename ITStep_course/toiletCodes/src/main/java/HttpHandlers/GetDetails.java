/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HttpHandlers;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class GetDetails implements HttpHandler {

    Gson gson = new GsonBuilder().create();

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(httpExchange.getRequestBody(), "utf-8"));
            Place place = new Place(Integer.valueOf(br.readLine()));
            place = new DbController().getPlaceDetails(place);
            String responseBody = gson.toJson(place);
            httpExchange.sendResponseHeaders(200, responseBody.length());
            try (OutputStream os = httpExchange.getResponseBody()) {
                os.write(responseBody.getBytes());
                os.flush();
                os.close();
            }
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException | SQLException ex) {
            httpExchange.sendResponseHeaders(500, -1);
        } catch (Exception ex) {
            httpExchange.sendResponseHeaders(500, -1);
        }

    }
}
