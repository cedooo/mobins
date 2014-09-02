package cn.com.dhcc.cgn.mobins.po;
/**
 * 告警级别及阀值设置
 * @author CeDo
 *
 */
public class InspectionAlarmHold {
	private String holdStrageID = null;
	private String inspectionPointID = null;
	private String valueMax = null;
	private String valueMin = null;
	private String holdAddTime = null;
	private String holdDelTime = null;
	private String holdValid = null;
	private String alarmLevel = null;

	public String getHoldStrageID() {
		return holdStrageID;
	}

	public void setHoldStrageID(String holdStrageID) {
		this.holdStrageID = holdStrageID;
	}

	public String getInspectionPointID() {
		return inspectionPointID;
	}

	public void setInspectionPointID(String inspectionPointID) {
		this.inspectionPointID = inspectionPointID;
	}

	public String getValueMax() {
		return valueMax;
	}

	public void setValueMax(String valueMax) {
		this.valueMax = valueMax;
	}

	public String getValueMin() {
		return valueMin;
	}

	public void setValueMin(String valueMin) {
		this.valueMin = valueMin;
	}

	public String getHoldAddTime() {
		return holdAddTime;
	}

	public void setHoldAddTime(String holdAddTime) {
		this.holdAddTime = holdAddTime;
	}

	public String getHoldDelTime() {
		return holdDelTime;
	}

	public void setHoldDelTime(String holdDelTime) {
		this.holdDelTime = holdDelTime;
	}

	public String getHoldValid() {
		return holdValid;
	}

	public void setHoldValid(String holdValid) {
		this.holdValid = holdValid;
	}

	public String getAlarmLevel() {
		return alarmLevel;
	}

	public void setAlarmLevel(String alarmLevel) {
		this.alarmLevel = alarmLevel;
	}

	@Override
	public String toString() {
		return "InspectionAlarmHold [holdStrageID=" + holdStrageID
				+ ", inspectionPointID=" + inspectionPointID + ", valueMax="
				+ valueMax + ", valueMin=" + valueMin + ", holdAddTime="
				+ holdAddTime + ", holdDelTime=" + holdDelTime + ", holdValid="
				+ holdValid + ", alarmLevel=" + alarmLevel + "]";
	}

}
