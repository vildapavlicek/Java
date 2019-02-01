/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.*;

/**
 *
 * @author Student
 */
public class HTTPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        int port = 9000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("server started at " + port);
        server.createContext("/", new RootHandler());
        server.createContext("/echoHeader", new EchoHeaderHandler());
        server.createContext("/echoGet", new EchoGetHandler());
        server.createContext("/echoPost", new EchoPostHandler());
        server.createContext("/JSONParser", new JsonHandler());
        server.setExecutor(null);
        server.start();
    }

    public static class RootHandler implements HttpHandler {

        @Override
        public void handle(com.sun.net.httpserver.HttpExchange he) throws IOException {

            String response = "<h1>Server start success if you see this message</h1>" + "<h1>Port: " + "some port here" + "</h1>";
            he.sendResponseHeaders(200, response.length());
            try (OutputStream os = he.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }

    public static class EchoHeaderHandler implements HttpHandler {

        @Override
        public void handle(com.sun.net.httpserver.HttpExchange he) throws IOException {
            Headers headers = he.getRequestHeaders();
            Set<Map.Entry<String, List<String>>> entries = headers.entrySet();
            String response = "";
            for (Map.Entry<String, List<String>> entry : entries) {
                response += entry.toString() + "\n";
            }
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();

        }
    }

    public static class EchoGetHandler implements HttpHandler {

        @Override
        public void handle(com.sun.net.httpserver.HttpExchange he) throws IOException {
            // parse request
            Map<String, Object> parameters = new HashMap<String, Object>();
            URI requestedUri = he.getRequestURI();
            String query = requestedUri.getRawQuery();
            parseQuery(query, parameters);

            // send response
            String response = "";
            for (String key : parameters.keySet()) {
                response += key + " = " + parameters.get(key) + "\n";
            }
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.toString().getBytes());

            os.close();
        }

    }

    public static class EchoPostHandler implements HttpHandler {

        @Override
        public void handle(com.sun.net.httpserver.HttpExchange he) throws IOException {
            // parse request
            Map<String, Object> parameters = new HashMap<String, Object>();
            InputStreamReader isr = new InputStreamReader(he.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String query = br.readLine();
            parseQuery(query, parameters);

            // send response
            String response = "";
            response = parameters.keySet().stream().map((key) -> key + " = " + parameters.get(key) + "\n").reduce(response, String::concat);
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
        }
    }

    public static class JsonHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            System.out.println("--------------------------------------------------------------------");
            System.out.println(new Timestamp(System.currentTimeMillis()) + " JSON parser called");
            InputStreamReader isr = new InputStreamReader(he.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String query = br.readLine();

            System.out.println("read data: " + query);
            Gson gson = new GsonBuilder().create();
            Person p = gson.fromJson(query, Person.class);
            System.out.println("Person created: "+ p);

            Response response = new Response();
            response.setResponseCode(200);
            response.setResponse("OK");
            response.setMessage("JSON received and parsed!");


            he.getResponseHeaders().add("Access-Control-Allow-Origin","*");
            he.getResponseHeaders().add("Content-Type","application/json");
            he.sendResponseHeaders(200, gson.toJson(response).length());
            System.out.println(gson.toJson(response));
            String rh = "";
            rh = he.getResponseHeaders().keySet().stream().map((key) -> key + " : " + he.getResponseHeaders().get(key) + "\n").reduce(rh,String::concat);
            System.out.println(rh);
            try (OutputStream os = he.getResponseBody()) {
                os.write(gson.toJson(response).getBytes());
                System.out.println(new Timestamp(System.currentTimeMillis()) + " Response sent!");
                System.out.println("--------------------------------------------------------------------");
            }
        }
    }

    public static void parseQuery(String query, Map<String, Object> parameters) throws UnsupportedEncodingException {

        if (query != null) {
            String pairs[] = query.split("[&]");
            for (String pair : pairs) {
                String param[] = pair.split("[=]");
                String key = null;
                String value = null;
                if (param.length > 0) {
                    key = URLDecoder.decode(param[0],
                            System.getProperty("file.encoding"));
                }

                if (param.length > 1) {
                    value = URLDecoder.decode(param[1],
                            System.getProperty("file.encoding"));
                }

                if (parameters.containsKey(key)) {
                    Object obj = parameters.get(key);
                    if (obj instanceof List<?>) {
                        List<String> values = (List<String>) obj;
                        values.add(value);

                    } else if (obj instanceof String) {
                        List<String> values = new ArrayList<String>();
                        values.add((String) obj);
                        values.add(value);
                        parameters.put(key, values);
                    }
                } else {
                    parameters.put(key, value);
                }
                //System.out.print(key + " : " + value);
            }
        }
    }

}
