package bitovydotaznik;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Student
 */
public class serializaceDeserializace {

    public static void serializace(byte[] suplik) {

        // System.out.println("Before serialization");
        try {
            FileOutputStream fos = new FileOutputStream("storage.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(suplik);

        } catch (Exception e) {

        }

    }

    public static byte[] deserializace() throws FileNotFoundException {
        byte[] newSuplik = null;
        try {

            FileInputStream fis = new FileInputStream("storage.dat");
            ObjectInputStream iis = new ObjectInputStream(fis);
            newSuplik = (byte[]) iis.readObject();
        } catch (Exception e) {

        }
        return newSuplik;
    }

}
