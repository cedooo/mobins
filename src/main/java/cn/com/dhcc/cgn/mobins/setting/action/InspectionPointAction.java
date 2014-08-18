package cn.com.dhcc.cgn.mobins.setting.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.po.InspectionPoint;
import cn.com.dhcc.cgn.mobins.pojo.pagging.Pagging;
import cn.com.dhcc.cgn.mobins.pojo.search.impl.InspectionPointSearchCondition;
import cn.com.dhcc.cgn.mobins.setting.service.InspectionPointService;

public class InspectionPointAction extends JQGridAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7947926711092717891L;
	@Autowired
	private InspectionPointService inspectionPointService = null;
	
	public InspectionPointService getInspectionPointService() {
		return inspectionPointService;
	}

	public void setInspectionPointService(
			InspectionPointService inspectionPointService) {
		this.inspectionPointService = inspectionPointService;
	}
	private List<InspectionPoint> listInspectionPoint = null;
	
	public List<InspectionPoint> getListInspectionPoint() {
		return listInspectionPoint;
	}

	public void setListInspectionPoint(List<InspectionPoint> listInspectionPoint) {
		this.listInspectionPoint = listInspectionPoint;
	}
	@Autowired
	private InspectionPointSearchCondition searchCondition = null;
	
	public InspectionPointSearchCondition getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(InspectionPointSearchCondition searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String list(){
		LOG.debug("查询策略");
		Pagging pagging = searchCondition.getPagging();
		pagging.setPage(this.getPage());
		pagging.setRows(this.getRows());
		int records = inspectionPointService.count(searchCondition);
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
		listInspectionPoint = inspectionPointService.list(searchCondition);
		return SUCCESS;
	}
}
