package cn.com.dhcc.cgn.mobins.setting.action;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.po.StrageApplyHost;
import cn.com.dhcc.cgn.mobins.setting.service.StrageApplyService;

import com.opensymphony.xwork2.ActionSupport;

public class StrageApplyAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2176146739658631751L;
	
	
	
	private boolean operSuccess = false;
	@Autowired
	private StrageApplyService applyService = null;

	private String valid = null;
	public boolean isOperSuccess() {
		return operSuccess;
	}
	public void setOperSuccess(boolean operSuccess) {
		this.operSuccess = operSuccess;
	}
	private StrageApplyHost strageApplyHost = null;
	
	public StrageApplyHost getStrageApplyHost() {
		return strageApplyHost;
	}
	public void setStrageApplyHost(StrageApplyHost strageApplyHost) {
		this.strageApplyHost = strageApplyHost;
	}
	public StrageApplyService getApplyService() {
		return applyService;
	}
	public void setApplyService(StrageApplyService applyService) {
		this.applyService = applyService;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	@Override
	public String execute(){
		if("Y".equals(valid)){
			this.operSuccess = applyService.inspectionApply(strageApplyHost, true);
		}else if("N".equals(valid)){
			this.operSuccess = applyService.inspectionApply(strageApplyHost, false);
		}
		return SUCCESS;
	}

}
