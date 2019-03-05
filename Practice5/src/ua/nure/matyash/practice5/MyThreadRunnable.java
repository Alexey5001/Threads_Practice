package ua.nure.matyash.practice5;

class MyThreadRunnable implements Runnable {
	private static final int N_200= 200;
	private static final int N_2000= 2000;

	MyThreadRunnable(){
	}
	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		while(N_2000>= System.currentTimeMillis() - startTime) {
			try {
				Thread.sleep(N_200);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
			System.out.println(Thread.currentThread().getName());
		}
	}

}
