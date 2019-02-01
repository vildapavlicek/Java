/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author Vilda-PC
 */
public class HTTPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        ServerSocket sSocket = new ServerSocket(80);
        Socket client;
        boolean shutdown = false;
        int i = 0;

        while (!shutdown) {

            client = sSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Client accepted");
            System.out.println("reading header");

            while (br.ready()) {
                System.out.println(br.readLine());
            }
            System.out.println("-----------------------------------------------------------------------");

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            StringBuilder header = new StringBuilder();
            StringBuilder html = new StringBuilder();

            header
                    .append("HTTP/1.1 200 OK\n")
                    .append("Date: ")
                    .append(new Date())
                    .append("\n")
                    .append("Server: Java\n")
                    .append("X-Powered-By: Aeldra\n")
                    .append("Content-Type: text/html; charset=UTF-8\n")
                    .append("\n");

            bw.write(header.toString());
            bw.flush();

            html
                    .append("<!DOCTYPE HTML>")
                    .append("<HTML><HEAD> <meta charset=\"UTF-8\"> <TITLE>test</TITLE></HEAD>")
                    .append("<BODY><H1>WELCOME</H1>")
                    .append("<P>Text of the body</P>")
                    .append("<h2>HTML Forms</h2>\n"
                            + "\n"
                            + "<form action=\"\" method=\"GET\">\n"
                            + "  First name:<br>\n"
                            + "  <input type=\"text\" name=\"firstname\" value=\"Mickey\">\n"
                            + "  <br>\n"
                            + "  Last name:<br>\n"
                            + "  <input type=\"text\" name=\"lastname\" value=\"Mouse\">\n"
                            + "  <br><br>\n"
                            + "  <input type=\"submit\" value=\"Submit\">\n"
                            + "</form> \n"
                            + "\n"
                            + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/test\".</p>")
                    .append("<p>Version: ")
                    .append(i)
                    .append("</p>")
                    .append("</BODY></HTML>");

            bw.write(html.toString());
            bw.flush();

            br.close();
            bw.close();

            System.out.println("Socket closed");

        }
        sSocket.close();
    }

}
