package cn.com.dhcc.cgn.mobins.report.service;

import java.util.List;

import cn.com.dhcc.cgn.mobins.report.dao.InspectionReport;

public abstract class ReportService {
	/**
	 * 所有巡检报告
	 * @return
	 */
	public abstract List<InspectionReport> listReport();
}
