package com.hp.amss.util;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		double dd = 1;
//		get(dd);
//		System.out.println("dd=" + dd);
		
		System.out.println(hashCode(4,1505998205,1505998205));
		System.out.println(hashCode(6,1505998205,1505998205));
		System.out.println(hashCode(2,1505998205,1505998205));
		System.out.println(hashCode(5,1505998205,1505998205));
	}

//	private static void get(double d) {
//		d = 2;
//	}
	//-2147483648~2147483647
	public static int hashCode(int clientId, int host, int remoteAddress) {
		final int prime = 33;
		int result = 1;
		result = prime * result + clientId*2;
//		if (host != null) {
			result = result + host;
//		}
//		if (remoteAddress != null) {
			result = result + remoteAddress;
//		}
		return result;
	}
}
