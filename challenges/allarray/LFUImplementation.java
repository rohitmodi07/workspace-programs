package challenges.allarray;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class LFUImplementation {
	
	private int size;
	private Map<Integer, Book> shelf;
	private PriorityQueue<Book> queue;
	
	public LFUImplementation(int size) {
		this.size = size;
		this.shelf = new HashMap<>();
		this.queue = new PriorityQueue<>((ob1, ob2) -> ob1.frequency-ob2.frequency);
	}
	
	public void borrow(int bookId) {
		if(!shelf.containsKey(bookId)) {
			if(shelf.size() == size) {
				Book book = queue.poll();
				shelf.remove(book.bookId);
				System.out.println("Cache block " + book.bookId + " removed.");
			}
			Book book = new Book(bookId, 1);
			shelf.put(bookId, book);
			queue.offer(book);
			System.out.println("Cache block " + bookId + " inserted.");
		}else {
			Book book = shelf.get(bookId);
			
			book.frequency += 1;
			queue.remove(book);
			queue.offer(book);
		}
	}
	
	

	public static void main(String[] args) {
		
		LFUImplementation lfuCache = new LFUImplementation(4);
		
		lfuCache.borrow(1);
        lfuCache.borrow(2);
        lfuCache.borrow(1);
        lfuCache.borrow(3);
        lfuCache.borrow(2);
        lfuCache.borrow(4);
        lfuCache.borrow(5);
        
        
        System.out.println(" queue in main :::: "+lfuCache.queue);
		System.out.println(" shelf in main :::: "+lfuCache.shelf);
        
		
	}

}
