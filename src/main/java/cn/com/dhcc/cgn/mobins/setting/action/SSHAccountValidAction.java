package cn.com.dhcc.cgn.mobins.setting.action;

import cn.com.dhcc.cgn.mobins.job.executor.jsch.ConnectResult;
import cn.com.dhcc.cgn.mobins.job.executor.jsch.JSchWrapper;

import com.opensymphony.xwork2.ActionSupport;

public class SSHAccountValidAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -687820238045491667L;

	private String mobDestHostIP = null;
	private String hostPasswd = null;
	private String hostUser = null;
	
	public String getMobDestHostIP() {
		return mobDestHostIP;
	}

	public void setMobDestHostIP(String mobDestHostIP) {
		this.mobDestHostIP = mobDestHostIP;
	}

	public String getHostPasswd() {
		return hostPasswd;
	}

	public void setHostPasswd(String hostPasswd) {
		this.hostPasswd = hostPasswd;
	}

	public String getHostUser() {
		return hostUser;
	}

	public void setHostUser(String hostUser) {
		this.hostUser = hostUser;
	}
	private ConnectResult result = null;

	public ConnectResult getResult() {
		return result;
	}

	public void setResult(ConnectResult result) {
		this.result = result;
	}

	public String execute(){
		JSchWrapper jsw = new JSchWrapper(this.mobDestHostIP, this.hostUser,this.hostPasswd);
		result = jsw.validate();
		return SUCCESS;
	}
}
