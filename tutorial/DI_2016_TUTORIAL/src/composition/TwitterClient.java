package composition;

public class TwitterClient {
	
	private Shortener shortener;
	private Twitter twitter;
	
	public TwitterClient() {
		shortener = new TinyUrlShortener();
		twitter = new SmsTwitter();
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
