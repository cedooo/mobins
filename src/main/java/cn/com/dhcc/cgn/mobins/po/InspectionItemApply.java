package cn.com.dhcc.cgn.mobins.po;

public class InspectionItemApply {
	private String inspectionItemID = null;
	private String strageID = null;
	private String inspectionApplyAddTime = null;
	private String inspectionApplyDelTime = null;
	private String insItemValid = null;
	private String alarmLevel = null;

	public String getInspectionItemID() {
		return inspectionItemID;
	}

	public void setInspectionItemID(String inspectionItemID) {
		this.inspectionItemID = inspectionItemID;
	}

	public String getStrageID() {
		return strageID;
	}

	public void setStrageID(String strageID) {
		this.strageID = strageID;
	}

	public String getInspectionApplyAddTime() {
		return inspectionApplyAddTime;
	}

	public void setInspectionApplyAddTime(String inspectionApplyAddTime) {
		this.inspectionApplyAddTime = inspectionApplyAddTime;
	}

	public String getInspectionApplyDelTime() {
		return inspectionApplyDelTime;
	}

	public void setInspectionApplyDelTime(String inspectionApplyDelTime) {
		this.inspectionApplyDelTime = inspectionApplyDelTime;
	}

	public String getInsItemValid() {
		return insItemValid;
	}

	public void setInsItemValid(String insItemValid) {
		this.insItemValid = insItemValid;
	}

	public String getAlarmLevel() {
		return alarmLevel;
	}

	public void setAlarmLevel(String alarmLevel) {
		this.alarmLevel = alarmLevel;
	}

	@Override
	public String toString() {
		return "InspectionItemApply [inspectionItemID=" + inspectionItemID
				+ ", strageID=" + strageID + ", inspectionApplyAddTime="
				+ inspectionApplyAddTime + ", inspectionApplyDelTime="
				+ inspectionApplyDelTime + ", insItemValid=" + insItemValid
				+ ", alarmLevel=" + alarmLevel + "]";
	}

}
