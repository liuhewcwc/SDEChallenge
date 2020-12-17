package com.paytemlabs.sdechallenge.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.paytmlabs.sdechallenge.service.impl.MovingDoubleImpl;

public class MovingServiceTest {
	
	private MovingDoubleImpl movingDoubleImpl;
	
	/**
	 * before run the junit test, we need to initialize MovingDoubleImpl with window size 2
	 */
	@Before
	public void init() {
		movingDoubleImpl = new MovingDoubleImpl(2);
	}
	
	//testing addElement functionality
	@Test
	public void getElementsTest() {
		movingDoubleImpl.addElement(1d);
		movingDoubleImpl.addElement(2d);
		movingDoubleImpl.addElement(3d);
		double[] nums = {1d, 2d, 3d};
		List<Double> list = movingDoubleImpl.getElements();
		
		for(int i = 0; i < list.size(); i++) {
			assertEquals(nums[i], list.get(i), 0);
		}
	}
	
	
	//testing getAverage functionality when the number of elements greater or equal than N
	@Test
	public void getAverageTest() {
		movingDoubleImpl.addElement(1d);
		movingDoubleImpl.addElement(3d);
		movingDoubleImpl.addElement(2d);
		movingDoubleImpl.addElement(4d);
		
		assertEquals(3d, movingDoubleImpl.getAverage(), 0);
	}
	
	//testing getAverage functionality when the number of elements less than N 
	@Test
	public void getAverageTestLessThanN() {
		movingDoubleImpl.addElement(1d);
		assertEquals(0d, movingDoubleImpl.getAverage(), 0);
	}
}
