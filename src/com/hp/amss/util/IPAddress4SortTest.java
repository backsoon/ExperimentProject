package com.hp.amss.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class IPAddress4SortTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// System.out.println(Arrays.toString(IP.class.getDeclaredFields()));
		IPAddress4Sort ip5 = new IPAddress4Sort("10.10.140.0", "32");
		IPAddress4Sort ip6 = new IPAddress4Sort("10.10.34.0", "26");
		IPAddress4Sort ip7 = new IPAddress4Sort("10.10.34.0", "8");
		// System.out.println(ip5.getIP().compareTo(ip6.getIP()));
		IPAddress4Sort ip4 = new IPAddress4Sort("10.10.35.0", "26");
		IPAddress4Sort ip1 = new IPAddress4Sort("255.255.255.255", "24");
		IPAddress4Sort ip2 = new IPAddress4Sort("10.10.36.0", "8");
		IPAddress4Sort ip3 = new IPAddress4Sort("10.4.120.100", "32");
		List<IPAddress4Sort> list = new ArrayList<IPAddress4Sort>();
		list.add(ip1);
		list.add(ip2);
		list.add(ip3);
		list.add(ip4);
		list.add(ip5);
		list.add(ip6);
		list.add(ip7);
		// System.out.println("before:"+list);
		Collections.sort(list, IPAddress4Sort.IPComparator);
		Vector vec = new Vector();
//		List list1 = vec.subList(arg0, arg1);
		
		System.out.println("after(IP):" + list);

	}
}
