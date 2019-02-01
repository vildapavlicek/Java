/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuckbook;

import java.util.ArrayList;

/**
 *
 * @author Vilda
 */
public class CourtesanList implements java.io.Serializable {

    ArrayList<Courtesan> data = new ArrayList<Courtesan>();

    @Override
    public String toString() {
        String dataElements = "";
        for (Courtesan courtesan : data) {
            dataElements += courtesan.toString() + " " + "\n";

        }
        return "ContactList(" + dataElements + ")";

    }

}
