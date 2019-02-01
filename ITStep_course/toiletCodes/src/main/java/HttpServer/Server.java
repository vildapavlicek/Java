package HttpServer;

import HttpHandlers.Handlers;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.concurrent.Executors;

public class Server {

    final static private String SERVER_INET_ADDRESS = "localhost";
    final static private int PORT = 8080;
    final static private int THREAD_POOL_LIMIT = 10;
    private HttpServer server;

    final Logger logger = LoggerFactory.getLogger(Server.class);


    public Server() throws IOException {
        this.init();
    }

    private void init() throws IOException {
        server = HttpServer.create(new InetSocketAddress(SERVER_INET_ADDRESS, PORT), 0);
        this.addHandlers(new Handlers().getHandlers());
        server.setExecutor(Executors.newFixedThreadPool(THREAD_POOL_LIMIT));
        server.start();
        logger.info("HttpServer started at address {} and port {} and thread pool limit {}", SERVER_INET_ADDRESS, PORT, THREAD_POOL_LIMIT);
        System.out.println("HttpStarted");
    }

    void addHandlers (HashMap<String, HttpHandler> handlers){
        handlers.forEach((s, o) -> {
            this.server.createContext(s, o);
            logger.info("Context added with values; path: {}; handler: {}", s, o.getClass());

        });
    }

}