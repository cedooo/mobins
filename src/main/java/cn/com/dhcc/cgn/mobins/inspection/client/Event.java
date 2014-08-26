package cn.com.dhcc.cgn.mobins.inspection.client;

public class Event {
	//设备号
	private String mosn = null;
	//附加信息
	private String addinfo = null;
	//告警原因
	private String cause = null;
	//原始信息
	private String origininfo = null;
	//告警详情
	private String detail = null;
	//发生时间
	private String occurtime = null;
	//告警级别
	private String severity = null;
	//告警状态
	private String status = null;
	public String getMosn() {
		return mosn;
	}
	public void setMosn(String mosn) {
		this.mosn = mosn;
	}
	public String getAddinfo() {
		return addinfo;
	}
	public void setAddinfo(String addinfo) {
		this.addinfo = addinfo;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getOrigininfo() {
		return origininfo;
	}
	public void setOrigininfo(String origininfo) {
		this.origininfo = origininfo;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getOccurtime() {
		return occurtime;
	}
	public void setOccurtime(String occurtime) {
		this.occurtime = occurtime;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 转换为HTTP请求参数
	 * @return
	 */
	public String parseRequestParam(){
		String repa = "mosn=" + mosn + "&addinfo=" + addinfo + "&cause="
				+ cause + "&origininfo=" + origininfo + "&detail=" + detail
				+ "&occurtime=" + occurtime + "&severity=" + severity
				+ "&status=" + status ;
		return repa;
	}
	@Override
	public String toString() {
		return "Event [mosn=" + mosn + ", addinfo=" + addinfo + ", cause="
				+ cause + ", origininfo=" + origininfo + ", detail=" + detail
				+ ", occurtime=" + occurtime + ", severity=" + severity
				+ ", status=" + status + "]";
	}
	
	

}
