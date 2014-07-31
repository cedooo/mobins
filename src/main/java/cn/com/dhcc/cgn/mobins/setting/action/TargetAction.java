package cn.com.dhcc.cgn.mobins.setting.action;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.po.MobInsTarget;
import cn.com.dhcc.cgn.mobins.setting.service.TargetService;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 目标action
 * @author CeDo
 *
 */
public class TargetAction extends ActionSupport {

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
	

}
