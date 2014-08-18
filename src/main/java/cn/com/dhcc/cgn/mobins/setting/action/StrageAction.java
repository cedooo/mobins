package cn.com.dhcc.cgn.mobins.setting.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.po.InspectionStrage;
import cn.com.dhcc.cgn.mobins.pojo.pagging.Pagging;
import cn.com.dhcc.cgn.mobins.pojo.search.impl.StrageSearchCondition;
import cn.com.dhcc.cgn.mobins.setting.service.StrageService;

public class StrageAction extends JQGridAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7442713406083582833L;
	@Autowired
	private StrageService strageService = null;
	@Autowired
	private StrageSearchCondition strageSearchCondition = null;
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
	public StrageSearchCondition getStrageSearchCondition() {
		return strageSearchCondition;
	}
	public void setStrageSearchCondition(StrageSearchCondition strageSearchCondition) {
		this.strageSearchCondition = strageSearchCondition;
	}
	public String list(){
		LOG.debug("查询策略");
		Pagging pagging = strageSearchCondition.getPagging();
		pagging.setPage(this.getPage());
		pagging.setRows(this.getRows());
		int records = strageService.count(strageSearchCondition);
		pagging.setRecords(records+"");
		int rows = 10;
		try{
			rows = Integer.parseInt(this.getRows());
		}catch(NumberFormatException e){
			
		}
		int totals = (int)Math.ceil((records*1d)/rows);
		pagging.setTotal(totals+"");
		LOG.debug("pagging = " + pagging + "\n" + pagging.getSkip());
		LOG.debug("记录总条数" + records);
		listStrage = this.strageService.list(strageSearchCondition);
		return SUCCESS;
	}
	
}
