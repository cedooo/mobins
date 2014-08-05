package cn.com.dhcc.cgn.mobins.report.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.po.InspectionReport;
import cn.com.dhcc.cgn.mobins.report.service.ReportService;

import com.opensymphony.xwork2.ActionSupport;

public class ReportListAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6172722884090574576L;
	@Autowired
	private ReportService reportService  = null;

	private List<InspectionReport> listReport = new ArrayList<InspectionReport>();
	
	public ReportService getReportService() {
		return reportService;
	}

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	private String hostID = "0";
	private String formatDate = "";

	public List<InspectionReport> getListReport() {
		return listReport;
	}

	public void setListReport(List<InspectionReport> listReport) {
		this.listReport = listReport;
	}

	

	public String getHostID() {
		return hostID;
	}

	public void setHostID(String hostID) {
		this.hostID = hostID;
	}

	public String getFormatDate() {
		return formatDate;
	}

	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}

	@Override
	public String execute(){
		listReport = reportService.listReportByDate(hostID, formatDate);
		return SUCCESS;
	}

}
