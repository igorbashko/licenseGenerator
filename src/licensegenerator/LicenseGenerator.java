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
public class LicenseGenerator{
/**Project for generating licensing for
* containerCalculator software
* @param args the command line arguments
*/

    public static void main(String[] args) throws NoSuchAlgorithmException {
    test testYo = new test();
       System.out.println(testYo.returnKey("234hgfhfghfghgf1", "chechrgdfgfd"));
   }
}