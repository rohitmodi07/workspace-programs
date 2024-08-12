package challenges.allarray;

public class Book {
	
	int bookId; 
	int frequency;
	
	public Book(int bookId, int frequency) {
		this.bookId = bookId;
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", frequency=" + frequency + "]";
	}
	
	

}
