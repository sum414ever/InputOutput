package info.sjd.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import info.sjd.MyIOException;
import info.sjd.util.ConnectionInfo;

public class ReadTextFromFileTest {

	@Test

	public void testFileReader() throws MyIOException {
		List<ConnectionInfo> connectionInfo = ReadTextFromFile.fileReader();

		assertNotNull(connectionInfo);
		assertTrue(!connectionInfo.isEmpty());
		assertTrue(connectionInfo.size() > 0);
		assertEquals(connectionInfo.get(0).getIp(), "41.193.83.50");
		assertEquals(connectionInfo.get(0).getSessionId(), "835433665");
		assertEquals(connectionInfo.get(0).getTime(), 1538242428799L);

	}

}
