package info.sjd.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import info.sjd.MyIOException;
import info.sjd.util.ConnectionInfo;
import info.sjd.service.ReadLogsForPeriod;

public class ReadLogsForPeriodTest {

	@Test
	public void testReadLogsForPeriod() throws MyIOException {
		List<ConnectionInfo> readLogsForPeriod = ReadLogsForPeriod.readLogsForPeriod(2000);
		assertNotNull(readLogsForPeriod);
		
		long time = 200*60000L;
		assertTrue(!readLogsForPeriod.isEmpty());
		assertTrue(readLogsForPeriod.size() > 0);
		assertTrue(readLogsForPeriod.get(0).getTime() > time);
	}

}
