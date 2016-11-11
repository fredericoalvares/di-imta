package tp.login;

import java.util.Scanner;

import tp.login.crypto.Cryptographer;
import tp.login.data.LoginData;

public class LoginConsole implements Login {
	private boolean logged;
	
	private Cryptographer crypto;
	private LoginData data;
	
	public LoginConsole(Cryptographer crypto, LoginData data) {
		this.crypto = crypto;
		this.data = data;
	}

	@Override
	public void login() {
		Scanner reader = new Scanner(System.in);  
		String user;
		String pass;
		do {
			System.out.println("Username: ");
			user = reader.next(); 
			System.out.println("Password: ");
			pass = reader.next(); 
			pass = crypto.encrypt(pass);
		} while (!data.checkLogin(user, pass));
		
		reader.close();
		
		this.logged = true;
		
	}

	@Override
	public boolean isLogged() {
		return this.logged;
	}

}
