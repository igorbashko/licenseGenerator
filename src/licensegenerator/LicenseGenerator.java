/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package licensegenerator;
import java.security.NoSuchAlgorithmException;
import infoReader.Reader;
/**
*
* @author igorbashka
*/
public class LicenseGenerator{
/**Project for generating licensing for
* containerCalculator software
* @param args the command line arguments
*/

    public static void main(String[] args) throws NoSuchAlgorithmException {
    Reader reader = new Reader("license1.txt","license2.txt", "testPas2");    
    Generator testYo = new Generator();
       System.out.println(testYo.returnKey(reader.returnInfo(), "testPas"));
   }
}