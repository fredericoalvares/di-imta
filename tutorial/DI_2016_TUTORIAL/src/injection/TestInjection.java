package injection;

public class TestInjection {

	public static void main(String[] args) {
		
		String msg = "Twitter is an online social networking service that enables "
				+ "users to send and read short 140-character messages called \"tweets\". Registered "
				+ "users can read and post tweets, but unregistered users can only "
				+ "read them.";
		
		Twitter twitter = new SmsTwitter();
		Shortener shortener = new TinyUrlShortener();
		
		TwitterClient client = new TwitterClient(shortener, twitter);
		
		client.post(msg);
		
		Twitter twitter2 = new MockTwitter();
		
		TwitterClient client2 = new TwitterClient(shortener, twitter2);
		client2.post(msg);
	}

}
