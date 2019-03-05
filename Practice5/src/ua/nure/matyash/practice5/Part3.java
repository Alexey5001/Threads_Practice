package ua.nure.matyash.practice5;

public class Part3 extends Thread {
	 private Counter counter;
	 private SynCounter counter2;
	 private static final int N_5 = 5;
Part3(Counter counter, SynCounter counter2){
	this.counter = counter;
	this.counter2 = counter2;
}
  @Override
  public void run() {
	  int i = 0;
	  while(i<N_5) {
	  counter.eq();
	  counter.increment();
	  counter2.eq();
	  counter2.increment();
	  i++;
	  }
  }
  
  public static void main(String[] args) {
    Counter counter = new Counter();
    SynCounter counter2 = new SynCounter();
	Part3 thread1 = new Part3(counter,counter2);
	Part3 thread2 = new Part3(counter,counter2);
	thread1.start();
	thread2.start();
	}
}
