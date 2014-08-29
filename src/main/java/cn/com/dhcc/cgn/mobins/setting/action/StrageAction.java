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
	/**
	 * 策略列表
	 * @return
	 */
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
	private String hostID = null;
	
	public String getHostID() {
		return hostID;
	}
	public void setHostID(String hostID) {
		this.hostID = hostID;
	}
	/**
	 * 根据hostid查找带有可用状态的巡检策略
	 * @return
	 */
	public String listWithHostApply(){
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
		strageSearchCondition.setHostID(hostID);
		listStrage = this.strageService.listWithHostApply(strageSearchCondition);
		return SUCCESS;
	}
	@Override
	public String execute(){
		if(OPER_EDIT.equals(this.getOper())){
			return edit();
		}else if(OPER_ADD.equals(this.getOper())){
			return add();
		}else if(OPER_DEL.equals(this.getOper())){
			return del();
		}
		return SUCCESS;
	}
	private String strageName = null;    //:目标巡检策略-测试
	private String strageNote = null;    //:添加测试用
	private String strageID = null;    //:1
	
	public String getStrageName() {
		return strageName;
	}
	public void setStrageName(String strageName) {
		this.strageName = strageName;
	}
	public String getStrageNote() {
		return strageNote;
	}
	public void setStrageNote(String strageNote) {
		this.strageNote = strageNote;
	}
	public String getStrageID() {
		return strageID;
	}
	public void setStrageID(String strageID) {
		this.strageID = strageID;
	}
	/**
	 * 编辑
	 * @return
	 */
	private String edit(){
		InspectionStrage strage = new InspectionStrage();
		strage.setStrageID(strageID);
		strage.setStrageName(strageName);
		strage.setStrageNote(strageNote);
		operSuccess = this.strageService.update(strage);
		return SUCCESS;
	}
	private String strageValid = null;
	
	public String getStrageValid() {
		return strageValid;
	}
	public void setStrageValid(String strageValid) {
		this.strageValid = strageValid;
	}
	/**
	 * 添加
	 * @return
	 */
	private String add(){
		InspectionStrage strage = new InspectionStrage();
		strage.setStrageName(strageName);
		strage.setStrageNote(strageNote);
		strage.setStrageValid(strageValid);
		this.operSuccess = strageService.add(strage);
		return SUCCESS;
	}
	private String del(){
		InspectionStrage strage = new InspectionStrage();
		strage.setStrageID(this.getId());
		this.operSuccess = strageService.del(strage);
		return SUCCESS;
	}
	private boolean operSuccess = false;
	
	public boolean isOperSuccess() {
		return operSuccess;
	}
	
	public void setOperSuccess(boolean operSuccess) {
		this.operSuccess = operSuccess;
	}

	private InspectionStrage strage = null;
	
	public InspectionStrage getStrage() {
		return strage;
	}
	public void setStrage(InspectionStrage strage) {
		this.strage = strage;
	}
	/**
	 * 巡检是否启用
	 * @return
	 */
	public String validIns(){
		operSuccess = strageService.validStrageInspect(strage);
		return SUCCESS;
	}
	
}
