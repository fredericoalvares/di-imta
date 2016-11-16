package tp.login.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileLoginData implements LoginData {

	@Override
	public boolean checkLogin(String username, String password) {
		boolean ret=false;
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(username));
			String pwd = in.readLine();
			
			
			ret = password.equals(pwd);
			
			if (!ret){
				pwd = in.readLine();
				ret = password.equals(pwd);
			}
			
			in.close();
			
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} 
		
		
		

		return ret;
		
	}

}
