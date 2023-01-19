/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unti;


import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author DELL
 */
public class Security {
    
    public static String enCryption(String original){
     

           try {
            String SECRET_KEY = "hoanglephanh277.";
            SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] byteEncrypted = cipher.doFinal(original.getBytes());
            String encrypted = Base64.getEncoder().encodeToString(byteEncrypted);
            return encrypted;
      } catch (Exception e) {
            e.printStackTrace();
      }
        return null;
        
    }
    public static String deCryption(String str){
        
           try {
               String SECRET_KEY = "hoanglephanh277.";
             SecretKeySpec skeyKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeyKeySpec);

            byte[] byteEncrypted = Base64.getDecoder().decode(str);
            byte[] byteDecryted = cipher.doFinal(byteEncrypted);
            String decryted = new String(byteDecryted);

            return decryted;
      } catch (Exception e) {
            e.printStackTrace();
      }
        return null;
        
    }
}
