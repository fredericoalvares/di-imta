package tp.login.data;

public class DataFactory {
	
	private static LoginData instance;
	
	public static LoginData get(){
		if (instance != null){
			return instance;
		}
		
		
		return new FileLoginData();
	}
}
