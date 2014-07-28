package cn.com.dhcc.cgn.mobins.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class DefaultAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4538380752869892985L;
	private static final Logger log = Logger.getLogger(DefaultAction.class.getClass());

	@Override
	public String execute(){
		log.info("跳转到默认页面");
		return SUCCESS;
	}
}
