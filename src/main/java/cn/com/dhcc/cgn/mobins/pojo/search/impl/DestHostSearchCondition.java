package cn.com.dhcc.cgn.mobins.pojo.search.impl;

import cn.com.dhcc.cgn.mobins.pojo.search.SearchCondition;

/**
 * @author CeDo
 *
 */
public class DestHostSearchCondition extends SearchCondition{
	private String targetID = null;

	public String getTargetID() {
		return targetID;
	}

	public void setTargetID(String targetID) {
		this.targetID = targetID;
	}

	@Override
	public String toString() {
		return "DestHostSearchCondition [targetID=" + targetID + "]";
	}
	
}
