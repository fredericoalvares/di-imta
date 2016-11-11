package tp.shortener.connection;

public class ConnectionFactory {
	
	private static Connection instance;
	
	public static Connection create(){
		if (instance == null){
			instance = new SoapConnection(System.out);
		}
		
		return instance;
	}
}
