package tp.shortener;

public class DummyUrlShortener implements Shortener {

	@Override
	public String shorten(String text) {
		return text.substring(0, 135).concat("... ");
	}

}
