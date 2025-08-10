package com.wipro.test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadDemo4 {
	    public static void main(String[] args) {
	        ExecutorService t1 = Executors.newFixedThreadPool(5);
	        for(int i=1;i<=5;i++) {
	            int id=i;
	            t1.submit(()->{
	                for(int j=1;j<=10;j++) {
	                    System.out.println(id+"  "+j);
	                     try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
	            });
	        }
	        t1.shutdown();
	    }
}
