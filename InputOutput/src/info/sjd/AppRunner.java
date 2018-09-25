package info.sjd;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppRunner {

	public static Logger log = Logger.getLogger(AppRunner.class.getName());

	public static void main(String[] args) {

		try {
			FileOrganizer.fileWriter();
		} catch (IOException e) {
			log.log(Level.SEVERE, "Exception; ", e.getCause());
		}

		try {
			FileOrganizer.fileReader();
		} catch (IOException e1) {
			log.log(Level.SEVERE, "Exception; ", e1.getCause());
		}

		// argument in method - time in minutes;
		try {
			FileOrganizer.readLogsForPeriod(5);
		} catch (IOException e2) {
			log.log(Level.SEVERE, "Exception; ", e2.getCause());
		}

		try {
			FileOrganizer.deleteOldLogs();
		} catch (IOException e3) {
			log.log(Level.SEVERE, "Exception; ", e3.getCause());
		}

	}

}
