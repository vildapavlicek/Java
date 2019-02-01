package HttpHandlers;

import Classes.ToiletCode;
import Utils.DbController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;


public class PostCode implements HttpHandler {

    ToiletCode code;
    Gson gson = new GsonBuilder().create();

    public void handle(HttpExchange httpExchange) throws IOException {
        try {
            this.mapRequest(httpExchange);
            new DbController().insertCode(code);
            httpExchange.sendResponseHeaders(201, -1);
        } catch (InstantiationException | SQLException | IllegalAccessException | ClassNotFoundException ex) {
            httpExchange.sendResponseHeaders(500, -1);
        } catch (Exception ex) {
            httpExchange.sendResponseHeaders(500, -1);;
        }
    }

    private void mapRequest(HttpExchange he) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(he.getRequestBody(), "utf-8"));
        this.code = gson.fromJson(br.readLine(), ToiletCode.class);
    }

}
