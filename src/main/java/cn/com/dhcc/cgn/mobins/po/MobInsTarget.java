package cn.com.dhcc.cgn.mobins.po;

public class MobInsTarget {

	private String targetID = null;
	private String targetName = null;
	private String targetNote = null;
	private String targetAddTime = null;
	private String targetDelTime = null;
	private String targetInsValid = null;
	public String getTargetID() {
		return targetID;
	}
	public void setTargetID(String targetID) {
		this.targetID = targetID;
	}
	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public String getTargetNote() {
		return targetNote;
	}
	public void setTargetNote(String targetNote) {
		this.targetNote = targetNote;
	}
	public String getTargetAddTime() {
		return targetAddTime;
	}
	public void setTargetAddTime(String targetAddTime) {
		this.targetAddTime = targetAddTime;
	}
	public String getTargetDelTime() {
		return targetDelTime;
	}
	public void setTargetDelTime(String targetDelTime) {
		this.targetDelTime = targetDelTime;
	}
	
	public String getTargetInsValid() {
		return targetInsValid;
	}
	public void setTargetInsValid(String targetInsValid) {
		this.targetInsValid = targetInsValid;
	}
	@Override
	public String toString() {
		return "MobInsTarget [targetID=" + targetID + ", targetName="
				+ targetName + ", targetNote=" + targetNote
				+ ", targetAddTime=" + targetAddTime + ", targetDelTime="
				+ targetDelTime + "]";
	}
	
}
