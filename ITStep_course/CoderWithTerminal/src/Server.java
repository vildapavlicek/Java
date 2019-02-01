
import java.net.ServerSocket;
import java.io.IOException;

public class Server {

    public Server(int port) throws IOException {
        int count = 0;
        ServerSocket servsock = new ServerSocket(port);
        while (true) {
            try {
                new ClientHandler(servsock.accept(), count++).start();
            } catch (IOException e) {
                System.out.println("IO error in new client");
            }
        }
    } // Server()

    public static void main(String[] args) {
        try {
            new Server(args.length > 0 ? Integer.parseInt(args[0]) : 9001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
