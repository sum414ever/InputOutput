package info.sjd.service;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import info.sjd.MyIOException;
import info.sjd.util.ConnectionInfo;

public class ReadTextFromFile {
	
	
	
	public static List<ConnectionInfo> fileReader() throws MyIOException {
		FileReader fr = null;
		BufferedReader br = null;
		List<ConnectionInfo> connectionInfo = new ArrayList<>();
		String line = "";
		try {
			fr = new FileReader(PathToFile.pathToFile());
			br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				String[] words = line.split(" ");
				ConnectionInfo conInfo = new ConnectionInfo(Long.valueOf(words[0]),words[1],words[2]);

				connectionInfo.add(conInfo);
				
			}
		} catch ( IOException e) {
			throw new MyIOException("File not found");
		}
		try {
			fr.close();
			br.close();
		} catch (IOException ex) {
			throw new MyIOException("Input Exception");
		}
		return connectionInfo;

	}

}
