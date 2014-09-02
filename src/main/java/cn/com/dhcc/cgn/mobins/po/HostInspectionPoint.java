package cn.com.dhcc.cgn.mobins.po;

/**
 * 巡检点 视图
 * @author CeDo
 * 
 */
public class HostInspectionPoint {

	private String mobDestHostID = null;
	private String mobDestHostIP = null;
	private String hostUser = null;
	private String hostPasswd = null;
	private String hostNote = null;
	private String hostType = null;
	private String strageID = null;
	private String pointID = null;
	private String strageName = null;
	private String strageValid = null;
	private String strageNote = null;
	private String itemName = null;
	private String inspectionType = null;
	private String inspectionItemNote = null;
	private String operCommand = null;
	private String operNote = null;
	private String checkPointName = null;
	private String inspectionCode = null;
	private String keyRegex = null;
	private String valCompareMin = null;
	private String valCompareMax = null;
	private String matchType = null;
	private String sortNum = null;
	private String exceptionWeight = null;
	private String alarmLevel = null;
	public String getMobDestHostID() {
		return mobDestHostID;
	}

	public void setMobDestHostID(String mobDestHostID) {
		this.mobDestHostID = mobDestHostID;
	}

	public String getMobDestHostIP() {
		return mobDestHostIP;
	}

	public void setMobDestHostIP(String mobDestHostIP) {
		this.mobDestHostIP = mobDestHostIP;
	}

	public String getHostUser() {
		return hostUser;
	}

	public void setHostUser(String hostUser) {
		this.hostUser = hostUser;
	}

	public String getHostPasswd() {
		return hostPasswd;
	}

	public void setHostPasswd(String hostPasswd) {
		this.hostPasswd = hostPasswd;
	}

	public String getHostNote() {
		return hostNote;
	}

	public void setHostNote(String hostNote) {
		this.hostNote = hostNote;
	}

	public String getHostType() {
		return hostType;
	}

	public void setHostType(String hostType) {
		this.hostType = hostType;
	}

	public String getStrageID() {
		return strageID;
	}

	public void setStrageID(String strageID) {
		this.strageID = strageID;
	}

	public String getPointID() {
		return pointID;
	}

	public void setPointID(String pointID) {
		this.pointID = pointID;
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getInspectionType() {
		return inspectionType;
	}

	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}

	public String getInspectionItemNote() {
		return inspectionItemNote;
	}

	public void setInspectionItemNote(String inspectionItemNote) {
		this.inspectionItemNote = inspectionItemNote;
	}

	public String getOperCommand() {
		return operCommand;
	}

	public void setOperCommand(String operCommand) {
		this.operCommand = operCommand;
	}

	public String getOperNote() {
		return operNote;
	}

	public void setOperNote(String operNote) {
		this.operNote = operNote;
	}

	public String getCheckPointName() {
		return checkPointName;
	}

	public void setCheckPointName(String checkPointName) {
		this.checkPointName = checkPointName;
	}

	public String getInspectionCode() {
		return inspectionCode;
	}

	public void setInspectionCode(String inspectionCode) {
		this.inspectionCode = inspectionCode;
	}

	public String getKeyRegex() {
		return keyRegex;
	}

	public void setKeyRegex(String keyRegex) {
		this.keyRegex = keyRegex;
	}

	public String getValCompareMin() {
		return valCompareMin;
	}

	public void setValCompareMin(String valCompareMin) {
		this.valCompareMin = valCompareMin;
	}

	public String getValCompareMax() {
		return valCompareMax;
	}

	public void setValCompareMax(String valCompareMax) {
		this.valCompareMax = valCompareMax;
	}

	public String getMatchType() {
		return matchType;
	}

	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}

	public String getSortNum() {
		return sortNum;
	}

	public void setSortNum(String sortNum) {
		this.sortNum = sortNum;
	}

	public String getExceptionWeight() {
		return exceptionWeight;
	}

	public void setExceptionWeight(String exceptionWeight) {
		this.exceptionWeight = exceptionWeight;
	}

	public String getAlarmLevel() {
		return alarmLevel;
	}

	public void setAlarmLevel(String alarmLevel) {
		this.alarmLevel = alarmLevel;
	}

	@Override
	public String toString() {
		return "HostInspectionPoint [mobDestHostID=" + mobDestHostID
				+ ", mobDestHostIP=" + mobDestHostIP + ", hostUser=" + hostUser
				+ ", hostPasswd=" + hostPasswd + ", hostNote=" + hostNote
				+ ", hostType=" + hostType + ", strageName=" + strageName
				+ ", strageValid=" + strageValid + ", strageNote=" + strageNote
				+ ", itemName=" + itemName + ", inspectionType="
				+ inspectionType + ", inspectionItemNote=" + inspectionItemNote
				+ ", operCommand=" + operCommand + ", operNote=" + operNote
				+ ", checkPointName=" + checkPointName + ", inspectionCode="
				+ inspectionCode + ", keyRegex=" + keyRegex
				+ ", valCompareMin=" + valCompareMin + ", valCompareMax="
				+ valCompareMax + ", matchType=" + matchType + ", sortNum="
				+ sortNum + ", exceptionWeight=" + exceptionWeight
				+ ", alarmLevel=" + alarmLevel + "]";
	}

	
}
