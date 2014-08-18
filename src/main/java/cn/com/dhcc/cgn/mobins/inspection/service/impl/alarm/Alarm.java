package cn.com.dhcc.cgn.mobins.inspection.service.impl.alarm;

import cn.com.dhcc.cgn.mobins.po.InspectionRecords;

public class Alarm {
	static final private String PRE_REASON = "巡检-";
	private String equipID = null;    //设备ID
	private String attrName = null;    //属性名称
	private String level = null;    //告警级别
	private String reason = null;    //告警原因
	private String content = null;    //告警内容
	public String getEquipID() {
		return equipID;
	}
	public void setEquipID(String equipID) {
		this.equipID = equipID;
	}
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public static Alarm parseAlarm(InspectionRecords records){
		Alarm alarm = new Alarm();
		alarm.setAttrName(records.getCheckItem());
		alarm.setLevel(records.getRecordsExceptionWeight());
		String result = records.getCheckResult();
		if(result!=null){
			result = result.replaceAll("\\.*<br //>\\.*", " ");
		}
		alarm.setContent(records.getCheckResult());
		alarm.setReason(PRE_REASON + records.getCheckNote());
		return alarm;
	}
	@Override
	public String toString() {
		return "Alarm [equipID=" + equipID + ", attrName=" + attrName
				+ ", level=" + level + ", reason=" + reason + ", content="
				+ content + "]";
	}
	
	
}	
