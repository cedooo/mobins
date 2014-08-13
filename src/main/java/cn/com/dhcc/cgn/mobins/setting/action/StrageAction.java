package cn.com.dhcc.cgn.mobins.setting.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.po.InspectionStrage;
import cn.com.dhcc.cgn.mobins.setting.service.StrageService;

public class StrageAction extends JQGridAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7442713406083582833L;
	@Autowired
	private StrageService strageService = null;
	public StrageService getStrageService() {
		return strageService;
	}
	public void setStrageService(StrageService strageService) {
		this.strageService = strageService;
	}
	
	private List<InspectionStrage> listStrage= null;
	
	public List<InspectionStrage> getListStrage() {
		return listStrage;
	}
	public void setListStrage(List<InspectionStrage> listStrage) {
		this.listStrage = listStrage;
	}
	public String list(){
		listStrage = this.strageService.list(null);
		return SUCCESS;
	}
	
}
