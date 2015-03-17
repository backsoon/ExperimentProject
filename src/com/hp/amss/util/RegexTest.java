package com.hp.amss.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class RegexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
//	        Pattern pattern = Pattern.compile("\\(\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}\\)");
//	        Matcher isDate = pattern.matcher("(2013/05/14 15:18:18)");
//	        System.out.println(isDate.matches());
			
//			String REG_END_REPORT_TAG = "<homework_create\\s*label\\s*=\\s*\"*([^\"&&[^/]]+)\"*\\s*/*>";
//			Pattern pattern = Pattern.compile(REG_END_REPORT_TAG);
//			Matcher matcher = pattern.matcher("<homework_create label=\"作業完了報告書作成\"/>");
//			System.out.println(matcher.matches());
//			System.out.println(matcher.group(1));
			
//			String p = "^ベストエフォート\\S+両系$";
//			Pattern pattern = Pattern.compile(p);
//			Matcher matcher = pattern.matcher("ベストエフォート（closed）両系");
//			System.out.println(matcher.matches());

//			String REG_END_REPORT_TAG = "^ワイヤレス回線の電波状態は、\\[(\\d+)\\s*\\(.*\\]です。";
//			Pattern pattern = Pattern.compile(REG_END_REPORT_TAG);
//			Matcher matcher = pattern.matcher("ワイヤレス回線の電波状態は、[33 (strength : 19)]です。");
//			System.out.println(matcher.matches());
//			System.out.println(matcher.groupCount());
//			System.out.println(matcher.group(0));
//			System.out.println(matcher.group(1));
			
//	        Pattern pattern = Pattern.compile("^\\[ *(\\d+)\\]回目 パケットロス \\[ *(\\d+)\\]％$");
//	        Matcher m = pattern.matcher("[55]回目 パケットロス [ 33]％");
//	        m.matches();
////	        System.out.println(m.matches());
////	        System.out.println(m.group());
////	        System.out.println(m.groupCount());
//	        System.out.println(m.group(0));
//	        System.out.println(m.group(1));
//	        System.out.println(m.group(2));
			
	        
//	        Pattern pattern = Pattern.compile("^\\[ ?\\d+\\]回目 パケットロス \\[ ? ?[0-100]\\]％ \\[[a-zA-Z]+\\]$"); //パケットロス [\\d[0-100]]％ [OK|NG]
//	        Matcher isDate = pattern.matcher("[ 5]回目 パケットロス [  3]％ [NG]"); //[ 1]回目 パケットロス [  0]％ [OK]
//	        System.out.println(isDate.matches());
			
//			String BackupWirelessPattern = ".+-ワイヤレス$";
//			Pattern pattern = Pattern.compile(BackupWirelessPattern);
//			Matcher matcher = pattern.matcher("adfd dfdf fdfdf-ワイヤレス");
//			System.out.println(matcher.matches());
//			System.out.println(matcher.groupCount());
//			System.out.println(matcher.group(0));
			
			
			String REG_END_REPORT_TAG = "^ワイヤレス回線の電波状態は、\\[(\\d+)\\s*\\[(\\|*\\s*)\\].*です。";
			Pattern pattern = Pattern.compile(REG_END_REPORT_TAG);
//			Matcher matcher = pattern.matcher("ワイヤレス回線の電波状態は、[3 [|||] (usb1)]です。");
			Matcher matcher = pattern.matcher("ワイヤレス回線の電波状態は、[2 [|| ] (usb1)]です。");
//			Matcher matcher = pattern.matcher("ワイヤレス回線の電波状態は、[1 [|  ] (usb1)]です。");
//			Matcher matcher = pattern.matcher("ワイヤレス回線の電波状態は、[0 [   ] (usb1)]です。");
			System.out.println(matcher.matches());
			System.out.println(matcher.groupCount());
			System.out.println(matcher.group(0));
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			String signalLevel_temp = matcher.group(2);
			signalLevel_temp = StringUtils.trim(signalLevel_temp);
			System.out.println(String.valueOf(signalLevel_temp.length()));
			
//			String REG_END_REPORT_TAG = "^ワイヤレス回線の電波状態は、\\[(\\|* *)]です。";
//			Pattern pattern = Pattern.compile(REG_END_REPORT_TAG);
//			Matcher matcher = pattern.matcher("ワイヤレス回線の電波状態は、[| ]です。");
//			System.out.println(matcher.matches());
//			System.out.println(matcher.groupCount());
//			System.out.println(matcher.group(0));
//			System.out.println(matcher.group(1));
//			String signalLevel_temp = matcher.group(1);
//			signalLevel_temp = StringUtils.trim(signalLevel_temp);
//			System.out.println(String.valueOf(signalLevel_temp.length()));

		} catch (Exception e) {
			System.out.print(e);
		}
	}
}
