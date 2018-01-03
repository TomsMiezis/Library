package application;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Client extends User {
	private ArrayList<Book> booksGiven;
	private ArrayList<Date> bookDeadlines;
	private int penaltyEUR;
	public static int EURPerDay=2;
	public Client(String username, String password) {
		super(username, password, GenerateID());
		booksGiven = new ArrayList<Book>();
		bookDeadlines = new ArrayList<Date>();
		penaltyEUR = 0;
	}
	private static int GenerateID() {
		Random rand = new Random();
		int NewID = rand.nextInt(1000000);
		while (User.getIDs().contains(NewID)) {
			NewID = 1000000+rand.nextInt(1000000);
		}
		return NewID;
	}
	public void GiveBook(Book given, Date deadline) {
		if (given.CanBeGiven()) {
			booksGiven.add(given);
			bookDeadlines.add(deadline);
			given.BookGiven();
		} else {
			//TODO: no such book available
		}
	}
	public void ReturnBook(Book given) {
		int index = booksGiven.indexOf(given);
		if (index>=0 && given.CanBeReturned()) {
			Date now = new Date(Calendar.getInstance().getTimeInMillis());
			booksGiven.remove(index);
			bookDeadlines.remove(index);
			given.BookReturned();
			if (!(now).before(bookDeadlines.get(index))) {
				long days = now.getTime()-bookDeadlines.get(index).getTime();
				days = days/86400000; // 86400000 = ms per day
				penaltyEUR = penaltyEUR + (int)days*EURPerDay;
			}
		} else {
			//TODO: no such book exists or given to client 
		}
	}
}
