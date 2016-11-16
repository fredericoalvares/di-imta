package tp;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

import tp.login.Login;
import tp.login.LoginConsole;
import tp.login.crypto.Cryptographer;
import tp.login.crypto.DummyCryptographer;
import tp.login.data.FileLoginData;
import tp.login.data.LoginData;
import tp.shortener.Shortener;
import tp.shortener.TinyUrlShortener;
import tp.shortener.connection.Connection;
import tp.shortener.connection.SoapConnection;
import tp.twitter.GSMTwitter;
import tp.twitter.SmsTwitter;
import tp.twitter.Twitter;
import tp.twitter.transmitter.AndroidTransmitter;
import tp.twitter.transmitter.Transmitter;


public class Module3 extends AbstractModule {

	@Override
	protected void configure() {
		bind(Login.class).to(LoginConsole.class);
		bind(Shortener.class).to(TinyUrlShortener.class);
		bind(Twitter.class).to(GSMTwitter.class);
		
		bind(Twitter.class).annotatedWith(Names.named("Twitter2")).to(SmsTwitter.class);
		
		
		bind(Cryptographer.class).to(DummyCryptographer.class);
		bind(LoginData.class).to(FileLoginData.class);
		
		bind(Transmitter.class).to(AndroidTransmitter.class);
		
		bind(Appendable.class).toInstance(System.out);
		
		bind(Appendable.class).annotatedWith(Names.named("AppendableDeSms")).toInstance(System.err);
		bind(Appendable.class).annotatedWith(Names.named("AppendableDeAndroid")).toInstance(System.err);
		
		
		
	}
	
	@Provides
	Connection provideCryptographer() {
		SoapConnection connection = new SoapConnection(System.out);
		connection.setUrl("http://ti.ny/soap");
		return connection;
	}

}
