package injection;

public class TinyUrlShortener implements Shortener {

	@Override
	public String shorten(String text) {
		
		String url = "http://ti.ny/fix";
		
		return text.substring(0, 135 - url.length()).concat("... " + url);
	}

}
