package com.hp.amss.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 日付ユーティリティクラス
 *
 * @author 定岡 博道
 * 作成日: 2008/03/17
 */
public final class DateUtil {

    /**
	 * インスタンスの生成を抑制
	 */
    private DateUtil() { };

    /**
	 * <P>日付区切り用</P>
	 */
	public static final String DELIMITER = "/";
	/**
	 * <P>時間区切り用</P>
	 */
	public static final String DELIM_COLON = ":";
	/**
	 * <P>時間区切り用</P>
	 */
	public static final String DELIM_DOT   = ".";

	/**
	 * <P>種別：年</P>
	 */
	public static final int TYPE_YYYY = 1;
	/**
	 * <P>種別：月</P>
	 */
	public static final int TYPE_MM   = 2;
	/**
	 * <P>種別：日</P>
	 */
	public static final int TYPE_DD	  = 3;


	/**
	* <p> [機 能]日付変換</p>
	* <p> [説 明]文字列の日付をDateオブジェクトとして取得する。</p>
	* <p> [備 考]例外発生時はnullを返却する。</p>
	* @param date 日付文字列
	* @return Date Dateオブジェクト
	* @exception Exception
	*/
	public static Date toDate(String date) {
		/*日付(年月日)フォーマット*/
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		try {
			java.util.Date d =
				(java.util.Date) dateFormat.parseObject(date);
			return new Date(d.getTime());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	* <p> [機 能]日付変換</p>
	* <p> [説 明]文字列の日付をDateオブジェクトとして取得する。</p>
	* <p> [備 考]例外発生時はnullを返却する。</p>
	* @param date 日付文字列
	* @param dateFormat 日付フォーマット
	* @return Date Dateオブジェクト
	*/
	public static Date toDate(String date, SimpleDateFormat dateFormat) {
		try {
			java.util.Date d =
				(java.util.Date) dateFormat.parseObject(date);
			return new Date(d.getTime());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	* <p> [機 能]フォーマット</p>
	* <p> [説 明]Dateを文字列にフォーマットする。</p>
	* <p> [備 考]例外発生時は空文字列を返却する。</p>
	* <p>　　　　yyyy形式にフォーマットする。</p>
	* @param date 日付文字列
	* @return String フォーマットされた文字列
	* @exception Exception
	*/
	public static String toDateStringYear(Date date) {
		/*日付(年)フォーマット*/
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		return toDateString(date, yearFormat);
	}

	/**
	* <p> [機 能]フォーマット</p>
	* <p> [説 明]Dateを文字列にフォーマットする。</p>
	* <p> [備 考]例外発生時は空文字列を返却する。</p>
	* <p>　　　　MM形式にフォーマットする。</p>
	* @param date 日付文字列
	* @return String フォーマットされた文字列
	* @exception Exception
	*/
	public static String toDateStringMonth(Date date) {
		/*日付(月)フォーマット*/
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		return toDateString(date, monthFormat);
	}

	/**
	* <p> [機 能]フォーマット</p>
	* <p> [説 明]Dateを文字列にフォーマットする。</p>
	* <p> [備 考]曜日にフォーマットする。</p>
	* @param date 日付文字列
	* @return String フォーマットされた文字列
	* @exception 例外なし
	*/
	public static String toDateStringWeek(Date date) {
		/*曜日フォーマット*/
		SimpleDateFormat weekFormat = new SimpleDateFormat("E");
		return toDateString(date, weekFormat);
	}

	/**
	* <p> [機 能]フォーマット</p>
	* <p> [説 明]Dateを文字列にフォーマットする。</p>
	* <p> [備 考]yyyyMMdd形式にフォーマットする</p>
	* @param date 日付文字列
	* @return String フォーマットされた文字列
	* @exception 例外なし
	*/
	public static String toDateStringDate(Date date) {
		/*日付(年月日)フォーマット*/
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return toDateString(date, dateFormat);
	}

	/**
	* <p> [機 能]フォーマット</p>
	* <p> [説 明]Dateを文字列にフォーマットする。</p>
	* <p> [備 考]HHmm形式にフォーマットする</p>
	 * @param date 日付文字列
	 * @return String フォーマットされた文字列
	 */
	public static String toDateStringTime(Date date) {
		/*日付(時分)フォーマット*/
		SimpleDateFormat dateFormat = new SimpleDateFormat("HHmm");
		return toDateString(date, dateFormat);
	}

	/**
	* <p> [機 能]フォーマット</p>
	* <p> [説 明]Dateを文字列にフォーマットする。</p>
	* <p> [備 考]yyyyMMddHHmmss形式にフォーマットする</p>
	 * @param date 日付文字列
	 * @return String フォーマットされた文字列
	 */
	public static String toDateString(Date date) {
		/*日付(年月日時分秒)フォーマット*/
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return toDateString(date, dateFormat);
	}

	/**
	* <p> [機 能]フォーマット</p>
	* <p> [説 明]Dateを文字列にフォーマットする。</p>
	* <p> [備 考]dd形式にフォーマットする。</p>
	* @param date 日付文字列
	* @return String フォーマットされた文字列
	* @exception 例外なし
	*/
	private static String toDateString(Date date, SimpleDateFormat format) {
		try {
			return format.format(date);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * <p> [機 能]フォーマット</p>
	 * <p> [説 明]Dateを文字列にフォーマットする。</p>
	 * <p> [備 考]dd形式にフォーマットする。</p>
	 * @param date 日付文字列
	 * @return String フォーマットされた文字列
	 * @exception 例外なし
	 */
	public static String toDateString(String date, SimpleDateFormat format) {
		try {
			return format.format(toDate(date));
		} catch (Exception e) {
			return "";
		}
	}

	/**
	* <p> [機 能]日付取得</p>
	* <p> [説 明]現在日付を取得する。</p>
	* <p> [備 考]なし</p>
	* @return Date 現在日付が設定されたDateオブジェクト
	* @exception 例外なし
	*/
	public static Date getNowDate() {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return new Date(calendar.getTime().getTime());
	}

	/**
	* <p> [機 能]日時取得</p>
	* <p> [説 明]現在日時を取得する。</p>
	* <p> [備 考]なし</p>
	* @return Date 現在日時が設定されたDateオブジェクト
	* @exception 例外なし
	*/
	public static Date getNowDateTime() {
		Calendar calendar = new GregorianCalendar();
		return new Date(calendar.getTime().getTime());
	}

	/**
	* <p> [機 能]日付演算</p>
	* <p> [説 明]指定日付に指定日数を演算した日付を返却する。</p>
	* <p> [備 考]なし</p>
	* @param date Dateオブジェクト
	* @param v    指定日数
	* @return Date 演算されたDateオブジェクト
	* @exception 例外なし
	*/
	public static Date computeDay(Date date, int v) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, v);
		return new Date(calendar.getTime().getTime());
	}

	/**
	* <p> [機 能]日付分割</p>
	* <p> [説 明]日付を分割する。</p>
	* <p> [備 考]String[0]　年(yyyy)
	*　　　　　　String[1]　月(mm)
	*　　　　　　String[2]　日(dd)</p>
	* @param date 日付文字列
	* @return String[] 年月日が格納された配列
	* @exception 例外なし
	*/
	public static String[] splitDateString(String date) {
		String yyyy = null;
		String mm = null;
		String dd = null;
	    final int fmt4 = 4;
		final int fmt6 = 6;
		final int fmt8 = 8;

		if (date != null) {

			final int dateLength = date.length();
			if (dateLength < fmt4) {
				yyyy = "";
				mm = "";
				dd = "";
			} else {
				if (dateLength >= fmt4) {
					yyyy = date.substring(0, fmt4);
				}
				if (dateLength >= fmt6) {
					mm = date.substring(fmt4, fmt6);
				}
				if (dateLength >= fmt8) {
					dd = date.substring(fmt6, fmt8);
				}
			}
		}
		String[] result = {yyyy, mm, dd};
		return result;
	}

	/**
	* <p> [機 能]日付分割</p>
	* <p> [説 明]日付を分割する。</p>
	* <p> [備 考]String[0]　年(yyyy)
	*　　　　　　String[1]　月(mm)
	*　　　　　　String[2]　日(dd)
	*　　　　　　String[3]　時(hh)
	*　　　　　　String[4]　分(mm)
	*　　　　　　String[5]　秒(ss)</p>
	* @param date 日付文字列
	* @return String[] 年月日が格納された配列
	* @exception 例外なし
	*/
	public static String[] splitDateString2(String date) {
		String yyyy = null;
		String MM = null;
		String dd = null;
		String hh = null;
		String mm = null;
		String ss = null;
	    final int fmt4 = 4;
		final int fmt6 = 6;
		final int fmt8 = 8;
		final int fmt10 = 10;
		final int fmt12 = 12;
		final int fmt14 = 14;

		if (date != null) {

			final int dateLength = date.length();
			if (dateLength < fmt4) {
				yyyy = "";
				MM = "";
				dd = "";
				hh = "";
				mm = "";
				ss = "";
			} else {
				if (dateLength >= fmt4) {
					yyyy = date.substring(0, fmt4);
				}
				if (dateLength >= fmt6) {
					MM = date.substring(fmt4, fmt6);
				}
				if (dateLength >= fmt8) {
					dd = date.substring(fmt6, fmt8);
				}
				if (dateLength >= fmt10) {
					hh = date.substring(fmt8, fmt10);
				}
				if (dateLength >= fmt12) {
					mm = date.substring(fmt10, fmt12);
				}
				if (dateLength >= fmt14) {
					ss = date.substring(fmt12, fmt14);
				}
			}
		}
		String[] result = {yyyy, MM, dd, hh, mm, ss};
		return result;
	}

	/**
	 * <p> [機 能]日付演算</p>
	 * <p> [説 明]指定日付の曜日を取得する。</p>
	 * <p> [備 考]日付の曜日を設定：<br>
	 *           ・"1" ： 日<br>
	 *           ・"2" ： 月<br>
	 *           ・"3" ： 火<br>
	 *           ・"4" ： 水<br>
	 *           ・"5" ： 木<br>
	 *           ・"6" ： 金<br>
	 *           ・"7" ： 土</p>
	 * @param date 日付文字列
	 * @param format 日付フォーマット
	 * @return 曜日
	 */
	public static String computeWeek(String date, SimpleDateFormat format) {
		try {
			return computeWeek(format.parse(date));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * <p> [機 能]日付演算</p>
	 * <p> [説 明]指定日付の曜日を取得する。</p>
	 * <p> [備 考]日付の曜日を設定：<br>
	 *           ・"1" ： 日<br>
	 *           ・"2" ： 月<br>
	 *           ・"3" ： 火<br>
	 *           ・"4" ： 水<br>
	 *           ・"5" ： 木<br>
	 *           ・"6" ： 金<br>
	 *           ・"7" ： 土</p>
	 * @param date 日付
	 * @return 曜日
	 */
	public static String computeWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return String.valueOf(c.get(Calendar.DAY_OF_WEEK));
	}

	/**
	 * <p> [機 能]日付演算</p>
	 * <p> [説 明]日付シーケンスを取得する。</p>
	 * <p> [備 考]なし</p>
	 * @param startDate 開始日付
	 * @param endDate 終了日付
	 * @param dateFormat 日付フォーマット
	 * @return 日付シーケンス
	 */
	public static List getDateSequence(String startDate, String endDate, SimpleDateFormat dateFormat) {

		List seqList = new ArrayList();
		seqList.add(startDate);

		if (startDate.equals(endDate)) {
			return seqList;
		}

		Calendar c = Calendar.getInstance();
		c.setTime(toDate(startDate, dateFormat));

		String tmp = null;
		while (true) {
			c.add(Calendar.DAY_OF_MONTH, 1);
			tmp = toDateString(c.getTime(), dateFormat);
			seqList.add(tmp);

			if (endDate.equals(tmp)) {
				break;
			}
		}

		return seqList;
	}

	/**
	 * <p> [機 能]有効性検証</p>
	 * <p> [説 明]日付の有効性を検証する。</p>
	 * <p> [備 考]yyyy-MM-dd型の有効日付</p>
	 * @param date 日付文字列
	 * @return true：有効 false：無効
	 */
	public static boolean isValidDate(String date) {

		if (date == null
				|| !date.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
			return false;
		}

		StringTokenizer token = new StringTokenizer(date, "-");
		int year  = Integer.parseInt(token.nextToken());
		int month = Integer.parseInt(token.nextToken());
		int day   = Integer.parseInt(token.nextToken());

		month = month - 1;
		GregorianCalendar gc = new GregorianCalendar(year, month, day);
		return (gc.get(Calendar.YEAR) == year)
				&& (gc.get(Calendar.MONTH) == month)
				&& (gc.get(Calendar.DAY_OF_MONTH) == day);
	}

}
