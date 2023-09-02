package com.learning;

import org.testng.annotations.Test;

public class Day3 {
	@Test
	public void test7() {
		System.out.println("Test 7");
	}

	@Test
	public void test8() {
		System.out.println("Test 8");
	}
	@Test(groups = {"smoke"})
	public void test9() {
		System.out.println("Test 9");
	}

	@Test
	public void test10() {
		System.out.println("Test 10");
	}

}
