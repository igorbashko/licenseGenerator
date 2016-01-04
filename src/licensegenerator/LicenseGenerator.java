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
public class LicenseGenerator {
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
private String generateKey(String value, String algorithm)
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
public static void main(String[] args) {
// TODO code application logic here
}
}