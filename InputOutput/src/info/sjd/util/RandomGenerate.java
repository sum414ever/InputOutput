package info.sjd.util;

import java.util.Calendar;

public class RandomGenerate {


	private static String randomGenerator(int a, int b) {
		int c = (int) (a + Math.random() * (b - a));
		return Integer.toString(c);
	}

	public static String ip() {
		return randomGenerator(0, 255) + "." + randomGenerator(0, 255) + "." + randomGenerator(0, 255) + "."
				+ randomGenerator(0, 255);
	}

	public static String sessionId() {
		return randomGenerator(100000000, 999999999);
	}

	public static Long timeInMillisecond() {
		Calendar cal = Calendar.getInstance();
		return cal.getTimeInMillis();
	}
}
