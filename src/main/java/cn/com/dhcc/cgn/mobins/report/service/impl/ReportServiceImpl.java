package cn.com.dhcc.cgn.mobins.report.service.impl;

import java.util.List;

import cn.com.dhcc.cgn.mobins.report.dao.InspectionReport;
import cn.com.dhcc.cgn.mobins.report.service.ReportService;

public class ReportServiceImpl extends ReportService{

	@Override
	public List<InspectionReport> listReport() {
		return getDao().listReport();
	}
	
}
