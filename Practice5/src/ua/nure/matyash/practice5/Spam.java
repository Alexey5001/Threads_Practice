package ua.nure.matyash.practice5;


class Spam {
	private boolean check;
	private Thread[] myThreads;
	private String[] messages = new String[]{"@@@", "bbbbbbb"};
	private static final int N_333 = 333;
	private static final int N_222 = 222;
	private static final int N_1000 = 1000;
	private int[] times = new int[]{N_333, N_222};

	Spam() {
		myThreads = new SpamThread[messages.length];
		for (int i = 0; i < messages.length; i++) {
			myThreads[i] = new SpamThread(messages[i], times[i]);
		}
		check = true;
	}

	public void startThreads() {
		for (Thread t : myThreads) {
			t.start();
		}
	}

	public void stopThreads() {
		for (Thread t : myThreads) {
			t.interrupt();
		}
	}

	public void pressEnter(String s) {


		while (check) {
			if ("".equals(s)) {
				try {
					Thread.sleep(N_1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
				stopThreads();
				check = false;
			}
		}
	}

	public static void main(String[] args) {
		Spam spam = new Spam();
		spam.startThreads();
		spam.pressEnter("");
	}

}
