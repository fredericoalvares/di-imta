package tp.login.crypto;

public class DummyCryptographer implements Cryptographer {
	
	
	
	@Override
	public String encrypt(String password) {
	   
		
		byte data [] =  password.getBytes();
		
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < data.length; i++) {
         sb.append(data[i] + 5);
        }

        System.out.println(sb);
        
        return sb.toString();
        
    	}

}
