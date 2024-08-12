package challenges.multi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicInteger;

public class PhaserDemo {
	
	private static List<Integer> list = new ArrayList<>(); 

	public static void main(String[] args) {
		AtomicInteger ai = new AtomicInteger(1);
		System.out.println(ai.addAndGet(10));
		Phaser ph = new Phaser(2);
		Thread t1 = new Thread(new PhaserClient(ph, list));
		Thread t2 = new Thread(new PhaserClient(ph, list));

		t1.start();
		t2.start();
		
		//ph.bulkRegister(4);
		
		System.out.println(" main thread waiting ");
		//ph.awaitAdvance(0);
		
		System.out.println(" Main thread resumed ::::"+list);
	}

}
