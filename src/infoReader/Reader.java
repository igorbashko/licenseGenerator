/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infoReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.util.IOUtils;

/**
 *
 * @author igor
 */
public class Reader {
    private String pathToFile;
    private String pathToIv;
    private String pass;
    
    public Reader(String pathToFile, String pathToIv, String pass){
        this.pathToFile = pathToFile;
        this.pathToIv = pathToIv;
        this.pass = pass;
    }
    /**
     * The same as in containerController
     * @param passPhrase
     * @return secretKey
     */    
    private SecretKey generateSecretKey(String passPhrase) throws NoSuchAlgorithmException, InvalidKeySpecException{
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] salt = new byte[8];
        KeySpec specification= new PBEKeySpec(passPhrase.toCharArray(), salt, 65536, 128);
        SecretKey tmp = factory.generateSecret(specification);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
        return secret;
  }  
    /**
     * 
     * @return license info for generating security hash code
     */
    public String returnInfo(){
        String message = new String("Something went wrong");
        try{
        FileInputStream streamID = new FileInputStream(new File(pathToFile));
        FileInputStream streamIv = new FileInputStream(new File(pathToIv));
        byte [] id = IOUtils.toByteArray(streamID);
        byte [] iv = IOUtils.toByteArray(streamIv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, generateSecretKey(pass), new
      IvParameterSpec(iv));
        message = new String(cipher.doFinal(id), "UTF-8");
        }
        catch(IOException | GeneralSecurityException ex){
         ex.printStackTrace();
         }
        return message;
    }
}
