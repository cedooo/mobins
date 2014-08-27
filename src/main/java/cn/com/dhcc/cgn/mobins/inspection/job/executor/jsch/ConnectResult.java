package cn.com.dhcc.cgn.mobins.inspection.job.executor.jsch;

public class ConnectResult {
	private String result = null;
	private boolean success = false;
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ConnectResult [result=" + result + ", success=" + success + "]";
	}
	
}
