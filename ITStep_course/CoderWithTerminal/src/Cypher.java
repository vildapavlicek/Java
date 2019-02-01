/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;

/**
 *basic template for cipher
 * @author Student
 */
public abstract class Cypher {

    /**
     *Encode String input
     * @param string
     */
    public void encode(String string){}

    /**
     *Encode File input
     * @param file
     */
    public void encode(File file){}

    /**
     *Decode String input
     * @param string
     */
    public void decode(String string){}

    /**
     *Decode File input
     * @param file
     */
    public void decode(File file){}
}
