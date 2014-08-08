package cn.com.dhcc.cgn.mobins.inspection.match.result;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class MatchResult {
	static final protected Logger LOG = LoggerFactory.getLogger(MatchResult.class.getClass());
	private String isException = null;
	private String checkResult = null;
	private boolean checkComplete = false;
	public String getIsException() {
		return isException;
	}
	public void setIsException(String isException) {
		this.isException = isException;
	}
	public boolean isCheckComplete() {
		return checkComplete;
	}
	public void setCheckComplete(boolean checkComplete) {
		this.checkComplete = checkComplete;
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
