package cn.com.dhcc.cgn.mobins.commons.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class IndexAction extends ActionSupport{
	static final private Logger LOG = LoggerFactory.getLogger(IndexAction.class.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = -4538380752869892985L;

	@Override
	public String execute(){
		LOG.info("跳转主页(index.jsp)");
		return SUCCESS;
	}
	public String report(){
		return SUCCESS;
	}
}
