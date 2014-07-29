package cn.com.dhcc.cgn.mobins.report.action;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.report.service.ReportService;

import com.opensymphony.xwork2.ActionSupport;

public class ReportAction  extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8970178348111114598L;
	@Autowired
	private ReportService reportService  = null;

	public ReportService getReportService() {
		return reportService;
	}

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	@Override 
	public String execute(){
		System.out.println(reportService.listReport());
		return SUCCESS;
	}
}
