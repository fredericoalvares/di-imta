package factory;

public class TestStaticFactory {

	public static void main(String[] args) {
		
		String msg = "Twitter is an online social networking service that enables "
				+ "users to send and read short 140-character messages called \"tweets\". Registered "
				+ "users can read and post tweets, but unregistered users can only "
				+ "read them.";
		
		TwitterFactory.set(new MockTwitter());
		
		
		TwitterClient client = new TwitterClient();
		
		client.post(msg);
		
		
		TwitterFactory.set(null);
		
		
		TwitterClient client2 = new TwitterClient();
		client2.post(msg);
	}

}
