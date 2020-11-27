/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes_des;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

 
/**
 *
 * @author Eda
 */

 



public class DES{

public String encriptar (String texto, String llave) throws NoSuchAlgorithmException, NoSuchPaddingException{

SecretKeySpec key = new SecretKeySpec(llave.getBytes(), "DES");
String base64 = "";
Cipher cipher;

 try{
            //crear la instancia de AES
            cipher = Cipher.getInstance("DES");
            
            //inicializamos el cifrado
            cipher.init(Cipher.ENCRYPT_MODE, key);
            
            //debemos de tener en un arreglo de bytes el mensaje a cifrar
            
            byte[] campoCifrado = cipher.doFinal(texto.getBytes());
            
             String mensaje_cifrado = new String(campoCifrado);
      
            //para poderlo codificar hay que pasarlo a base 64 
            
             base64 = new BASE64Encoder().encode(campoCifrado);
            
           
            
           
        }catch(Exception e){
            
            System.out.println("Error no se pudo T_T");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
      
        }
      return base64 ;
    }

public String descriptar (String llave,  String texto_des){
   
SecretKeySpec key = new SecretKeySpec(llave.getBytes(), "DES");
String mensaje_cifrado = "";
Cipher cipher;

 try{
            //crear la instancia de AES
            cipher = Cipher.getInstance("DES");
            
            //inicializamos el cifrado
            cipher.init(Cipher.DECRYPT_MODE, key);
            
            //debemos de tener en un arreglo de bytes el mensaje a cifrar
            byte[] holi = new BASE64Decoder().decodeBuffer(texto_des);
            
            byte[] campoCifrado = cipher.doFinal(holi);
            
            mensaje_cifrado = new String(campoCifrado);
      
            //para poderlo codificar hay que pasarlo a base 64 
            
             
            
           
            
           
        }catch(Exception e){
            
            System.out.println("Error no se pudo T_T");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
      
        }
      return mensaje_cifrado ;
}

}
