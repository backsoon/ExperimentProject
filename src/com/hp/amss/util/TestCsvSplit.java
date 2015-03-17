package com.hp.amss.util;

import org.apache.commons.lang.StringUtils;


public class TestCsvSplit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String configCreateStatus = null;
		//String[] configCreateStatusArray1 = configCreateStatus.split(",");
		String[] configCreateStatusArray2 = StringUtils.splitPreserveAllTokens(configCreateStatus, ",");
		
//		System.out.println(configCreateStatusArray1.length);
//		for (int i = 0; i < configCreateStatusArray1.length; i++) {
//			System.out.println(configCreateStatusArray1[i]);
//		}
		System.out.println("===================================");
		System.out.println(configCreateStatusArray2.length);
		for (int i = 0; i < configCreateStatusArray2.length; i++) {
			System.out.println(configCreateStatusArray2[i]);
		}
		System.out.println("===================================");
		
	}

}
