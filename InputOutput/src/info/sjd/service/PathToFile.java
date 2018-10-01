package info.sjd.service;

public class PathToFile {
	
	public static String pathToFile() {
		return System.getProperty("user.dir") + System.getProperty("file.separator") + "log"
				+ System.getProperty("file.separator") + "log.txt";
	}
}
