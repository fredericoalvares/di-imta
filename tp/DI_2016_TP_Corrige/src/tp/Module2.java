package tp;

import com.google.inject.AbstractModule;

import tp.login.Login;
import tp.login.LoginConsole;
import tp.login.crypto.Cryptographer;
import tp.login.crypto.Md5Cryptographer;
import tp.login.data.LoginData;
import tp.login.data.MemoryLoginData;
import tp.shortener.Shortener;
import tp.shortener.TinyUrlShortener;
import tp.shortener.connection.Connection;
import tp.shortener.connection.SoapConnection;
import tp.twitter.MockTwitter;
import tp.twitter.Twitter;
import tp.twitter.transmitter.IosTransmitter;
import tp.twitter.transmitter.Transmitter;


public class Module2 extends AbstractModule {

	@Override
	protected void configure() {
		bind(Login.class).to(LoginConsole.class);
		bind(Shortener.class).to(TinyUrlShortener.class);
		bind(Twitter.class).to(MockTwitter.class);
		bind(Cryptographer.class).to(Md5Cryptographer.class);
		bind(LoginData.class).to(MemoryLoginData.class);
		bind(Connection.class).to(SoapConnection.class);
		bind(Transmitter.class).to(IosTransmitter.class);
		bind(Appendable.class).toInstance(System.out);
	}

}
