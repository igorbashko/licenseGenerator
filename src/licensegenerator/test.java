/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package licensegenerator;
import java.security.NoSuchAlgorithmException;
/**
*
* @author igorbashka
*/
public class test {
/**Project for generating licensing for
* containerCalculator software
* @param args the command line arguments
*/
/**
* Method for generating the license key
* @param value passphrase or unique id for encryption
* @param algorithm can md5 or sha1 hashing algorithm
* @return hexString for further processing
*/
private String generateHex(String value, String algorithm)
throws NoSuchAlgorithmException{
String hexEncode ="";
byte [] buffer = value.getBytes();
java.security.MessageDigest messageDigest =
java.security.MessageDigest.getInstance(algorithm);
messageDigest.update(buffer);
byte [] messageBytes = messageDigest.digest();
for (int index=0; index<messageBytes.length; index++){
int countNumber = messageBytes[index] & 0xff;
if(Integer.toHexString(countNumber).length()==1)
hexEncode = hexEncode + 0;
hexEncode = hexEncode + Integer.toHexString(countNumber);
}
return hexEncode;
}
/**
 * Returns final license key
 * @param uniqueId
 * @param passphrase
 * @return 
 */
public String returnKey(String uniqueId, String passphrase) throws NoSuchAlgorithmException{
    String keyMessage = generateHex(uniqueId,"MD5")+generateHex(passphrase, "SHA1");
    String key = "";
    int [] keyKeys = {1, 3, 5, 9, 4, 2, 7, 11, 12, 21, 13, 17, 14, 15, 16, 18, 8, 0};
    for (int i=0; i<keyKeys.length; i++){
        key+=keyMessage.charAt(keyKeys[i]);
    }
    return keyMessage;
  }
}