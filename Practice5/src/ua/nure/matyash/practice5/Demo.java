package ua.nure.matyash.practice5;

import java.io.IOException;

public class Demo {

	public static void main(String[] args) throws InterruptedException, IOException {

		printSeparator(0);
		System.out.println("PART1");
		Part1.main(args);

		printSeparator(6000);
		System.out.println("PART2");
		Spam.main(args);

		printSeparator(6000);
		System.out.println("PART3");
		Part3.main(args);

		printSeparator(6000);
		System.out.println("PART4");
		Part4.main(args);

		printSeparator(6000);
		System.out.println("PART5");
		Part5.main(args);

		try {
			Part5.main(args);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void printSeparator(int timeSleep) throws InterruptedException {
		Thread.sleep(timeSleep);
		System.out.print("===========================");

	}

}
