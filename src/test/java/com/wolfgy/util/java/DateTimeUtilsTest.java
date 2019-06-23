package com.wolfgy.util.java;

import org.junit.Test;

public class DateTimeUtilsTest {

	@Test
	public void test() {
		long days = DateTimeUtils.getWorkingDays("2019-06-01", "2019-06-23");
		System.out.println("Working days:"+days);
	}
}
