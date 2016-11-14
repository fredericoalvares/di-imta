package injectionWithGuice;

public class SmsTwitter implements Twitter {

	@Override
	public void send(String msg) {
		System.out.println("Message send by SmsTweeter : " + msg);
	}

}
