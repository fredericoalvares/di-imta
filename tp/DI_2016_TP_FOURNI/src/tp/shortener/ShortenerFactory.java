package tp.shortener;

import tp.shortener.connection.Connection;
import tp.shortener.connection.ConnectionFactory;

public class ShortenerFactory {
	
	private static Shortener instance;
	
	public static Shortener create(){
		if (instance == null){
			Connection connection = 
					ConnectionFactory.create();
			instance = new TinyUrlShortener(connection);
		}
		
		return instance;
	}
	
	public static void set(Shortener shortener){
		instance = shortener;
	}
}
