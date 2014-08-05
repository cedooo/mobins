package cn.com.dhcc.cgn.mobins.po;

public class MobDestHost {
	private String mobDestHostID = null;
	private String targetID = null;
	private String mobDestHostIP = null;
	private String hostUser = null;
	private String hostPasswd = null;
	private String hostNote = null;
	private String hostType = null;
	private String hostAddTime = null;
	private String hostDelTime = null;

	public String getMobDestHostID() {
		return mobDestHostID;
	}

	public void setMobDestHostID(String mobDestHostID) {
		this.mobDestHostID = mobDestHostID;
	}

	public String getTargetID() {
		return targetID;
	}

	public void setTargetID(String targetID) {
		this.targetID = targetID;
	}

	public String getMobDestHostIP() {
		return mobDestHostIP;
	}

	public void setMobDestHostIP(String mobDestHostIP) {
		this.mobDestHostIP = mobDestHostIP;
	}

	public String getHostUser() {
		return hostUser;
	}

	public void setHostUser(String hostUser) {
		this.hostUser = hostUser;
	}

	public String getHostPasswd() {
		return hostPasswd;
	}

	public void setHostPasswd(String hostPasswd) {
		this.hostPasswd = hostPasswd;
	}

	public String getHostNote() {
		return hostNote;
	}

	public void setHostNote(String hostNote) {
		this.hostNote = hostNote;
	}

	public String getHostType() {
		return hostType;
	}

	public void setHostType(String hostType) {
		this.hostType = hostType;
	}

	public String getHostAddTime() {
		return hostAddTime;
	}

	public void setHostAddTime(String hostAddTime) {
		this.hostAddTime = hostAddTime;
	}

	public String getHostDelTime() {
		return hostDelTime;
	}

	public void setHostDelTime(String hostDelTime) {
		this.hostDelTime = hostDelTime;
	}

	@Override
	public String toString() {
		return "MobDestHost [mobDestHostID=" + mobDestHostID + ", targetID="
				+ targetID + ", mobDestHostIP=" + mobDestHostIP + ", hostUser="
				+ hostUser + ", hostPasswd=" + hostPasswd + ", hostNote="
				+ hostNote + ", hostType=" + hostType + ", hostAddTime="
				+ hostAddTime + ", hostDelTime=" + hostDelTime + "]";
	}

}
