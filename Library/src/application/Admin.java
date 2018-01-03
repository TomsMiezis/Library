package application;

import java.util.Random;

public class Admin extends User {
	byte level;
	public Admin(String username, String password, byte level) {
		super(username, password, GenerateID());
		this.level = level;
	}
	public Admin(String username, String password) {
		this(username, password, (byte) 0);
	}
	private static int GenerateID() {
		Random rand = new Random();
		int NewID = rand.nextInt(1000000);
		while (User.getIDs().contains(NewID)) {
			NewID = rand.nextInt(1000000);
		}
		return NewID;
	}
}
