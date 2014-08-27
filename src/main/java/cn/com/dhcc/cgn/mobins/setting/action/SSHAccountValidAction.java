package cn.com.dhcc.cgn.mobins.setting.action;

import cn.com.dhcc.cgn.mobins.inspection.job.executor.jsch.ConnectResult;
import cn.com.dhcc.cgn.mobins.inspection.job.executor.jsch.JSchWrapper;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class SSHAccountValidAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -687820238045491667L;
	static final private Logger LOG = LoggerFactory.getLogger(SSHAccountValidAction.class.getClass());

	private String mobDestHostIP = null;
	private String hostPasswd = null;
	private String hostUser = null;
	private String mobDestHostID = null;
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
	public String getMobDestHostID() {
		return mobDestHostID;
	}

	public void setMobDestHostID(String mobDestHostID) {
		this.mobDestHostID = mobDestHostID;
	}
	private ConnectResult result = null;

	public ConnectResult getResult() {
		return result;
	}

	public void setResult(ConnectResult result) {
		this.result = result;
	}
	
	public String execute(){
		LOG.info(this.mobDestHostIP+ this.hostUser + ", 密码：" + this.hostPasswd);
		JSchWrapper jsw = new JSchWrapper(this.mobDestHostIP, this.hostUser,this.hostPasswd);
		result = jsw.validate();
		return SUCCESS;
	}
}
