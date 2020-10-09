package com.practice.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.practice.processes.Consumer;
import com.practice.processes.ConsumerWithBlockingQueue;
import com.practice.processes.Producer;
import com.practice.processes.ProducerWithBlockingQueue;

public class Application {
	// reading and answering the question utility..... max limit of ques- 5
	public static void main(String[] args) {
		
//		List<Integer> quesList=new ArrayList<>();
//		
//		Thread producerThread=new Thread(new Producer(quesList));
//		Thread consumerThread=new Thread(new Consumer(quesList));
//		
//		producerThread.start();
//		consumerThread.start();
		
		
		final int LIMIT=5;
		
		
		BlockingQueue<Integer> quesList2=new ArrayBlockingQueue<Integer>(LIMIT);
		
		Thread producerThreadWithBlockingQueue=new Thread(new ProducerWithBlockingQueue(quesList2));
		Thread consumerThreadWithBlockingQueue=new Thread(new ConsumerWithBlockingQueue(quesList2));
		
		producerThreadWithBlockingQueue.start();
		consumerThreadWithBlockingQueue.start();
		
		
	}

}
