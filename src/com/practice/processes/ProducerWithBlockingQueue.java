package com.practice.processes;

import java.util.concurrent.BlockingQueue;

public class ProducerWithBlockingQueue implements Runnable {
	
	BlockingQueue<Integer> quesQueue;
	int questionNo;
	
	
	public ProducerWithBlockingQueue(BlockingQueue<Integer> quesQueue) {
		this.quesQueue=quesQueue;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (this) {
				int nextQues=questionNo++;
				System.out.println("Got new ques" + nextQues);
				try {
					quesQueue.put(nextQues);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}	
