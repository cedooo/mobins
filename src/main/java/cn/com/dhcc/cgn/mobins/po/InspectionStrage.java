package cn.com.dhcc.cgn.mobins.po;

public class InspectionStrage {
	private String strageID = null;
	private String strageName = null;
	private String strageValid = null;
	private String strageNote = null;
	private String strageAddTime = null;
	private String strageDelTime = null;

	private String hostApplyValid = null;
	public String getStrageID() {
		return strageID;
	}

	public void setStrageID(String strageID) {
		this.strageID = strageID;
	}

	public String getStrageName() {
		return strageName;
	}

	public void setStrageName(String strageName) {
		this.strageName = strageName;
	}

	public String getStrageValid() {
		return strageValid;
	}

	public void setStrageValid(String strageValid) {
		this.strageValid = strageValid;
	}

	public String getStrageNote() {
		return strageNote;
	}

	public void setStrageNote(String strageNote) {
		this.strageNote = strageNote;
	}

	public String getStrageAddTime() {
		return strageAddTime;
	}

	public void setStrageAddTime(String strageAddTime) {
		this.strageAddTime = strageAddTime;
	}

	public String getStrageDelTime() {
		return strageDelTime;
	}

	public void setStrageDelTime(String strageDelTime) {
		this.strageDelTime = strageDelTime;
	}

	public String getHostApplyValid() {
		return hostApplyValid;
	}

	public void setHostApplyValid(String hostApplyValid) {
		this.hostApplyValid = hostApplyValid;
	}

	@Override
	public String toString() {
		return "InspectionStrage [strageID=" + strageID + ", strageName="
				+ strageName + ", strageValid=" + strageValid + ", strageNote="
				+ strageNote + ", strageAddTime=" + strageAddTime
				+ ", strageDelTime=" + strageDelTime + ", hostApplyValid="
				+ hostApplyValid + "]";
	}
	
}
