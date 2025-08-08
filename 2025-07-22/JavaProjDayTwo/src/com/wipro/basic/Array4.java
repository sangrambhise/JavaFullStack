package com.wipro.basic;

public class Array4 {

	public static void main(String[] args) {
		int[] arr={1,2,2,3,4,4,5,8};
        int n=arr.length;
        int arr2 = 0;
        for (int i=1;i<n;i++) {
            if (arr[i]!=arr[arr2]) {
            	arr2++;
                arr[arr2]=arr[i];
            }
        }
        for (int i = 0; i <= arr2; i++) {
            System.out.print(arr[i] + " ");
        }
	}

}
