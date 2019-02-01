package HttpHandlers;

import com.sun.net.httpserver.HttpHandler;
import java.util.HashMap;

public class Handlers {
    private HashMap<String, HttpHandler> handlers;


    public Handlers() {
        handlers = new HashMap<>();
        handlers.put("/getComments", new GetComments());
        handlers.put("/postCode", new PostCode());
        handlers.put("/postComment", new PostComment());
        handlers.put("/postMarker", new PostMarker());
        handlers.put("/getDetails", new GetDetails());
    }

    public HashMap<String, HttpHandler> getHandlers() {
        return this.handlers;
    }

}
