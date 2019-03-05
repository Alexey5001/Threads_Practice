package ua.nure.matyash.practice5;

public class SynCounter {
	private int firstCounter;
	private int secondCounter;
	private static final int N_10 = 10;

	public synchronized void increment() {
		try {
			Thread.sleep(N_10);
			firstCounter++;
			Thread.sleep(N_10);
			secondCounter++;

		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	public synchronized void eq() {
		if(firstCounter > secondCounter) {
			System.out.println("Synchronized: firstCounter > secondCounter");
		}

		if(firstCounter == secondCounter) {
			System.out.println("Synchronized: firstCounter = secondCounter");
		}

		if(firstCounter < secondCounter) {
			System.out.println("Synchronized: firstCounter < secondCounter ");
		}


	}

}
