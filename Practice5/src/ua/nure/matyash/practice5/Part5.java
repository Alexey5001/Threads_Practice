package ua.nure.matyash.practice5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Part5 {

	private Thread[] threads;
	private RandomAccessFile accessFile;
	private static final String FILE = "part5.txt";
	private static final int N_10 = 10;
	private static final int N_20 = 20;

	public Part5() throws FileNotFoundException {
		threads = new MyThread2[N_10];
		accessFile = new RandomAccessFile(FILE, "rw");
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new MyThread2(accessFile, i * (N_20 + System.lineSeparator().length()));
		}

	}


	public void run() {

		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}

	public String read() throws IOException {
		accessFile = new RandomAccessFile(FILE, "r");
		StringBuilder sb = new StringBuilder();
		int b = accessFile.read();

		while (b != -1) {
			sb.append((char) b);
			b = accessFile.read();
		}
		accessFile.close();

		return sb.toString();
	}
	private void waitThreads() throws InterruptedException {
		for (int i = 0; i < threads.length; i++) {
			while (threads[i].isAlive()) {
				Thread.sleep(N_10);
			}
		}
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		Part5 p6 = new Part5();
		p6.run();
		p6.waitThreads();
		System.out.println(p6.read());

	}

}