package cn.com.dhcc.cgn.mobins.action;

import com.opensymphony.xwork2.ActionSupport;

public class DefaultAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4538380752869892985L;

	@Override
	public String execute(){
		System.out.println("Ä¬ÈÏaction");
		return SUCCESS;
	}
}
