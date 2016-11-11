package tp.login.data;

import java.util.HashMap;
import java.util.Map;

public class MemoryLoginData implements LoginData {

	private Map<String,String> memory; 
	
	public MemoryLoginData() {
		this.memory = new HashMap<String,String>();
		this.memory.put("toto", "bdb8c008fa551ba75f8481963f2201da");
	}

	@Override
	public boolean checkLogin(String username, String password) {
		return this.memory.containsKey(username) &&  
			   this.memory.get(username).equals(password);
	}

}
