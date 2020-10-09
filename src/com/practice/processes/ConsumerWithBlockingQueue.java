package com.practice.processes;

import java.util.concurrent.BlockingQueue;

public class ConsumerWithBlockingQueue implements Runnable {

		BlockingQueue<Integer> quesQueue;
		int questionNo;
		
		
		public ConsumerWithBlockingQueue(BlockingQueue<Integer> quesQueue) {
			this.quesQueue=quesQueue;
		}
		
		@Override
		public void run() {
			while (true) {
				synchronized (this) {
					try {
						Thread.sleep(1000);
						System.out.println("Answered no " + quesQueue.take());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}
