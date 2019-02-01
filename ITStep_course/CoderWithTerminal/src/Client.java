
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.System.out;

import java.net.Socket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class Client extends ParseMessage {

    Scanner sc = new Scanner(System.in);
    String cypher;
    String action;
    String text;
    String communication;
    String key;
    String filePath;
    Socket sock;
    File file;
    int temp;
    boolean waiting = false;

    Client(String host, int port) {
        try {

            sock = new Socket();
            sock.connect(new InetSocketAddress(host, port));
            out = sock.getOutputStream();
            in = sock.getInputStream();

            write("user\n");
            read("", "Password:");
            System.out.println("Password prompt readed");
            write("heslo\n");
            read("", "Welcome\n");
            this.decideAction();
            switch (cypher) {
                case "time":
                    write("time\n");
                    out.flush();
                    System.out.println("Time on server is " + read("time is:", "\n"));
                    break;
                case "vigenere":
                    write(communication + "\n");
                    out.flush();
                    System.out.println("Proccesed text is: " + read("\n", "\n"));
                    break;
                case "enigma":
                    write(communication + "\n");
                    out.flush();
                    System.out.println("Proccesed text is " + read("\n", "\n"));
                    break;
                case "file":
                    temp = (int) file.length();
                    write("File size: " + (int) file.length() + "\n");
                    while (!waiting) {
                        String checkString = read("", "\n");
                        waiting = checkString.equals("Send file");
                    }
                    //TODO implement sending  file
                    byte[] bAr = new byte[(int) file.length()];
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                    System.out.println("Reading file..");
                    bis.read(bAr, 0, bAr.length);
                    System.out.println("File read OK\nSending File..");
                    out.write(bAr, 0, bAr.length);
                    out.flush();
                    System.out.println("File sent");

                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }

            write("bye\n");
            sock.shutdownOutput();
            sock.close();
            System.out.println("Communication END");
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Client c = new Client(
                args.length > 0 ? args[0] : "localhost",
                args.length > 1 ? Integer.parseInt(args[1]) : 9001
        );
    }

    private void decideAction() throws IOException {
        String fork;

        System.out.println("Do you wish to send file (s) or enter values (v)?");
        fork = sc.nextLine();

        switch (fork) {

            case "v":
                System.out.println("Enter type of cypher (vigenere, enigma)");
                cypher = sc.nextLine();
                System.out.println("Enter if you wish to code (c) or decode (d)");
                action = sc.nextLine();
                System.out.println("Enter key value - for vigenere cypher alphabet character, for enigma string (for enigma test use: * B BETA III IV I AXLE*)");
                key = sc.nextLine();
                System.out.println("Enter text to (de)cypher");
                text = sc.nextLine();

                communication = cypher + " " + action + " " + key + " " + text;
                break;
            case "s":
                System.out.println("Enter filepath");
                //C:\Users\Vilda-PC\Documents\NetBeansProjects\CoderWithTerminal\test.txt
                filePath = sc.nextLine();
                file = new File(filePath);
                //file = new File("C:\\Users\\Vilda-PC\\Documents\\NetBeansProjects\\CoderWithTerminal\\test.txt");
                //C:\Users\Vilda-PC\Downloads\Zviratka_a_siluety.pdf
                cypher = "file";
                break;
            default:
                System.out.println("Invalid values");
                break;
        }

    }

}
