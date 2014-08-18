package cn.com.dhcc.cgn.mobins.po;

public class InspectionPoint {
	private String inspectionPointID = null;
	private String inspectionItemID = null;
	private String operCommand = null;
	private String operNote = null;
	private String checkPointName = null;
	private String keyRegex = null;
	private String valCompareMin = null;
	private String valCompareMax = null;
	private String matchType = null;
	private String inspectionCode = null;
	private String resultFormat = null;
	private String sortNum = null;
	private String exceptionWeight = null;

	public String getInspectionPointID() {
		return inspectionPointID;
	}

	public void setInspectionPointID(String inspectionPointID) {
		this.inspectionPointID = inspectionPointID;
	}

	public String getInspectionItemID() {
		return inspectionItemID;
	}

	public void setInspectionItemID(String inspectionItemID) {
		this.inspectionItemID = inspectionItemID;
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

	public String getInspectionCode() {
		return inspectionCode;
	}

	public void setInspectionCode(String inspectionCode) {
		this.inspectionCode = inspectionCode;
	}

	public String getResultFormat() {
		return resultFormat;
	}

	public void setResultFormat(String resultFormat) {
		this.resultFormat = resultFormat;
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

	@Override
	public String toString() {
		return "InspectionPoint [inspectionPointID=" + inspectionPointID
				+ ", inspectionItemID=" + inspectionItemID + ", operCommand="
				+ operCommand + ", operNote=" + operNote + ", checkPointName="
				+ checkPointName + ", keyRegex=" + keyRegex
				+ ", valCompareMin=" + valCompareMin + ", valCompareMax="
				+ valCompareMax + ", matchType=" + matchType
				+ ", inspectionCode=" + inspectionCode + "]";
	}

}
