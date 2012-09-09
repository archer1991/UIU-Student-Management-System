package pk1;

import java.io.Serializable;

public class Admin implements Serializable {
	public String name;
	public String password;

	public Admin() {

	}

	public Admin(String name, String password) {
		this.name = name;
		this.password = password;

	}

}
