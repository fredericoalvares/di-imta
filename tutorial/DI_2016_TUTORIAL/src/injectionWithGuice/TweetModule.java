package injectionWithGuice;

import com.google.inject.AbstractModule;

public class TweetModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Shortener.class).to(TinyUrlShortener.class);
		bind(Twitter.class).to(SmsTwitter.class);
	}

}
