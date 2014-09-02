package cn.com.dhcc.cgn.mobins.setting.action;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.po.InspectionAlarmHold;
import cn.com.dhcc.cgn.mobins.setting.service.StrageService;

import com.opensymphony.xwork2.ActionSupport;

public class StrageHoldAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8221630890560544196L;
	@Autowired
	private StrageService strageService = null;
	
	
	public StrageService getStrageService() {
		return strageService;
	}


	public void setStrageService(StrageService strageService) {
		this.strageService = strageService;
	}

	private InspectionAlarmHold alarmHold = null;
	
	public InspectionAlarmHold getAlarmHold() {
		return alarmHold;
	}


	public void setAlarmHold(InspectionAlarmHold alarmHold) {
		this.alarmHold = alarmHold;
	}

	private boolean operSuccess = false;
	

	public boolean isOperSuccess() {
		return operSuccess;
	}


	public void setOperSuccess(boolean operSuccess) {
		this.operSuccess = operSuccess;
	}


	public String refreshHold(){
		operSuccess =  strageService.refreshAlarmHold(alarmHold);
		return SUCCESS;
	}

}
