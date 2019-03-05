package ua.nure.matyash.practice5;

class MyThread extends Thread{
	private static final int N_300= 300;
	private static final int N_3000= 3000;
	MyThread(){
	}
	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		while(N_3000>= System.currentTimeMillis() - startTime) {
			try {
				Thread.sleep(N_300);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}

			System.out.println(Thread.currentThread().getName());
		}
	}
}
