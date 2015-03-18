package com.hp.amss.util;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("あいうえお1".length());
			System.out.println("あ1いうえお".substring(0, 15));
			
			//System.out.println(number2Letter(53));
			//String ss = "012345&DESCRIPTION=";
			//String nextUrl1 = ss.substring(0, ss.indexOf("&DESCRIPTION="));
            //String nextUrl2 = ss.substring(ss.indexOf("&DESCRIPTION="));

//			System.out.println(nextUrl1);
//			System.out.println(nextUrl2);
//			System.out.println(System.getProperty("java.io.tmpdir"));
			
			
//			Long ltest = new Long(9999);
//			System.out.println(ltest.toString());
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
    private static String number2Letter(int x) {
        if (x < 27) {
            return String.valueOf((char) ('A' + x - 1));
        } else if (x % 26 == 0) {
            return number2Letter(x / 26 - 1) + "Z";
        } else {
            return number2Letter(x / 26)
                    + String.valueOf((char) ('A' + x % 26 - 1));
        }
    }

}
