package cn.com.dhcc.cgn.mobins.pojo.search;

import cn.com.dhcc.cgn.mobins.pojo.pagging.Pagging;

public abstract class SearchCondition {
	
	private Pagging pagging = null;

	public Pagging getPagging() {
		return pagging;
	}

	public void setPagging(Pagging pagging) {
		this.pagging = pagging;
	}

	@Override
	public String toString() {
		return "SearchCondition [pagging=" + pagging + "]";
	}
	
}
