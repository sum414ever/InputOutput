package info.sjd.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import info.sjd.MyIOException;
import info.sjd.util.ConnectionInfo;

public class ReadLogsForPeriod {

	public static List<ConnectionInfo> readLogsForPeriod(long time) throws MyIOException {
		Calendar cal = Calendar.getInstance();
		List<ConnectionInfo> readLogsForPeriod = new ArrayList<>();

		List<ConnectionInfo> list;
		try {
			list = ReadTextFromFile.fileReader();
		} catch (MyIOException e) {
			throw new MyIOException("File not found");
		}
		for (ConnectionInfo s : list) {
			if (s.getTime() > (cal.getTimeInMillis() - time * 60000L)) {
				readLogsForPeriod.add(s);
			}
		}
		
		return readLogsForPeriod;
	}

}