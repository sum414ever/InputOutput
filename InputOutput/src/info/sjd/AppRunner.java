package info.sjd;

import java.util.List;
import java.util.logging.Logger;

import info.sjd.service.DeleteOldLog;
import info.sjd.service.ReadLogsForPeriod;
import info.sjd.service.WriteToLog;
import info.sjd.util.ConnectionInfo;

public class AppRunner {

	public static Logger log = Logger.getLogger(AppRunner.class.getName());

	public static void main(String[] args) throws MyIOException {

		// First int - how many logs need to be recorded, boolean - true, if you want
		// write down, false - overwrite;
		WriteToLog.fileWriter(10, true);

		// Argument in method - minutes, for how long to display the logs;
		List<ConnectionInfo> readLogsForPeriod = ReadLogsForPeriod.readLogsForPeriod(5);
		for (ConnectionInfo s : readLogsForPeriod) {
			log.info(s.connectionInfo());
		}
		
//		Deleted old logs
		DeleteOldLog.writeOldLog();

	}

}
