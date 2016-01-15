/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decryptor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author igor
 */
public class decrypt {
    private String pathToFile;
    private String pass;
    
    public decrypt(String pathToFile, String pass){
        this.pathToFile = pathToFile;
        this.pass = pass;
    }
    
    private String readMessage() {
        try{
        FileInputStream stream = new FileInputStream(pathToFile);
        catch(FileNotFound)
    }
}
