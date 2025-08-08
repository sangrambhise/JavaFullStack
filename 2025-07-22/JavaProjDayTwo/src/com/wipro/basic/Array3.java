package com.wipro.basic;

public class Array3 {

	public static void main(String[] args) {
		 int[] arr={30,5,20,8,15};
	        int lar=arr[0];
	        int secLar=arr[0];
	        for (int i=1;i<arr.length;i++) {
	            if (arr[i]>lar) {
	                secLar=lar;
	                lar=arr[i];
	            } else if (arr[i]>secLar && arr[i]!=lar) {
	                secLar=arr[i];
	            }
	        }

	        System.out.println(secLar);
	    }


}
