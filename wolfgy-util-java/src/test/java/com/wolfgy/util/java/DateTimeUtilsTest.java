package com.wolfgy.util.java;

import org.junit.Test;

public class DateTimeUtilsTest {

	@Test
	public void test() {
		long days = DateTimeUtils.getWorkingDays("2018-11-15", "2018-12-17");
		System.out.println("Working days:"+days);
	}
}
