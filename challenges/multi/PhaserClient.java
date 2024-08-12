package challenges.multi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

public class PhaserClient implements Runnable {
	
	private Phaser phaser;
	private List<Integer> list = new ArrayList<Integer>();
	
	public PhaserClient(Phaser phaser, List<Integer> list) {
		this.phaser = phaser;
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//phaser.register();
		System.out.println(Thread.currentThread().getName()+" arrived");
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		phaser.arriveAndAwaitAdvance();

	}

}
