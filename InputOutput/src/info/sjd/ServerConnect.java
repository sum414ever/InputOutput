package info.sjd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ServerConnect {

	public static List<String> connectionInfo() {
		List <String> connectionInfo = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			connectionInfo.add(timeInMillisecond() + " " + sessionId() + " " + ip() + "\n");
		}
		return connectionInfo;
	}

	private static String randomGenerator(int a, int b) {
		int c = (int) (a + Math.random() * (b - a));
		return Integer.toString(c);
	}

	public static String ip() {
		return randomGenerator(0, 255) + "." + randomGenerator(0, 255) + "." + randomGenerator(0, 255) + "."
				+ randomGenerator(0, 255);
	}

	private static String sessionId() {
		return randomGenerator(100000000, 999999999);
	}

	private static String timeInMillisecond() {
		Calendar cal = Calendar.getInstance();
		return Long.toString(cal.getTimeInMillis());
	}

}
