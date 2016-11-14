package injectionWithGuice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test {

	public static void main(String[] args) {
		
		String msg = "Twitter is an online social networking service that enables "
				+ "users to send and read short 140-character messages called \"tweets\". Registered "
				+ "users can read and post tweets, but unregistered users can only "
				+ "read them.";
		
		
		Injector injector = Guice.createInjector(new TweetModule());
		
		TwitterClient client = injector.getInstance(TwitterClient.class);

		client.post(msg);
		
		Injector injector2 = Guice.createInjector(new TweetTestModule());

		
		client =  injector2.getInstance(TwitterClient.class);

		client.post(msg);
		
	}

}
