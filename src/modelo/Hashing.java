package modelo;

import java.math.BigInteger;  
import java.nio.charset.StandardCharsets;  
import java.security.*; 

/*
 * Clase encargada de obtener hashes provenientes de claves de 32 bits escritas
 * por el usuario para almacenar en la base de datos (en caso de registro), o
 * para verificar un login (en caso de intento de inicio de sesión).
 * @author Carballo
 */

public class Hashing {
	
	/*
	 * Devuelve el hash SHA-256 resultante del String introducido en la entrada
	 */
	public static byte[] getSHA(String pass) throws NoSuchAlgorithmException  { 
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte enc[] = sha.digest(pass.getBytes(StandardCharsets.UTF_8));
        return enc;
    }
	/*
	 * Convierte hash a una variable de tipo String para comparar/almacenar en bbdd
	 */
	public static String toString(byte[] encSHA) {
		BigInteger num = new BigInteger(1, encSHA);  
		StringBuilder a = new StringBuilder(num.toString(16)); //Convierte a valor hexadecimal
		//Rellena con 0s los bytes no ocupados a la izqda
		while (a.length() < 32) {  
            a.insert(0, '0');
        }
		return a.toString();
	}
	
	
}
