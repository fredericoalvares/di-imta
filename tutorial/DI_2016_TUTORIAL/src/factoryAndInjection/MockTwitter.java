package factoryAndInjection;

public class MockTwitter implements Twitter {

	@Override
	public void send(String msg) {
		System.out.println("Message send by MockTweeter : " + msg);
	}

}
