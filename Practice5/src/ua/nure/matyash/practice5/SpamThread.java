package ua.nure.matyash.practice5;

class SpamThread extends Thread{
	private String messages;
	private int times;
	private boolean check ;
	SpamThread (String messages, int times){
		this.messages = messages;
		this.times = times;
		check = true;
	}
	@Override
	public void run() {
		while(check) {
			System.out.println(messages);
			try {
				Thread.sleep(times);
			} catch (InterruptedException e) {
				check = false;
				Thread.currentThread().interrupt();
			}
		}
	}


}
