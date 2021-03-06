package cn.com.dhcc.cgn.mobins.inspection.dao;

public class AnalysisInfo {
	static public final String MATCH_TYPE_RANGE = "2";
	static public final String MATCH_TYPE_EXPRESS = "1";
	static public final String MATCH_TYPE_MEMRATE = "3";
	static public final String MATCH_TYPE_PROGRESS_CHECK = "4";
	static public final String MATCH_TYPE_SOLOMO_SWITCH = "5";
	static public final String MATCH_TYPE_PORGRESS_COUNT = "6";
	static public final String MATCH_TYPE_HA_ERROR = "7";
	static public final String MATCH_TYPE_INT_RANGE = "8";
	private String inspectionRecordsID = null;
	private String isException = null;
	private String checkResult = null;
	private String protoData = null;
	private String dealResult = null;
	private String checkCode = null;
	
	private String checkPointName = null;
	private String keyRegex = null;
	private String valCompareMin = null;
	private String valCompareMax = null;
	private String matchType = null;
	private String resultFormat = null;
	private String checkComplete = null;
	
	private String alarmLevel = null;
	private String strageID = null;
	private String pointID = null;
	public String getInspectionRecordsID() {
		return inspectionRecordsID;
	}
	public void setInspectionRecordsID(String inspectionRecordsID) {
		this.inspectionRecordsID = inspectionRecordsID;
	}
	public String getIsException() {
		return isException;
	}
	public void setIsException(String isException) {
		this.isException = isException;
	}
	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	public String getProtoData() {
		return protoData;
	}
	public void setProtoData(String protoData) {
		this.protoData = protoData;
	}
	public String getDealResult() {
		return dealResult;
	}
	public void setDealResult(String dealResult) {
		this.dealResult = dealResult;
	}
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	public String getCheckPointName() {
		return checkPointName;
	}
	public void setCheckPointName(String checkPointName) {
		this.checkPointName = checkPointName;
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
	public String getResultFormat() {
		return resultFormat;
	}
	public void setResultFormat(String resultFormat) {
		this.resultFormat = resultFormat;
	}
	public String getCheckComplete() {
		return checkComplete;
	}
	public void setCheckComplete(String checkComplete) {
		this.checkComplete = checkComplete;
	}
	public String getAlarmLevel() {
		return alarmLevel;
	}
	public void setAlarmLevel(String alarmLevel) {
		this.alarmLevel = alarmLevel;
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
	@Override
	public String toString() {
		return "AnalysisInfo [inspectionRecordsID=" + inspectionRecordsID
				+ ", isException=" + isException + ", checkResult="
				+ checkResult + ", protoData=" + protoData + ", dealResult="
				+ dealResult + ", checkCode=" + checkCode + ", checkPointName="
				+ checkPointName + ", keyRegex=" + keyRegex
				+ ", valCompareMin=" + valCompareMin + ", valCompareMax="
				+ valCompareMax + ", matchType=" + matchType
				+ ", resultFormat=" + resultFormat + ", checkComplete="
				+ checkComplete + ", alarmLevel=" + alarmLevel + ", strageID="
				+ strageID + ", pointID=" + pointID + "]";
	}

}
