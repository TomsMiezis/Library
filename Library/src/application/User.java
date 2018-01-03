package application;

import java.util.ArrayList;
import java.util.Random;

public class User {
	private String username;
	private long password;
	private int ID;
	private int salt;
	private static Random rand = new Random();
	private static ArrayList<Integer> IDs = new ArrayList<Integer>();
	
	public User(String username, String password, int ID) {
	this.username = username;
	salt = rand.nextInt(1000000)+10;
	setPassword(password);
	this.ID = ID; 
	IDs.add(ID);
	}

	public String getUsername() {
		return username;
	}

	public long getID() {
		return ID;
	}

	public static ArrayList<Integer> getIDs() {
		return IDs;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = doMaths(password);
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	private long doMaths(String input) {
		long temp = 0;
		for (int i=0;i<input.length();i++) {
			temp = (long) (temp + Math.pow(((int)input.charAt(i)),(i%5)+1));
		}
		temp = temp * salt;
		return temp;
	}
	public boolean checkPass(String newPass) {
		return doMaths(newPass)==password;
	}
	
	
}
