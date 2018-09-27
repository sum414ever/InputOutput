package info.sjd;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class FileOrganizerTest {

	@Test
	public void testFileWriterAndReader() throws IOException {

		String pathToFile = System.getProperty("user.dir") + System.getProperty("file.separator") + "log"
				+ System.getProperty("file.separator") + "log.txt";

		FileReader testFR = new FileReader(pathToFile);
		assertNotNull(testFR);
		
		Scanner sc = new Scanner(testFR);
		assertNotNull(sc);
		
		String textFromFile = "";
		while (sc.hasNextLine()) {
			textFromFile += sc.nextLine() + "\n";
		}
		System.out.println(textFromFile);
		assertTrue(textFromFile.contains("1536935295411 508889180 179.50.83.159"));
		testFR.close();
		sc.close();

	}

}
