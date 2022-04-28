package day2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeLesson {
	public static void main(String[] args) throws ParseException {
		long start = System.currentTimeMillis();
		String str = "Java";
		for(int i=0;i<10000;i++) {
			str += "Java";
		}
		long end = System.currentTimeMillis();
		System.out.println("time1:"+(end-start));
		start = System.currentTimeMillis();

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<100000;i++) {
			sb.append("Java");
		}
		end = System.currentTimeMillis();
		System.out.println("time2:"+(end-start));

		//Date
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.getTime());

		//Calendar
		Calendar c = Calendar.getInstance();
		c.set(2019, 8,22,1,23,45);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		Date d = c.getTime();
		System.out.println(d);
		c.setTime(now);
		int y = c.get(Calendar.YEAR);
		System.out.println("今年は" + y + "年です");

		//DateとCalendarの相互互換
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		f = new SimpleDateFormat("yyyy年MM月dd日(E)");
//		Date d2 = f.parse("2020/09/22 01:23:45");
		String s = f.format(now);
		System.out.println(s);
	}
}
