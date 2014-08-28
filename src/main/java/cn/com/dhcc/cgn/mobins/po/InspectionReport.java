package cn.com.dhcc.cgn.mobins.po;

public class InspectionReport {
	static final public String EXCEPTION = "异常";
	static final public String COMPLETE_SUCCESS = "1";
	static final public String COMPLETE_FAIL = "1";
	
	private String inspectionReportID = null;
	private String mobDestHostIP = null;    //VC_MOB_DEST_HOST_IP 
	private String mobDestHostID = null;
	private String inspectionTime = null;
	private String maintAccount = null;
	private String maintUser = null;
	private String generateTime = null;
	private String inspectionIsException = null;
	private String inspectionComplete = null;
	private String mobDestHostInfo = null;    //VC_MOB_DEST_HOST_INFO
	public String getInspectionReportID() {
		return inspectionReportID;
	}
	public void setInspectionReportID(String inspectionReportID) {
		this.inspectionReportID = inspectionReportID;
	}
	public String getMobDestHostIP() {
		return mobDestHostIP;
	}
	public void setMobDestHostIP(String mobDestHostIP) {
		this.mobDestHostIP = mobDestHostIP;
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
	public String getMobDestHostInfo() {
		return mobDestHostInfo;
	}
	public void setMobDestHostInfo(String mobDestHostInfo) {
		this.mobDestHostInfo = mobDestHostInfo;
	}
	@Override
	public String toString() {
		return "InspectionReport [inspectionReportID=" + inspectionReportID
				+ ", mobDestHostIP=" + mobDestHostIP + ", mobDestHostID="
				+ mobDestHostID + ", inspectionTime=" + inspectionTime
				+ ", maintAccount=" + maintAccount + ", maintUser=" + maintUser
				+ ", generateTime=" + generateTime + ", inspectionIsException="
				+ inspectionIsException + ", inspectionComplete="
				+ inspectionComplete + "]";
	}
	
}
