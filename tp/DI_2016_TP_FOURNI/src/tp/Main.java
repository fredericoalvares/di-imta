package tp;

import tp.client.TwitterClient;
import tp.client.TwitterClientFactory;

public class Main {

	public static void main(String[] args) {
		
		String msg = "Twitter is an online social networking service that enables "
				+ "users to send and read short 140-character messages called \"tweets\". Registered "
				+ "users can read and post tweets, but unregistered users can only "
				+ "read them.";
		
		
		TwitterClient client = TwitterClientFactory.get(); 
		client.post(msg);
		
	}

}
