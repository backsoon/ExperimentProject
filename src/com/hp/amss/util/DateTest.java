package com.hp.amss.util;

import java.text.SimpleDateFormat;

public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.parse("12-0025-31"));
		System.out.println(DateUtil.toDate("2012-25-31", new SimpleDateFormat("yyyy-MM-dd")));
		} catch (Exception e) {
			System.out.println("exception");
		}
	}

}
