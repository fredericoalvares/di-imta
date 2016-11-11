package tp.shortener;

import tp.shortener.connection.Connection;

public class TinyUrlShortener implements Shortener {
	
	private Connection connection;
	
	
	
	public TinyUrlShortener(Connection connection) {
		this.connection = connection;
	}



	@Override
	public String shorten(String text) {
		return this.connection.sendMessage(text);
	}

}
