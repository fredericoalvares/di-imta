package factory;

public class TwitterClient {
	
	private Shortener shortener;
	private Twitter twitter;
	
	public TwitterClient() {
		shortener = ShortenerFactory.get();
		twitter = TwitterFactory.get();
	}

	public void post(String msg){
		if (msg.length() > 140){
			msg = shortener.shorten(msg);
		}
		
		if (msg.length() <= 140){
			twitter.send(msg);
		}
	}
	

}
