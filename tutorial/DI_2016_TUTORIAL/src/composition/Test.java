package composition;

public class Test {

	public static void main(String[] args) {
		
		TwitterClient client = new TwitterClient();
		
		client.post("Twitter is an online social networking service that enables "
				+ "users to send and read short 140-character messages called \"tweets\". Registered "
				+ "users can read and post tweets, but unregistered users can only "
				+ "read them.");
		

	}

}
