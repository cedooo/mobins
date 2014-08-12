package cn.com.dhcc.cgn.mobins.setting.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.po.MobDestHost;
import cn.com.dhcc.cgn.mobins.po.MobInsTarget;
import cn.com.dhcc.cgn.mobins.setting.service.MobDestHostService;

public class HostAction extends JQGridAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3767843588494001776L;
	@Autowired
	private MobDestHostService hostService = null;
	
	public MobDestHostService getHostService() {
		return hostService;
	}

	public void setHostService(MobDestHostService hostService) {
		this.hostService = hostService;
	}

	private List<MobDestHost> listHost = null;
	private String targetID = null;

	public List<MobDestHost> getListHost() {
		return listHost;
	}

	public void setListHost(List<MobDestHost> listHost) {
		this.listHost = listHost;
	}

	public String getTargetID() {
		return targetID;
	}

	public void setTargetID(String targetID) {
		this.targetID = targetID;
	}

	public String list(){
		MobInsTarget target = new MobInsTarget();
		target.setTargetID(targetID);
		this.listHost = hostService.listHostTarget(target);
		return SUCCESS;
	}

}
