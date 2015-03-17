package com.hp.amss.util;

import java.util.Comparator;

public class IPAddress4Sort {

	private String IP;
	private String NetMask;
	
	IPAddress4Sort(String IP) {
		this.IP = IP;
		this.NetMask = "0";
	}
	
	IPAddress4Sort(String IP, String NetMask) {
		this.IP = IP;
		this.NetMask = NetMask;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Comparator<IPAddress4Sort> IPComparator = new Comparator() {
		@Override
		public int compare(Object arg0, Object arg1) {
			IPAddress4Sort IP1 = (IPAddress4Sort) arg0;
			IPAddress4Sort IP2 = (IPAddress4Sort) arg1;
			return compartTo(IP1, IP2);
		}
	};

	private static int compartTo(IPAddress4Sort IP1, IPAddress4Sort IP2) {
		// compare two IP with the number
		int ipCompareResult = compareIP(IP1.IP, IP2.IP);
		if (ipCompareResult == 0) {
			return compareNetmask(IP1.NetMask, IP2.NetMask);
		} else {
			return ipCompareResult;
		}
	}

	private static int compareIP(String ip1, String ip2) {
		// compare two IP with the number
		long[] ip11 = parseIp(ip1);
		long[] ip22 = parseIp(ip2);
		long ip1Result = 0, ip2Result = 0;
		for (int i = 0; i < 4; i++) {
			ip1Result += (ip11[i] << (24 - i * 8));
		}
		for (int i = 0; i < 4; i++) {
			ip2Result += (ip22[i] << (24 - i * 8));
		}
		if (ip1Result - ip2Result > 0) {
			return 1;
		} else if (ip1Result - ip2Result < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	private static int compareNetmask(String netmask1, String netmask2) {
		Long mask1 = new Long(netmask1);
		Long mask2 = new Long(netmask2);
		return mask1.compareTo(mask2);
	}
	
	private static long[] parseIp(String ip) {
		ip = ip.replace(".", "#");
		long result[] = new long[4];
		String[] ip1 = ip.split("#");
		if (ip != null) {
			result[0] = Long.parseLong(ip1[0]);
			result[1] = Long.parseLong(ip1[1]);
			result[2] = Long.parseLong(ip1[2]);
			result[3] = Long.parseLong(ip1[3]);
		}
		return result;
	}

	public String getNetMask() {
		return NetMask;
	}

	public void setNetMask(String name) {
		this.NetMask = name;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}
	

	@Override
	public String toString() {
		return this.IP + "/" + this.NetMask;
	}

//	/**
//	 * サブネットマスクをスラッシュマスク形式で返します
//	 * @return スラッシュマスク形式のサブネットマスク文字列
//	 */
//	public String getSlashmask(String netmask1)
//	{
//		int tmpInSNM=this.inSNM;
//
//		//"1"ビットの数
//		int inBitCount=0;
//
//		//スラッシュマスク形式に変換
//		while((tmpInSNM & 0x80000000)!=0)
//		{
//			tmpInSNM<<=1;
//			inBitCount++;
//		}
//		return "/ "+Integer.toString(inBitCount);
//	}
}
