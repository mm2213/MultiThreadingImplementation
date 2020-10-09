package com.practice.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.practice.threadpools.MessageProcessor;

public class ThreadPoolDemo {
	
	public static void main(String[] args) {
		ExecutorService executor= Executors.newFixedThreadPool(2);
		
		Runnable processor=new MessageProcessor(1);
		executor.execute(processor);
		
		Runnable processor2=new MessageProcessor(2);
		executor.execute(processor2);
		
		Runnable processor3=new MessageProcessor(3);
		executor.execute(processor3);
		
		executor.shutdown();
		
	}
	
}
