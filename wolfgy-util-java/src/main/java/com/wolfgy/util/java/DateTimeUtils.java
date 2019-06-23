package com.wolfgy.util.java;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 
 * <p>
 * Description:日期时间工具类<br />
 * </p>
 * @title DateTimeUtils.java
 * @package com.wolfgy.util.java 
 * @author wolfgy
 * @version 0.1 2019年6月23日
 */
public class DateTimeUtils {
	
	/**
	 * 
	 * <p>
	 * Description:计算指定日期之间工作日数量。（只计算周一至周五。不计算法定节假日）<br />
	 * </p>
	 * @author wolfgy
	 * @version 0.1 2019年6月23日
	 * @param dateGOE 起始日期（包含）。example:2019-06-04
	 * @param dateLT 结束日期（不包含）。example:2019-06-04
	 * @return
	 * long
	 */
	public static long getWorkingDays(String dateGOE,String dateLT) {
		LocalDate start = LocalDate.parse(dateGOE);
		LocalDate end = LocalDate.parse(dateLT);
		if (end.isBefore(start) || end.isEqual(start)) {
			throw new IllegalArgumentException("dateLT must after dateGOE.");
		}
		long count = 0;
		while (start.isBefore(end)) {
			if (!start.getDayOfWeek().equals(DayOfWeek.SATURDAY)&&!start.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
				count++;
			}
			start = start.plusDays(1);
		}
		return count;
		
	}
}
