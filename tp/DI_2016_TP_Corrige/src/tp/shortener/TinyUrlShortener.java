package tp.shortener;

import com.google.inject.Inject;

import tp.shortener.connection.Connection;

public class TinyUrlShortener implements Shortener {
	
	@Inject
	private Connection connection;
	
	@Override
	public String shorten(String text) {
		return this.connection.sendMessage(text);
	}

}
