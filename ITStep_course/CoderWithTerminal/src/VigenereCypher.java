/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vilda
 */
public class VigenereCypher extends Cypher {

    /*
    public void decode(File file, String key) {
        String text = ioh.getInput(file);
        String res = "";
        key = key.toUpperCase();
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') {
                continue;
            }
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
         IOHandler.serialize(res, "decoded_message.dat");
    }

    /**
     * This method was taken from
     * https://rosettacode.org/wiki/Vigenère_cipher#Java and decodes text using
     * Vigenere cypher
     *
     * @param text encoded text to be decoded
     * @param key key that is used for encoding
     */
    public String decode(String text, String key) {
        String res = "";
        text = text.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') {
                continue;
            }
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    /*
    public void encode(File file, String key) {
        String text = ioh.getInput(file);
        String res = "";
        key = key.toUpperCase();
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') {
                continue;
            }
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        IOHandler.serialize(res, "encoded_message.dat");
    }

    /**
     * This method was taken from
     * https://rosettacode.org/wiki/Vigenère_cipher#Java and encodes text using
     * Vigenere cypher
     *
     * @param text text to encode
     * @param key is value that determines the encoded outcome
     */
    public String encode(String text, String key) {
        String res = "";
        key = key.toUpperCase();
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') {
                continue;
            }
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    public String doAction(String action, String text, String key) {
        String message = "";
        System.out.println(action + " " + " " + text + " " + key);
        switch (action) {
            case "c":
                message = this.encode(text, key);
                break;
            case "d":
                message = this.decode(text, key);
                break;

        }
        return message;
    }
}
