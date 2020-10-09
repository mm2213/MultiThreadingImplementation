package com.practice.processes;

import java.util.ArrayList;
import java.util.List;


public class Producer implements Runnable {
	List<Integer> quesList=null;
	final int LIMIT=1000;
	private int questionNo;
	
	public Producer() {
		
	}
	
	public Producer(List<Integer> quesList) {
		this.quesList=quesList;
	}	
	
	public void readQues(int questionNo) throws InterruptedException {
		synchronized (quesList) {
			while(quesList.size()==LIMIT) {
				System.out.println("questions have been piled up.... wait");
					quesList.wait();	
			}
		}
		
		
		synchronized (quesList) {
			System.out.println("questions no " + questionNo);
			quesList.add(questionNo);
			Thread.sleep(100);
			quesList.notify();
		}
		
	}

	@Override
	public void run() {
		while(true) {
		try {
			readQues(questionNo++);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
	
}
