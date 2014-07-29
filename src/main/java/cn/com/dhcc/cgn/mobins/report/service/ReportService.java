package cn.com.dhcc.cgn.mobins.report.service;

import java.util.List;

import cn.com.dhcc.cgn.mobins.report.dao.InspectionReport;
import cn.com.dhcc.cgn.mobins.report.dao.InspectionReportDao;

public abstract class ReportService {
	private InspectionReportDao dao = null;
	public InspectionReportDao getDao() {
		return dao;
	}
	public void setDao(InspectionReportDao dao) {
		this.dao = dao;
	}
	/**
	 * 所有巡检报告
	 * @return
	 */
	public abstract List<InspectionReport> listReport();
}
