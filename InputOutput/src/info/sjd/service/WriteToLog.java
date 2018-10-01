package info.sjd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.io.*;

import info.sjd.AppRunner;
import info.sjd.MyIOException;
import info.sjd.util.ConnectionInfo;
import info.sjd.util.RandomGenerate;

public class WriteToLog {
	public static Logger log = Logger.getLogger(AppRunner.class.getName());


	public static void fileWriter(int ammountOfConnection, boolean append) throws MyIOException {
		FileWriter fw = null;

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < ammountOfConnection; i++) {
			ConnectionInfo connectionInfo = new ConnectionInfo(RandomGenerate.timeInMillisecond(),
					RandomGenerate.sessionId(), RandomGenerate.ip());
			list.add(connectionInfo.connectionInfo());
			try {
				fw = new FileWriter(PathToFile.pathToFile(), append) ;
				fw.write(list.get(i) + "\n");
				fw.flush();
			} catch (IOException e) {
				throw new MyIOException("Output Exception");
			}
			
			try {
				fw.close();
			} catch (IOException e) {
				throw new MyIOException("Output Exception");
			}
		}
		log.info("You wrote " + ammountOfConnection + " new logs" );

	}

}
