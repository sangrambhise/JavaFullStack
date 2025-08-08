package com.wipro.menudemo;
public class AlpThread extends Thread {
	@Override
    public void run(){
        for (char char1='A';char1<='J';char1++){
            System.out.println(char1);
            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}
