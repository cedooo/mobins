package cn.com.dhcc.cgn.mobins.report.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.po.MobInsTarget;
import cn.com.dhcc.cgn.mobins.report.service.ReportService;

import com.opensymphony.xwork2.ActionSupport;

public class AllTargetAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6172722884090574576L;
	@Autowired
	private ReportService reportService  = null;

	private List<MobInsTarget> listTarget = new ArrayList<MobInsTarget>();
	
	public ReportService getReportService() {
		return reportService;
	}

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	public List<MobInsTarget> getListTarget() {
		return listTarget;
	}

	public void setListTarget(List<MobInsTarget> listTarget) {
		this.listTarget = listTarget;
	}

	@Override
	public String execute(){
		listTarget = reportService.listAllMobInsTarget();
		return SUCCESS;
	}

}
