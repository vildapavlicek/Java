/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javafx.scene.text.Text;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

/**
 *
 * @author Vilda-PC
 */
public class ClientLogic implements Runnable {

    Message msg;
    Message reply = null;
    LoginStage loginStage;
    MainStage mainStage;
    Socket clientSocket;
    // int port;
    // String serverName;
    ObjectInputStream oIn;
    ObjectOutputStream oOut;
    Text actionTarget;
   

    boolean bye = false;

    final public byte LOGIN = 1;
    final public byte DBSELECT = 2;
    final public byte DBUPDATE = 3;
    final public byte DBINSERT = 4;
    final public byte SUCCESS = 5;
    final public byte FAILURE = 6;
    final public byte REQUEST = 7;
    final public byte BYE = 8;

    /*
    
     na vstupu bude mit LoginStage,
     buton v login stage zavola tady metodu, ktera se spoji na server, overi login
     jestli se povede, otevre se mainStage a loginStage zmizi, spusti se while cyklus na cteni dat od serveru
    
     */
    public ClientLogic(LoginStage loginStage, MainStage mainStage) {
        this.loginStage = loginStage;
        this.mainStage = mainStage;
    }

    /**
     * Connecting client to server and getting in and out streams
     *
     * @param serverName adress of the server
     * @param port port of the server
     * @throws IOException
     */
    public void connect(String serverName, int port) throws IOException {
        clientSocket = new Socket();
        clientSocket.connect(new InetSocketAddress(serverName, port));

        this.oOut = new ObjectOutputStream(clientSocket.getOutputStream());
        this.oIn = new ObjectInputStream(clientSocket.getInputStream());

    }

    /**
     * Method to send login data to server
     *
     * @param serverName
     * @param port
     * @param userName name of the user
     * @param password password of the user
     * @param actiontarget
     * @throws java.io.IOException
     */
    public void login(String serverName, int port, String userName, String password, Text actiontarget) throws IOException {
        this.actionTarget = actiontarget;
        this.connect(serverName, port);
        msg = new Message(LOGIN, REQUEST, userName, password);
        oOut.writeObject(msg);
        oOut.flush();
        this.actionTarget.setText("Logging to server");
        new Thread(this).start();
    }
    
    public void processLoginReply(Message reply) {
        switch (reply.getResponse()) {
            case SUCCESS:
                Platform.runLater(() -> {
                    loginStage.hide();
                    mainStage.show();
        });              
                break;
            case FAILURE:
                this.actionTarget.setText("Wrong login");
                break;
        }
    }

    @Override
    public void run() {
        while (true) {
            reply = null;

            try {
                reply = (Message) oIn.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ClientLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (reply != null) {
                switch (reply.getType()) {
                    case LOGIN:
                        this.processLoginReply(reply);
                        break;
                    case DBSELECT:
                        break;
                    case DBUPDATE:
                        break;
                    case DBINSERT:
                        break;
                    case BYE:
                        break;
                    default:
                        break;

                }
            }
        }
    }

}
