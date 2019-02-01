/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storesim;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 *
 * @author vilda
 */
public class WriterHandler {

    /**
     * This procedure generates new Class extending Item, should be used if you
     * are lazy to make new Item from scratch.
     *
     * @param className - name of the Class, used as name for file too
     * @param price - attribute of item
     * @param unit - attribute of item
     * @throws java.lang.Exception
     */
    public void itemBuilder(String className, float price, String unit) throws Exception {
        String fileName = className + ".java";
        unit = unit.toUpperCase();
        File file = new File("./src/storesim/Items/" + fileName);

        if (unit.equals("KGS") || unit.equals("PIECES") || unit.equals("GRAMS")) {

            try (Writer output = new BufferedWriter(new FileWriter(file))) {

                output.write("package storesim.Items;\n");
                output.write("public class " + className + " extends Item {\n");
                output.write("\n");
                output.write("public " + className + "() {\n");
                output.write("this.name = \"" + className + "\";\n");
                output.write("this.price = " + price + "f;" + "\n");
                output.write("this.unit = Units." + unit + ";\n");
                output.write("}\n}");
                output.close();
                System.out.println("File created and written succesfully at path: " + file.getAbsolutePath());

            } catch (Exception e) {
                System.err.println("Chyba vytvoreni souboru a/nebo zapisu do souboru");
            }
        } else {
            System.out.println("Unit has to be either \"KGS\" or \"GRAMS\" or \"PIECES\" ");
            throw new Exception("New item not created. Wrong unit entered");
            
        }

    }
}
