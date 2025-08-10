package com.wipro.filedemo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class FileDemo1 {
	    public static void main(String[] args) {
	        String src="C://Users//Sangram Bhise//Desktop//Programs//1.png";
	        String target="C://Users//Sangram Bhise//Desktop//Programs//Java//Workspace//JavaDaySix//src//com//wipro//filedemo//2.png";
	        try (FileInputStream fin=new FileInputStream(src);
	             FileOutputStream fou=new FileOutputStream(target)){
	            byte[] buffer=new byte[3072];
	            int read;
	            while ((read=fin.read(buffer))!=-1){
	                fou.write(buffer, 0, read);
	            }
	            System.out.println("image copied");
	        } catch(IOException e){
	            System.out.println("Error" + e.getMessage());
	            e.printStackTrace();
	        }
	    }
}
