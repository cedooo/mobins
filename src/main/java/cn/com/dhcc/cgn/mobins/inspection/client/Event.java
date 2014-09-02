package cn.com.dhcc.cgn.mobins.inspection.client;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Event {
	public static final String OCCUR = "发生";
	public static final String CLEAR = "清除";
	static private final String DEFAULT_ENCODE = "GBK";
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
		String repa = "";;
		try {
			repa = "mosn=" + URLEncoder.encode(mosn, DEFAULT_ENCODE) + "&addinfo=" + URLEncoder.encode(addinfo, DEFAULT_ENCODE) + "&cause="
					+ URLEncoder.encode(cause, DEFAULT_ENCODE) + "&origininfo=" + URLEncoder.encode(origininfo, DEFAULT_ENCODE) + "&detail=" + URLEncoder.encode(detail, DEFAULT_ENCODE)
					+ "&occurtime=" + occurtime + "&severity=" + URLEncoder.encode(severity, DEFAULT_ENCODE)
					+ "&status=" + URLEncoder.encode(status, DEFAULT_ENCODE);
			repa = URLEncoder.encode(repa, DEFAULT_ENCODE);
			repa = repa.replaceAll("\\+", "%20");    //处理空格
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
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
