package com.practice.threadpools;

public class MessageProcessor implements Runnable {

	private int message;
	
	public MessageProcessor(int message) {
		this.message=message;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "[Received] message" + message);
		
		respondToMessage(); // make thread sleep to simulate doing some work
		
		System.out.println( Thread.currentThread().getName() + "[Done] processing message" + message);
		
	}

	private void respondToMessage() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("unable to process message");
		}
		
	}
	
}
