package cn.com.dhcc.cgn.mobins.po;

public class InspectionRecords {
	private String inspectionRecordsID = null;
	private String inspectionReportID = null;
	private String checkItem = null;
	private String checkPoint = null;
	private String checkNote = null;
	private String operNote = null;
	private String isException = null;
	private String checkResult = null;
	private String protoData = null;
	private String dealResult = null;
	private String inspectionType = null;
	private String addTime = null;
	private String checkCode = null;
	private String checkComplete = null;
	private String showSortNum = null;
	private String recordsExceptionWeight = null;//RECORDS_EXCEPTION_WEIGHT
	
	public String getInspectionRecordsID() {
		return inspectionRecordsID;
	}

	public void setInspectionRecordsID(String inspectionRecordsID) {
		this.inspectionRecordsID = inspectionRecordsID;
	}

	public String getInspectionReportID() {
		return inspectionReportID;
	}

	public void setInspectionReportID(String inspectionReportID) {
		this.inspectionReportID = inspectionReportID;
	}

	public String getCheckItem() {
		return checkItem;
	}

	public void setCheckItem(String checkItem) {
		this.checkItem = checkItem;
	}

	public String getCheckPoint() {
		return checkPoint;
	}

	public void setCheckPoint(String checkPoint) {
		this.checkPoint = checkPoint;
	}

	public String getCheckNote() {
		return checkNote;
	}

	public void setCheckNote(String checkNote) {
		this.checkNote = checkNote;
	}

	public String getOperNote() {
		return operNote;
	}

	public void setOperNote(String operNote) {
		this.operNote = operNote;
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

	public String getInspectionType() {
		return inspectionType;
	}

	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getCheckComplete() {
		return checkComplete;
	}

	public void setCheckComplete(String checkComplete) {
		this.checkComplete = checkComplete;
	}

	public String getShowSortNum() {
		return showSortNum;
	}

	public void setShowSortNum(String showSortNum) {
		this.showSortNum = showSortNum;
	}

	public String getRecordsExceptionWeight() {
		return recordsExceptionWeight;
	}

	public void setRecordsExceptionWeight(String recordsExceptionWeight) {
		this.recordsExceptionWeight = recordsExceptionWeight;
	}

	@Override
	public String toString() {
		return "InspectionRecords [inspectionRecordsID=" + inspectionRecordsID
				+ ", inspectionReportID=" + inspectionReportID + ", checkItem="
				+ checkItem + ", checkPoint=" + checkPoint + ", checkNote="
				+ checkNote + ", operNote=" + operNote + ", isException="
				+ isException + ", checkResult=" + checkResult + ", protoData="
				+ protoData + ", dealResult=" + dealResult
				+ ", inspectionType=" + inspectionType + ", addTime=" + addTime
				+ ", checkCode=" + checkCode + "]";
	}

	
	
}
