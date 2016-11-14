package injectionWithGuice;

import com.google.inject.AbstractModule;

public class TweetTestModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Shortener.class).to(TinyUrlShortener.class);
		bind(Twitter.class).to(MockTwitter.class);
	}

}
