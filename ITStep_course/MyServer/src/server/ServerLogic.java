/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vilda-PC
 */
public class ServerLogic implements Runnable {

    final public byte LOGIN = 1;
    final public byte DBSELECT = 2;
    final public byte DBUPDATE = 3;
    final public byte DBINSERT = 4;
    final public byte SUCCESS = 5;
    final public byte FAILURE = 6;
    final public byte REQUEST = 7;
    final public byte BYE = 8;

    ResultSet rs;

    Message msg;
    Message request = null;

    Socket soc;
    ObjectInputStream oIn;
    ObjectOutputStream oOut;
    int id;

    DbHandler dbH = new DbHandler();

    public ServerLogic(Socket socket, int id) throws IOException {
        this.soc = socket;
        this.id = id;

        this.oOut = new ObjectOutputStream(soc.getOutputStream());
        this.oIn = new ObjectInputStream(soc.getInputStream());

    }

    public void start() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                try {
                    request = (Message) oIn.readObject();
                } catch (IOException ex) {
                    Logger.getLogger(ServerLogic.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ServerLogic.class.getName()).log(Level.SEVERE, null, ex);
                }

                switch (request.getType()) {
                    case LOGIN:                        
                        if (dbH.checkLogin(request.getUser(), request.getText())) {
                            oOut.writeObject(new Message(LOGIN, SUCCESS, request.getUser(), "Login successful"));
                        } else {
                            oOut.writeObject(new Message(LOGIN, FAILURE, request.getUser(), "Login failed"));
                        }
                        break;
                    case DBSELECT:
                        break;
                    case DBUPDATE:
                        break;
                    case DBINSERT:
                        break;
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServerLogic.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ServerLogic.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ServerLogic.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
