package cn.com.dhcc.cgn.mobins.report.service;

import java.util.List;

import cn.com.dhcc.cgn.mobins.po.InspectionReport;

public interface ReportService {
	/**
	 * 所有巡检报告
	 * @return
	 */
	List<InspectionReport> listReportAll();
	/**
	 * 添加巡检报告
	 * @param point
	 * @return
	 */
	boolean addReport(InspectionReport report);
}
