package ua.nure.matyash.practice5;
public class Counter {
	private int firstCounter;
	private int secondCounter;
	private static final int N_10 =10;
	public void increment() {
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

	public void eq() {
		if(firstCounter > secondCounter) {
			System.out.println("firstCounter > secondCounter");
		}

		if(firstCounter == secondCounter) {
			System.out.println("firstCounter = secondCounter");
		}

		if(firstCounter < secondCounter) {
			System.out.println("firstCounter < secondCounter ");
		}


	}

}
