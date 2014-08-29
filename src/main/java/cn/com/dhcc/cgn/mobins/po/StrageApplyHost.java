package cn.com.dhcc.cgn.mobins.po;

public class StrageApplyHost {
	private String mobDestHostID = null;
	private String strageID = null;
	private String applyAddTime = null;
	private String applyDelTime = null;
	private String applyValid = null;

	public String getMobDestHostID() {
		return mobDestHostID;
	}

	public void setMobDestHostID(String mobDestHostID) {
		this.mobDestHostID = mobDestHostID;
	}

	public String getStrageID() {
		return strageID;
	}

	public void setStrageID(String strageID) {
		this.strageID = strageID;
	}

	public String getApplyAddTime() {
		return applyAddTime;
	}

	public void setApplyAddTime(String applyAddTime) {
		this.applyAddTime = applyAddTime;
	}

	public String getApplyDelTime() {
		return applyDelTime;
	}

	public void setApplyDelTime(String applyDelTime) {
		this.applyDelTime = applyDelTime;
	}

	public String getApplyValid() {
		return applyValid;
	}

	public void setApplyValid(String applyValid) {
		this.applyValid = applyValid;
	}

	@Override
	public String toString() {
		return "StrageApplyHost [mobDestHostID=" + mobDestHostID
				+ ", strageID=" + strageID + ", applyAddTime=" + applyAddTime
				+ ", applyDelTime=" + applyDelTime + ", applyValid="
				+ applyValid + "]";
	}

}
