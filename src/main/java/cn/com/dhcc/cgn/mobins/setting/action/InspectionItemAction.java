package cn.com.dhcc.cgn.mobins.setting.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.po.InspectionItem;
import cn.com.dhcc.cgn.mobins.pojo.pagging.Pagging;
import cn.com.dhcc.cgn.mobins.pojo.search.impl.InspectionItemSearchCondition;
import cn.com.dhcc.cgn.mobins.setting.service.InspectionItemService;

public class InspectionItemAction extends JQGridAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8729246390996798889L;
	@Autowired
	private InspectionItemService inspectionItemService = null;
	@Autowired
	private InspectionItemSearchCondition condition = null;
	
	public InspectionItemService getInspectionItemService() {
		return inspectionItemService;
	}
	public void setInspectionItemService(InspectionItemService inspectionItemService) {
		this.inspectionItemService = inspectionItemService;
	}
	public InspectionItemSearchCondition getCondition() {
		return condition;
	}
	public void setCondition(InspectionItemSearchCondition condition) {
		this.condition = condition;
	}
	
	private List<InspectionItem> listInspectionItem = null;
	
	
	public List<InspectionItem> getListInspectionItem() {
		return listInspectionItem;
	}
	public void setListInspectionItem(List<InspectionItem> listInspectionItem) {
		this.listInspectionItem = listInspectionItem;
	}
	private String strageID = null;
	
	public String getStrageID() {
		return strageID;
	}
	public void setStrageID(String strageID) {
		this.strageID = strageID;
	}
	public String list(){
		LOG.debug("查询策略巡检项目");
		Pagging pagging = condition.getPagging();
		pagging.setPage(this.getPage());
		pagging.setRows(this.getRows());
		condition.setStrageID(strageID);
		int records = inspectionItemService.count(condition);
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
		listInspectionItem = inspectionItemService.list(condition);
		return SUCCESS;
	}
}
