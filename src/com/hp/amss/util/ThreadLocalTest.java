package com.hp.amss.util;

public class ThreadLocalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println(SerialNum.get());
			System.out.println(SerialNum.get());
			
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
