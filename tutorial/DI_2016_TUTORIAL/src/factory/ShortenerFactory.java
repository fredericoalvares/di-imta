package factory;

public class ShortenerFactory {
	
	private static Shortener instance;
	
	public static Shortener get(){
		if (instance == null){
			instance = new TinyUrlShortener();
		}
		
		return instance;
	}
	
	public static void set(Shortener shortener){
		instance = shortener;
	}
}
