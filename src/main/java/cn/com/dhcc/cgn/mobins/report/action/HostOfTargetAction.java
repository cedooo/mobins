package cn.com.dhcc.cgn.mobins.report.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.po.MobDestHost;
import cn.com.dhcc.cgn.mobins.report.service.ReportService;

import com.opensymphony.xwork2.ActionSupport;

public class HostOfTargetAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6172722884090574576L;
	@Autowired
	private ReportService reportService  = null;

	private List<MobDestHost> listHost = new ArrayList<MobDestHost>();
	
	public ReportService getReportService() {
		return reportService;
	}

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	private String targetID = "0";

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

	@Override
	public String execute(){
		listHost = reportService.listMobDestHost(targetID);
		return SUCCESS;
	}

}
