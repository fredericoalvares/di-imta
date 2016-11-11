package tp.login.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Cryptographer implements Cryptographer {

	@Override
	public String encrypt(String password) {
	    MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e.getMessage());
			return null;
		}
        
		md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        
        return sb.toString();
        
    	}
}
