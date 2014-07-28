package cn.com.dhcc.cgn.mobins.commons.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4538380752869892985L;
	private static final Logger log = Logger.getLogger(IndexAction.class.getClass());

	@Override
	public String execute(){
		log.info("��ת��Ĭ��ҳ��");
		return SUCCESS;
	}
}
