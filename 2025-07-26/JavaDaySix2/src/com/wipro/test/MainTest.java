package com.wipro.test;
import com.wipro.menudemo.Counter;
import com.wipro.menudemo.CounterThread;
public class MainTest {
 public static void main(String[] args) {
     Counter counter=new Counter();
     Thread t1=new CounterThread(counter);
     Thread t2=new CounterThread(counter);
     t1.start();
     t2.start();
     try {
         t1.join();
         t2.join();
     } catch (InterruptedException e) {
    	 // TODO Auto-generated catch block
         e.printStackTrace();
     }
     System.out.println(counter.getCount());
 }
}
