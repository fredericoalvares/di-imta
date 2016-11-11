package tp.login.crypto;

public class CryptoFactory {
	
	private static Cryptographer instance;
	
	public static Cryptographer get(){
		if (instance != null){
			return instance;
		}
		
		return new Md5Cryptographer();
	}
}
