package HttpHandlers;

import Classes.Comment;
import Utils.DbController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;


public class PostComment implements HttpHandler {

    Comment comment;
    Gson gson = new GsonBuilder().create();

    public void handle(HttpExchange httpExchange) throws IOException {
        try {
            this.mapRequest(httpExchange);
            new DbController().insertComment(this.comment);
            httpExchange.sendResponseHeaders(201, -1);
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException | SQLException ex) {
            httpExchange.sendResponseHeaders(500, -1);
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            httpExchange.sendResponseHeaders(500, -1);;
        }
    }

    private void mapRequest(HttpExchange he) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(he.getRequestBody(), "utf-8"));
        this.comment = gson.fromJson(br.readLine(), Comment.class);
    }
}
