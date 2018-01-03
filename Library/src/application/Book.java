package application;

public class Book {
	private String author;
	private String title;
	private long ISBN;
	private String lang;
	private String orgLang;
	private String traName;
	private String publisher;
	private String country;
	private int total;
	private int avail;
	
	public Book(String author, String title, long ISBN, String lang, String orgLang, String traName, String publisher) {
		this(author, title, ISBN, lang, orgLang, traName, publisher, 1);
	}
	
	public Book(String author, String title, long ISBN, String lang, String publisher) {
		this(author, title, ISBN, lang, lang, "", publisher, 1);
	}
	public Book(String author, String title, long ISBN, String lang, String publisher, int total) {
		this(author, title, ISBN, lang, lang, "", publisher, total);
	}
	
	public Book(String author, String title, long ISBN, String lang, String orgLang, String traName, String publisher, int total) {
		this.author = author;
		this.title = title;
		this.ISBN = ISBN;
		this.lang = lang;
		this.orgLang = orgLang;
		this.traName = traName;
		this.publisher = publisher;
		this.total = total;
		this.avail = total;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public long getISBN() {
		return ISBN;
	}

	public String getLang() {
		return lang;
	}

	public String getOrgLang() {
		return orgLang;
	}

	public String getTraName() {
		return traName;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getCountry() {
		return country;
	}

	public int getTotal() {
		return total;
	}

	public int getAvail() {
		return avail;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public void setOrgLang(String orgLang) {
		this.orgLang = orgLang;
	}

	public void setTraName(String traName) {
		this.traName = traName;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setAvail(int avail) {
		this.avail = avail;
	}
	public boolean CanBeGiven() {
		if (avail>0)
			return true;
		else
			return false;
	}
	public void BookGiven() {
		avail--;
	}
	public boolean CanBeReturned() {
		if (avail<total)
			return true;
		else
			return false;
	}
	public void BookReturned() {
		avail++;
	}
	

	/*
	private static boolean NoNumbers(String input) {
		boolean reply = true;
		for (int i=0;i<input.length();i++) {
			if (Character.isDigit(input.charAt(i)))
				reply = false;
		}
		return reply;
	}
	*/
}
