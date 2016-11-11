package tp.login;

import tp.login.crypto.CryptoFactory;
import tp.login.crypto.Cryptographer;
import tp.login.data.DataFactory;
import tp.login.data.LoginData;

public class LoginFactory {
	
	private static Login instance;
	
	public static Login get(){
		if (instance != null){
			return instance;
		}
		
	    Cryptographer crypto = CryptoFactory.get();
		LoginData data = DataFactory.get();
		
		return new LoginConsole(crypto,data);
	}
}
