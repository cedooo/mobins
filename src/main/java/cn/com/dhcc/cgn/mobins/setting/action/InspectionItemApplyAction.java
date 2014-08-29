package cn.com.dhcc.cgn.mobins.setting.action;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.po.InspectionItemApply;
import cn.com.dhcc.cgn.mobins.setting.service.InspectionItemApplyService;

import com.opensymphony.xwork2.ActionSupport;

public class InspectionItemApplyAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2176146739658631751L;
	
	private String valid = null;
	@Autowired
	private InspectionItemApplyService itemApplyService = null;
	private boolean operSuccess = false;
	private InspectionItemApply itemApply = null;

	public boolean isOperSuccess() {
		return operSuccess;
	}
	public void setOperSuccess(boolean operSuccess) {
		this.operSuccess = operSuccess;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public InspectionItemApplyService getItemApplyService() {
		return itemApplyService;
	}
	public void setItemApplyService(InspectionItemApplyService itemApplyService) {
		this.itemApplyService = itemApplyService;
	}
	public InspectionItemApply getItemApply() {
		return itemApply;
	}
	public void setItemApply(InspectionItemApply itemApply) {
		this.itemApply = itemApply;
	}
	@Override
	public String execute(){
		if("Y".equals(valid)){
			this.operSuccess = itemApplyService.inspectionApply(itemApply, true);
		}else if("N".equals(valid)){
			this.operSuccess = itemApplyService.inspectionApply(itemApply, false);
		}
		return SUCCESS;
	}

}
