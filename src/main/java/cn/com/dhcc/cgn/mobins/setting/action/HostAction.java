package cn.com.dhcc.cgn.mobins.setting.action;

import java.util.List;

import cn.com.dhcc.cgn.mobins.po.MobDestHost;
import cn.com.dhcc.cgn.mobins.po.MobInsTarget;
import cn.com.dhcc.cgn.mobins.setting.service.MobDestHostService;

public class HostAction extends JQGridAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3767843588494001776L;
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


	@Override
	public String execute(){
		if(OPER_EDIT.equals(this.getOper())){
			return edit();
		}else if(OPER_DEL.equals(this.getOper())){
			return del();
		}else if(OPER_ADD.equals(this.getOper())){
			return add();
		}
		return SUCCESS;
	}

	private String mobDestHostID = null;
	private String mobDestHostIP = null;
	private String hostUser = null;
	private String hostNote = null;
	private String hostType = null;

	public String getMobDestHostID() {
		return mobDestHostID;
	}

	public void setMobDestHostID(String mobDestHostID) {
		this.mobDestHostID = mobDestHostID;
	}

	public String getMobDestHostIP() {
		return mobDestHostIP;
	}

	public void setMobDestHostIP(String mobDestHostIP) {
		this.mobDestHostIP = mobDestHostIP;
	}

	public String getHostUser() {
		return hostUser;
	}

	public void setHostUser(String hostUser) {
		this.hostUser = hostUser;
	}

	public String getHostNote() {
		return hostNote;
	}

	public void setHostNote(String hostNote) {
		this.hostNote = hostNote;
	}

	public String getHostType() {
		return hostType;
	}

	public void setHostType(String hostType) {
		this.hostType = hostType;
	}

	private String edit(){
		MobDestHost host = new MobDestHost();
		host.setMobDestHostID(mobDestHostID);
		host.setHostNote(hostNote);
		host.setHostType(hostType);
		//host.setHostUser(hostUser);
		host.setMobDestHostIP(mobDestHostIP);
		hostService.mod(host);
		return SUCCESS;
	}
	public String del(){
		MobDestHost host = new MobDestHost();
		host.setMobDestHostID(mobDestHostID);
		hostService.del(host);
		return SUCCESS;
	}

	private String hostPasswd = null;
	private String confirm_password = null;
	private String updateAPSuccess = null;
	public String getHostPasswd() {
		return hostPasswd;
	}

	public void setHostPasswd(String hostPasswd) {
		this.hostPasswd = hostPasswd;
	}
	
	public String getUpdateAPSuccess() {
		return updateAPSuccess;
	}

	public void setUpdateAPSuccess(String updateAPSuccess) {
		this.updateAPSuccess = updateAPSuccess;
	}

	public String updateAP(){
		MobDestHost host = new MobDestHost();
		host.setMobDestHostID(mobDestHostID);
		host.setHostUser(hostUser);
		host.setHostPasswd(hostPasswd);
		boolean updateSucc = hostService.updateAccountAndPassword(host);
		updateAPSuccess = updateSucc+"";
		return SUCCESS;
	}
	
	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	/**
	 * 添加主机
	 * @return
	 */
	private String add() {
		MobDestHost host = new MobDestHost();
		host.setTargetID(targetID);
		host.setHostNote(hostNote);
		host.setHostType(hostType);
		host.setHostUser(hostUser);
		host.setMobDestHostIP(mobDestHostIP);
		hostService.add(host);
		return SUCCESS;
	}
	private MobDestHost mobDestHost = null;
	
	public MobDestHost getMobDestHost() {
		return mobDestHost;
	}

	public void setMobDestHost(MobDestHost mobDestHost) {
		this.mobDestHost = mobDestHost;
	}
	
	private boolean operSuccess = false;
	
	public boolean isOperSuccess() {
		return operSuccess;
	}

	public void setOperSuccess(boolean operSuccess) {
		this.operSuccess = operSuccess;
	}

	public String validInpsect(){
		operSuccess = hostService.validHostInspect(mobDestHost);
		return SUCCESS;
	}
	
	
}
