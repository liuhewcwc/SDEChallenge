package com.paytmlabs.sdechallenge.service;

import java.util.List;

public interface MovingService<T> {
	
	/**
	 * adding element into data structure
	 * @param element
	 */
	public void addElement(T element);
	
	/**
	 * returning items that inside the data structure
	 * @return list of elements
	 */
	public List<T> getElements();
	
	/**
	 * calculating the average of the last N elements
	 * @return
	 */
	public T getAverage();


}
