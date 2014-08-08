package cn.com.dhcc.cgn.mobins.po;

public class InspectionReport {
	private String inspectionReportID = null;
	private String mobDestHostID = null;
	private String inspectionTime = null;
	private String maintAccount = null;
	private String maintUser = null;
	private String generateTime = null;
	private String inspectionIsException = null;
	private String inspectionComplete = null;
	
	public String getInspectionReportID() {
		return inspectionReportID;
	}
	public void setInspectionReportID(String inspectionReportID) {
		this.inspectionReportID = inspectionReportID;
	}
	public String getMobDestHostID() {
		return mobDestHostID;
	}
	public void setMobDestHostID(String mobDestHostID) {
		this.mobDestHostID = mobDestHostID;
	}
	public String getInspectionTime() {
		return inspectionTime;
	}
	public void setInspectionTime(String inspectionTime) {
		this.inspectionTime = inspectionTime;
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
	public String getInspectionIsException() {
		return inspectionIsException;
	}
	public void setInspectionIsException(String inspectionIsException) {
		this.inspectionIsException = inspectionIsException;
	}
	public String getInspectionComplete() {
		return inspectionComplete;
	}
	public void setInspectionComplete(String inspectionComplete) {
		this.inspectionComplete = inspectionComplete;
	}
	@Override
	public String toString() {
		return "InspectionReport [inspectionReportID=" + inspectionReportID
				+ ", mobDestHostID=" + mobDestHostID + ", inspectionTime="
				+ inspectionTime + ", maintAccount=" + maintAccount
				+ ", maintUser=" + maintUser + ", generateTime=" + generateTime
				+ ", inspectionIsException=" + inspectionIsException + "]";
	}
	
	
	
}
