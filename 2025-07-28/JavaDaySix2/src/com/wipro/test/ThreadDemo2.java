package com.wipro.test;
import com.wipro.menudemo.NumThread;
import com.wipro.menudemo.AlpThread;
public class ThreadDemo2{
	    public static void main(String[] args){
	        NumThread NumThread=new NumThread();
	        AlpThread AlpThread=new AlpThread();
	        NumThread.start();
	        AlpThread.start();
	        try{
	            NumThread.join();
	            AlpThread.join();
	        } catch (InterruptedException e){
	        	// TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }


}
