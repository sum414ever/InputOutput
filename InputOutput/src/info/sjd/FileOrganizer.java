package info.sjd;

import java.io.*;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class FileOrganizer {

	public static Logger loger = Logger.getLogger(FileOrganizer.class.getName());

	static String pathToFile = System.getProperty("user.dir") + System.getProperty("file.separator") + "log"
			+ System.getProperty("file.separator") + "log.txt";

	public static void fileWriter() throws IOException {
		FileWriter fw = null;
		List<String> list = ServerConnect.connectionInfo();
		for (String s : list) {

			fw = new FileWriter(pathToFile, true);
			fw.write(s);
			fw.flush();
		}
		fw.close();

	}

	static FileReader fr = null;

	public static void fileReader() throws IOException {
		fr = new FileReader(pathToFile);

	}

	static String logs = "";

	public static void readLogsForPeriod(long time) throws IOException {
		Scanner sc = new Scanner(fr);
		Calendar cal = Calendar.getInstance();

		long minTimeInPeriod = cal.getTimeInMillis() - time * 60000L;

		while (sc.hasNextLine()) {
			String log = sc.nextLine();

			if (Long.valueOf(log.substring(0, 13)) > minTimeInPeriod) {
				logs += log + "\n";
			}
		}
		fr.close();
		loger.info(logs);
		logs = "";
	}

	static String oldLogs = "";

	public static void deleteOldLogs() throws IOException {

		Scanner sc = new Scanner(fr);
		Calendar cal = Calendar.getInstance();
		long minTimeInPeriod = cal.getTimeInMillis() - 10800000L;
		while (sc.hasNextLine()) {
			String log = sc.nextLine();
			if (Long.valueOf(log.substring(0, 13)) > minTimeInPeriod) {
				oldLogs += log + "\n";
				FileWriter fw = new FileWriter(pathToFile);
				fw.write(oldLogs);
				fw.flush();
				fw.close();
			}

		}

	}
}
