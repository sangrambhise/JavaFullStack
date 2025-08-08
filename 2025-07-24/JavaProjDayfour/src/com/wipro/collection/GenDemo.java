package com.wipro.collection;

public class GenDemo <T>{
	
	T t;
	
	public GenDemo(T t)
	{
		this.t=t;
	}
	
	
	public T getData()
	{
		return t;
	}
}