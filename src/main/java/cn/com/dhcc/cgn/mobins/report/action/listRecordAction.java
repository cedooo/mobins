package cn.com.dhcc.cgn.mobins.report.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.po.InspectionRecords;
import cn.com.dhcc.cgn.mobins.report.service.ReportService;

import com.opensymphony.xwork2.ActionSupport;

public class listRecordAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6172722884090574576L;
	@Autowired
	private ReportService reportService  = null;

	private List<InspectionRecords> listRecord = new ArrayList<InspectionRecords>();
	
	public ReportService getReportService() {
		return reportService;
	}

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	private String inspectionReportID = "0";

	public List<InspectionRecords> getListRecord() {
		return listRecord;
	}

	public void setListRecord(List<InspectionRecords> listRecord) {
		this.listRecord = listRecord;
	}

	public String getInspectionReportID() {
		return inspectionReportID;
	}

	public void setInspectionReportID(String inspectionReportID) {
		this.inspectionReportID = inspectionReportID;
	}

	@Override
	public String execute(){
		listRecord = reportService.listRecord(inspectionReportID);
		return SUCCESS;
	}

}
