/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;


import enigma.Machine;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/**
 *
 * @author Pavel
 */
public class EnigmaCypher  {

    protected String key = null;
    protected String code = null;
    protected String decode = null;
    

    /**
     * Encode String input
     *
     * @param string
     */
    public String encode(String string) {
        Machine M;
        M = null;
        if (checkInput(string)) {
            M = new Machine();
            configure(M, key);
        } else {
            System.exit(1);
        }
        System.out.println("Text to encode: " + this.code);
        return printMessageLine(M.convert(standardize(code)));
    }

    /**
     * Encode File input
     *
     * @param file
     */
  
    public void encode(File file) {
        Machine M;

        M = null;

        try {
            BufferedReader input = new BufferedReader(new FileReader(
                    file));
            String line = input.readLine();
            if (!checkInput(line)) {
                System.exit(1);
            }

            M = new Machine();
            configure(M, line);
            while (true) {
                line = input.readLine();
                if (line == null) {
                    break;
                }
                if (checkInput(line)) {
                    M = new Machine();
                    configure(M, line);
                } else {
                    printMessageLine(M.convert(standardize(line)));
                }
            }
        } catch (IOException excp) {
            System.err.printf("Input error: %s%n", excp.getMessage());
            System.exit(1);
        }
    }

    /**
     * Decode String input
     *
     * @param file
     */

    public String decode(String string) {
        Machine M;
        BufferedReader input = new BufferedReader(new StringReader(
                string));
        M = null;

        try {
            String line = input.readLine();
            if (!checkInput(line)) {
                System.exit(1);
            }

            M = new Machine();
            configure(M, line);
            while (true) {
                line = input.readLine();
                if (line == null) {
                    break;
                }
                if (checkInput(line)) {
                    M = new Machine();
                    configure(M, line);
                } else {
                   return printMessageLine(M.convert(standardize(line)));
                }
            }
        } catch (IOException excp) {
            System.err.printf("Input error: %s%n", excp.getMessage());
            System.exit(1);
        }
        return "Invalid End";
    }

    /**
     * Decode File input
     *
     * @param file
     */
 
    public void decode(File file) {
        Machine M;

        M = null;

        try {
            BufferedReader input = new BufferedReader(new FileReader(
                    file));
            String line = input.readLine();
            if (!checkInput(line)) {
                System.exit(1);
            }

            M = new Machine();
            configure(M, line);
            while (true) {
                line = input.readLine();
                if (line == null) {
                    break;
                }
                if (checkInput(line)) {
                    M = new Machine();
                    configure(M, line);
                } else {
                    printMessageLine(M.convert(standardize(line)));
                }
            }
        } catch (IOException excp) {
            System.err.printf("Input error: %s%n", excp.getMessage());
            System.exit(1);
        }
    }

    /**
     * Return true if LINE is an Enigma configuration line and set configuration
     * Key.
     */
    private boolean checkInput(String line) {
        String asterisk = "*";
        if (line.startsWith(asterisk)) {
            this.key = line.substring(1, line.indexOf("*", 1));
            if(checkKey(key)){System.out.println("true key");};
            System.out.println("Configuration key for Enigma is: " + key);
            this.code = line.substring(line.indexOf("*", 1) + 1);
            return true;
        }
        System.out.println("Missing or corrupt input, cannot process");
        return false;
    }

    /**
     * Return true if LINE is an Enigma configuration line and set configuration
     * Key.
     */
    private boolean checkKey(String line) {
        String trim = line;
        String[] rotors = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII"};
        int count = 0;
        while (trim.startsWith(" ")) {
            trim = trim.substring(1);
        }
        String[] check = trim.split(" ");
        if (check[0].equals("B") || check[0].equals("C")) {
            System.out.println("true first");
            if (check[1].equals("BETA") || check[1].equals("GAMMA")) {
                System.out.println("true second");
                if (check[2].equals(check[3]) || check[2].equals(check[4]) || check[4].equals(check[3])) {
                    return false;
                } else {
                    System.out.println("true third");
                    for (int j = 2; j < 5; j++) {
                        for (int i = 0; i < rotors.length; i++) {
                            if (check[j].equals(rotors[i])) {

                                count++;
                                if (count == 2) {System.out.println("true forth");
                                    
                                   if (check[5].matches("[A-Z]+")){
                                       System.out.println("true fi");
                                       this.key=trim;
                                       return true;}
                                   else{return false;}
                                }
                            }
                        }
                    }
                }
            }
        }
        if (true) {
            return true;
        }
        System.out.println("Missing or corrupt input, cannot process");
        return false;
    }

    /**
     * Configure M according to the specification given on CONFIG, which must
     * have the format specified in the assignment.
     */
    private static void configure(Machine M, String config) {
        M.configureRotors(config);
    }

    /**
     * Return the result of converting LINE to all upper case, removing all
     * blanks and tabs. It is an error if LINE contains characters other than
     * letters and blanks.
     */
    private static String standardize(String line) {
        line = line.replaceAll(" ", "");
        line = line.toUpperCase();
        return line;
    }

    /**
     * Print MSG in groups of five (except that the last group may have fewer
     * letters).
     */
    private static String printMessageLine(String msg) {
        if (msg.equals("")) {
            return "**";
        } else {
            int len = msg.length();
            if (len < 5) {
                return msg;
            } else {
                String finalMsg = msg.substring(0, 5);
                int i = 5;
                int j = 10;
                for (; j < len; i = i + 5, j = j + 5) {
                    finalMsg = finalMsg + " " + msg.substring(i, j);
                }
                return finalMsg = finalMsg + " " + msg.substring(i, len);
                //System.out.println(finalMsg);
            }
        }
    }

     public String doAction(String action, String text) {
        String message = "";
        System.out.println(action + " " + " " + text + " ");
        switch (action) {
            case "c":
                message = this.encode(text);
                break;
            case "d":
                message = this.encode(text);
                break;

        }
        return message;
    }
    
}
