package cn.com.dhcc.cgn.mobins.report.dao;

public class QueryReportParam {
	private String hostID = null;
	private String formatDate = null;
	public QueryReportParam(String hostID, String formatDate){
		this.hostID = hostID;
		this.formatDate = formatDate;
	}
	public String getHostID() {
		return hostID;
	}
	public void setHostID(String hostID) {
		this.hostID = hostID;
	}
	public String getFormatDate() {
		return formatDate;
	}
	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}
	
}
