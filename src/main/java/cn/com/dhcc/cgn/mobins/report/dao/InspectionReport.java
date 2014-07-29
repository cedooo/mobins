package cn.com.dhcc.cgn.mobins.report.dao;

public class InspectionReport {
	private String inspectionReportID = null;
	private String maintAccount = null;
	private String maintUser = null;
	private String generateTime = null;
	private String inspectionTime = null;
	private String isException = null;
	
	public String getInspectionReportID() {
		return inspectionReportID;
	}
	public void setInspectionReportID(String inspectionReportID) {
		this.inspectionReportID = inspectionReportID;
	}
	public String getMaintAccount() {
		return maintAccount;
	}
	public void setMaintAccount(String maintAccount) {
		this.maintAccount = maintAccount;
	}
	public String getMaintUser() {
		return maintUser;
	}
	public void setMaintUser(String maintUser) {
		this.maintUser = maintUser;
	}
	public String getGenerateTime() {
		return generateTime;
	}
	public void setGenerateTime(String generateTime) {
		this.generateTime = generateTime;
	}
	public String getInspectionTime() {
		return inspectionTime;
	}
	public void setInspectionTime(String inspectionTime) {
		this.inspectionTime = inspectionTime;
	}
	public String getIsException() {
		return isException;
	}
	public void setIsException(String isException) {
		this.isException = isException;
	}
	@Override
	public String toString() {
		return "InspectionReport [inspectionReportID=" + inspectionReportID
				+ ", maintAccount=" + maintAccount + ", maintUser=" + maintUser
				+ ", generateTime=" + generateTime + ", inspectionTime="
				+ inspectionTime + ", isException=" + isException + "]";
	}
	
	
}
