package cn.com.dhcc.cgn.mobins.inspection.match.result;

public class MatchResult {
	private String isException = null;
	private String checkResult = null;
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
	@Override
	public String toString() {
		return "MatchResult [isException=" + isException + ", checkResult="
				+ checkResult + "]";
	}
	
	
}
