package day2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarLesson {
	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat f = new SimpleDateFormat("西暦 yyyy年MM月dd日(E)");
		String result = f.format(now);
		System.out.println(result);
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		int date = c.get(Calendar.DATE);
		c.set(Calendar.DATE,date+100);
		Date d = c.getTime();
		result = f.format(d);
		System.out.println(result);
	}
}
