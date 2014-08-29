package cn.com.dhcc.cgn.mobins.po;

public class InspectionItem {
	private String inspectionItemID = null;
	private String itemName = null;
	private String inspectionType = null;
	private String inspectionItemNote = null;

	private String valid = null;
	public String getInspectionItemID() {
		return inspectionItemID;
	}

	public void setInspectionItemID(String inspectionItemID) {
		this.inspectionItemID = inspectionItemID;
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

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

}
