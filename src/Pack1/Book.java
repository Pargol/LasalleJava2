package Pack1;

public class Book {
	
	private int numOfPages;
	private String author;
	
	public Book() {
		numOfPages = 100;
		author = "Pargol";
	}
	
	public Book(Book b) {
		this.numOfPages = b.numOfPages;
		this.author = b.author;
	}
	
	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}

	@Override
	public String toString() {
		return "Book [numOfPages=" + numOfPages 
				+ ", author=" + author + "]";
	}

	
}
