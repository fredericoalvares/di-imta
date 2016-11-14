package injection;

public class TwitterClient {
	
	private Shortener shortener;
	private Twitter twitter;
	
	public TwitterClient(Shortener shortener, Twitter twitter) {
		this.shortener = shortener;
		this.twitter = twitter;
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
