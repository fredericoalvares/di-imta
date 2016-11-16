package tp;

import com.google.inject.AbstractModule;

import tp.login.Login;
import tp.login.LoginConsole;
import tp.login.crypto.Cryptographer;
import tp.login.crypto.DummyCryptographer;
import tp.login.data.LoginData;
import tp.login.data.MemoryLoginData;
import tp.shortener.DummyUrlShortener;
import tp.shortener.Shortener;
import tp.shortener.connection.Connection;
import tp.shortener.connection.RestConnection;
import tp.twitter.SmsTwitter;
import tp.twitter.Twitter;
import tp.twitter.transmitter.IosTransmitter;
import tp.twitter.transmitter.Transmitter;


public class Module1 extends AbstractModule {

	@Override
	protected void configure() {
		bind(Login.class).to(LoginConsole.class);
		bind(Shortener.class).to(DummyUrlShortener.class);
		bind(Twitter.class).to(SmsTwitter.class);
		bind(Cryptographer.class).to(DummyCryptographer.class);
		bind(LoginData.class).to(MemoryLoginData.class);
		bind(Connection.class).to(RestConnection.class);
		bind(Transmitter.class).to(IosTransmitter.class);
		bind(Appendable.class).toInstance(System.out);
	}

}
