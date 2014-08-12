package cn.com.dhcc.cgn.mobins.setting.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.pagging.Pagging;
import cn.com.dhcc.cgn.mobins.po.MobInsTarget;
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
	@Autowired
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

	@Override
	public String execute(){
		return SUCCESS;
	}
	/**
	 * 添加目标
	 * @return
	 */
	public String add(){
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
		pagging.setPage("1");
		pagging.setRecords("20");
		pagging.setTotal("2");
		listTarget = targetService.listTarget(pagging);
		return SUCCESS;
	}
	
}
