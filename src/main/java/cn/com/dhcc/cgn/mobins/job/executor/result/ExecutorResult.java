package cn.com.dhcc.cgn.mobins.job.executor.result;

import java.util.Vector;

public class ExecutorResult {
	
	private String executeInfo = null;
	private String resultString = null;
	private Vector<String> resultVector = null;

	public String getExecuteInfo() {
		return executeInfo;
	}

	public void setExecuteInfo(String executeInfo) {
		this.executeInfo = executeInfo;
	}

	public Vector<String> getResultVector() {
		return resultVector;
	}

	public void setResultVector(Vector<String> resultVector) {
		this.resultVector = resultVector;
	}

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	@Override
	public String toString() {
		return "ExecutorResult [executeInfo=" + executeInfo + ", resultString="
				+ resultString + ", resultVector=" + resultVector + "]";
	}

	public String getStrResultVector() {
		StringBuilder strBuilder = new StringBuilder();
		for (String str : resultVector) {
			strBuilder.append(str + "<br />");
		}
		return strBuilder.toString();
	}
}
