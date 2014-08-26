package cn.com.dhcc.cgn.mobins.setting.action;

import java.util.List;

import cn.com.dhcc.cgn.mobins.po.MobInsTarget;
import cn.com.dhcc.cgn.mobins.pojo.pagging.Pagging;
import cn.com.dhcc.cgn.mobins.setting.service.TargetService;

/**
 * 目标action
 * @author CeDo
 *
 */
public class TargetAction extends JQGridAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 50302580215770880L;
	
	private TargetService targetService = null;
	
	public TargetService getTargetService() {
		return targetService;
	}

	public void setTargetService(TargetService targetService) {
		this.targetService = targetService;
	}

	private MobInsTarget target = null;
	
	public MobInsTarget getTarget() {
		return target;
	}

	public void setTarget(MobInsTarget target) {
		this.target = target;
	}

	/**
	 * 添加目标
	 * @return
	 */
	private String add(){
		MobInsTarget target = new MobInsTarget();
		target.setTargetName(targetName);
		target.setTargetNote(targetNote);
		boolean addSuccess = targetService.addTarget(target);
		if(addSuccess){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	private List<MobInsTarget> listTarget = null;
	private Pagging pagging = null;
	
	public List<MobInsTarget> getListTarget() {
		return listTarget;
	}

	public void setListTarget(List<MobInsTarget> listTarget) {
		this.listTarget = listTarget;
	}

	public Pagging getPagging() {
		return pagging;
	}

	public void setPagging(Pagging pagging) {
		this.pagging = pagging;
	}

	/**
	 * 巡检目标
	 * @return
	 */
	public String list(){
		pagging = new Pagging();
		listTarget = targetService.listTarget(pagging);
		return SUCCESS;
	}

	@Override
	public String execute(){
		if(OPER_EDIT.equals(this.getOper())){
			return edit();
		}else if(OPER_ADD.equals(this.getOper())){
			return add();
		}
		return SUCCESS;
	}
	private String targetID = null;
	private String targetName = null;
	private String targetNote = null;
	private String targetAddTime = null;

	public String getTargetID() {
		return targetID;
	}

	public void setTargetID(String targetID) {
		this.targetID = targetID;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getTargetNote() {
		return targetNote;
	}

	public void setTargetNote(String targetNote) {
		this.targetNote = targetNote;
	}

	public String getTargetAddTime() {
		return targetAddTime;
	}

	public void setTargetAddTime(String targetAddTime) {
		this.targetAddTime = targetAddTime;
	}
	/**
	 * 编辑目标
	 * @return
	 */
	private String edit() {
		MobInsTarget target = new MobInsTarget();
		target.setTargetID(this.getTargetID());
		target.setTargetName(this.getTargetName());
		target.setTargetNote(this.getTargetNote());
		targetService.modTarget(target);
		return SUCCESS;
	}
	
	private boolean operSuccess = false;
	
	public boolean isOperSuccess() {
		return operSuccess;
	}

	public void setOperSuccess(boolean operSuccess) {
		this.operSuccess = operSuccess;
	}
	/**
	 * 巡检是否启用
	 * @return
	 */
	public String validIns(){
		operSuccess = targetService.validTargetInspect(target);
		return SUCCESS;
	}
}
