
import enigma.EnigmaCypher;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.net.Socket;
import java.io.IOException;

class ClientHandler extends ParseMessage implements Runnable {

    static final int UNKNOWN = -1;
    static final int TIME = 0;
    static final int BYE = 1;
    static final int VIGENERE = 2;
    static final int ENIGMA = 3;
    static final int FILE = 4;
    static final int NUMBER = 5;
    static final String[] STRCMD = {
        "time", "bye", "vigenere", "enigma", "file"
    };
    String action;
    String cypher;
    String text;
    String key;
    String[] input;
    String tempStr;
    int fileSize;
    int bytesRead;
    int current;

    static int parseCmd(String str) {
        int ret = UNKNOWN;

        for (int i = 0; i < NUMBER; i++) {
            if (str.compareTo(STRCMD[i]) == 0) {
                ret = i;
                break;
            }
        }
        return ret;
    }

    Socket sock;
    int id;

    ClientHandler(Socket iSocket, int iID) throws IOException {
        sock = iSocket;
        id = iID;
        out = sock.getOutputStream();
        in = sock.getInputStream();

    }

    public void start() {
        new Thread(this).start();
    }

    void log(String str) {
        System.out.println(str);
    }

    @Override
    public void run() {
        String cID = "client[" + id + "] ";
        try {
            log(cID + "Accepted");
            write("Login:");
            log(cID + "Username:" + read("", "\n"));
            write("Password:");
            log(cID + "Password:" + read("", "\n"));
            write("Welcome\n");
            write("Enter name of the cypher (vigenere, enigma), followed by desired action (d - decypher, c - cypher) followe by key (char for vigenere) followed by string\n");

            boolean quit = false;
            while (!quit) {
                this.parseInput();
                switch (parseCmd(input[0].toLowerCase())) { //
                    case TIME:
                        write("time is:" + new Date().toString() + "\n");
                        break;
                    case BYE:
                        log(cID + "Client sends bye");
                        quit = true;
                        break;
                    case VIGENERE:
                        VigenereCypher vig = new VigenereCypher();
                        write(vig.doAction(action, text, key) + "\n");
                        input[0] = null;
                        break;
                    case ENIGMA:
                        EnigmaCypher ec = new EnigmaCypher();
                        write(ec.doAction(action, text) + "\n");
                        input[0] = null;
                        break;
                    case FILE:
                        fileSize = Integer.parseInt(input[2]);         
                        //BufferedInputStream bis = new BufferedInputStream(in);
                        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test" + id + ".txt"));
                        byte[] bAr = new byte[fileSize];
                        write("Send file\n");
                        bytesRead = in.read(bAr, 0, bAr.length);
                        current = bytesRead;

                       /* do {
                            bytesRead = in.read(bAr, current, (bAr.length - current));
                            if (bytesRead >= 0) {
                                current += bytesRead;
                            }
                        } while (bytesRead > -1); */

                        bos.write(bAr, 0, current);
                        bos.flush();
                        bos.close();
                        System.out.println("File " + "test" + id + ".txt"
                                + " downloaded (" + current + " bytes read)");
                        break;
                    default:
                        log(cID + "Unknown message, disconnect");
                        log(read("", "\n"));
                        quit = true;
                        break;
                }
            }
            sock.shutdownOutput();
            sock.close();
        } catch (Exception e) {
            System.out.println(cID + "Exception:" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void parseInput() throws IOException {
        tempStr = read("", "\n");
        input = tempStr.split(" ");

        switch (parseCmd(input[0].toLowerCase())) {
            case VIGENERE:
                if (input.length < 5) {

                    action = input[1].toLowerCase();
                    key = input[2];
                    text = input[3];
                } else {
                    write("Invalid input");
                }
                break;
            case ENIGMA:
                //input = read("","\n").split(" ");
                action = input[1].toLowerCase();
                text = tempStr.substring(9);
                break;

        }

    }

}
