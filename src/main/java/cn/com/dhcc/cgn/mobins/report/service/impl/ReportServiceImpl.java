package cn.com.dhcc.cgn.mobins.report.service.impl;

import java.util.List;

import cn.com.dhcc.cgn.mobins.report.dao.InspectionReport;
import cn.com.dhcc.cgn.mobins.report.dao.InspectionReportDao;
import cn.com.dhcc.cgn.mobins.report.service.ReportService;

public class ReportServiceImpl extends ReportService{
	private InspectionReportDao dao = null;

	public InspectionReportDao getDao() {
		return dao;
	}

	public void setDao(InspectionReportDao dao) {
		this.dao = dao;
	}

	@Override
	public List<InspectionReport> listReport() {
		return dao.listReport();
	}
	
}
