/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuckbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Vilda
 */
public class SerializeDeserialize {

    public static void serializace(CourtesanList cl) {

        // System.out.println("Before serialization");
        try {
            FileOutputStream fos = new FileOutputStream("topSecret.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cl);
            oos.close();
            fos.close();
            System.out.println("Ulozeno");

        } catch (IOException e) {
            System.err.print(e);

        }

    }

    public static CourtesanList deserializace() throws FileNotFoundException {
        CourtesanList newCl;
        newCl = null;
        try {

            FileInputStream fis = new FileInputStream("topSecret.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            newCl = (CourtesanList) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Done");

        } catch (IOException | ClassNotFoundException e) {

        }
        return newCl;
    }

}

/*
 int i = ois.readInt();
      String today = (String) ois.readObject();
      Date date = (Date) ois.readObject();

      ois.close();
 
 */
