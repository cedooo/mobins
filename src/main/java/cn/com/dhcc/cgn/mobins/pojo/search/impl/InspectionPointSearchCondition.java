package cn.com.dhcc.cgn.mobins.pojo.search.impl;

import cn.com.dhcc.cgn.mobins.pojo.search.SearchCondition;

public class InspectionPointSearchCondition extends SearchCondition{
	private String inspectionItemID = null;
	private String inspectionStrageID = null;

	public String getInspectionItemID() {
		return inspectionItemID;
	}

	public void setInspectionItemID(String inspectionItemID) {
		this.inspectionItemID = inspectionItemID;
	}

	public String getInspectionStrageID() {
		return inspectionStrageID;
	}

	public void setInspectionStrageID(String inspectionStrageID) {
		this.inspectionStrageID = inspectionStrageID;
	}
	
}
