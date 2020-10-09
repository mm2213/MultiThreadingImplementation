package com.practice.processes;

import java.util.List;

public class Consumer implements Runnable {
	List<Integer> quesList=null;
//	final int LIMIT=5;
//	private int questionNo;
	
	public Consumer() {
		
	}
	
	public Consumer(List<Integer> quesList) {
		this.quesList=quesList;
	}
		
	
	public void ansQues() throws InterruptedException {
		synchronized (quesList) {
			while(quesList.isEmpty()) {
				System.out.println("No questions to ans");
					quesList.wait();	
			}
		}
		
		
		synchronized (quesList) {
			Thread.sleep(1000000);
			System.out.println("Answered questions no " + quesList.remove(0));
			quesList.notify();
		}
		
	}

	@Override
	public void run() {
		try {
			ansQues();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}	