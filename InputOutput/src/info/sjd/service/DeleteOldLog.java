package info.sjd.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import info.sjd.AppRunner;
import info.sjd.MyIOException;
import info.sjd.util.ConnectionInfo;

public class DeleteOldLog {

	public static Logger log = Logger.getLogger(AppRunner.class.getName());
	static List<ConnectionInfo> oldLogs = new ArrayList<>();

	public void deleteOldLog() throws MyIOException {
		Calendar cal = Calendar.getInstance();

		List<ConnectionInfo> list = ReadTextFromFile.fileReader();

		try {
			list = ReadTextFromFile.fileReader();
		} catch (MyIOException e) {
			throw new MyIOException("File not found");
		}
		for (ConnectionInfo s : list) {
			if (s.getTime() > (cal.getTimeInMillis() - 10800000L)) {
				oldLogs.add(s);
			}

		}
	}

	public static void writeOldLog() throws MyIOException {
		FileWriter fw = null;
		for (ConnectionInfo connectionInfo : oldLogs) {
			try {
				fw = new FileWriter(PathToFile.pathToFile());
				fw.write(connectionInfo + "\n");
				fw.flush();
			} catch (IOException e) {
				throw new MyIOException("File not found");
			}

			try {
				fw.close();
			} catch (IOException e) {
				throw new MyIOException("File not found");
			}
		}
		log.info("Old logs deleted");
	}
}
