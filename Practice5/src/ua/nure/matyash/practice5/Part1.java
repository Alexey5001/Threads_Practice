package ua.nure.matyash.practice5;

public class Part1  {

	public static void main(String[] args) {
		MyThread thread1 = new MyThread();
		new Thread(new MyThreadRunnable()).start();
		thread1.start();


	}

}

