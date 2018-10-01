package info.sjd.util;

public class ConnectionInfo {
	private long time;
	private String sessionId;
	private String ip;

	public ConnectionInfo(Long time, String sessionId, String ip) {
		this.time = time;
		this.sessionId = sessionId;
		this.ip = ip;
	}
	
	public ConnectionInfo() {
	
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String connectionInfo() {
		return Long.toString(time) + " " + sessionId + " " + ip;
	}

}
