package com.learning;

import org.testng.annotations.Test;

public class Day2 {

	@Test
	public void test5() {
		System.out.println("Test 5");
	}

	@Test(groups = {"smoke"})
	public void test6() {
		System.out.println("Test 6");
	}
}
