package com.wipro.test;
import java.util.Arrays;
import java.util.List;
public class ThreadDemo3 {
    public static void main(String[] args) {
        List<String> l1=Arrays.asList("Aman","Amit","Rohan","Roshan","Raju","Raman","Prathamesh","Ravi");
        Runnable cap=()->{
            for (int i=0;i<l1.size();i++) {
                String a1=l1.get(i);
                if ("AEIOUaeiou".indexOf(a1.charAt(0))!= -1){
                        l1.set(i,a1.toUpperCase());
                }
            }
        };
        
        Runnable low=()->{
            for (int i=0;i<l1.size();i++){
                String a2=l1.get(i);
                if ("AEIOUaeiou".indexOf(a2.charAt(0))==-1){
                        l1.set(i,a2.toLowerCase());
                }
            }
        };
        Thread thread1=new Thread(cap);
        Thread thread2=new Thread(low);
        thread1.start();
        thread2.start();
        try {
			thread1.join();
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println(l1);
    }
}
