package cn.com.dhcc.cgn.mobins.report.dao;

import java.util.List;

public interface InspectionReportDao {
	
	/**
	 * 得到所有报告
	 * @return
	 */
	public List<InspectionReport> listReport();
	
}
