package com.paytmlabs.sdechallenge.service.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import com.paytmlabs.sdechallenge.service.MovingService;

public class MovingDoubleImpl implements MovingService<Double> {
	
	//windowSize defined the last of "N" digits
	private int windowSize;
	
	//storing all added elements
	private List<Double> list;
	
	/**
	 * providing constructor to initial this instance
	 * @param size
	 */
	public MovingDoubleImpl(int size) {
		
		//we shouldn't allow window side less or equal than zero
		if(size <= 0) {
			throw new IllegalArgumentException("Window size should not less or equal than zero!");
		}
		this.windowSize = size;
		this.list = new ArrayList<>();
	}
	
	@Override
	public void addElement(Double element) {
		list.add(element);
	}

	@Override
	public List<Double> getElements() {
		return list;
	}

	@Override
	public Double getAverage() {
		double avergae = 0d;
		
		if(windowSize <= list.size()) {
			double sum = 0;
			for(int i = list.size() - windowSize; i < list.size(); i++) {
				sum+=list.get(i);
			}
			avergae = new BigDecimal(sum/windowSize).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		else {
			System.out.println("Couldn't find out average of the last " + windowSize 
					+ " elements since the size of the list is " + list.size());
		}
		
		return avergae;
	}


}
