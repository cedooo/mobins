package cn.com.dhcc.cgn.mobins.report.service.impl;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.po.InspectionReport;

public class ReportServiceImplTest {
	private ReportServiceImpl serv = new ReportServiceImpl();
	@Test
	public void testListReportAll() {
		List<InspectionReport> list = serv.listReportAll();
		assertEquals(true, list!=null);
	}
	@Test
	public void testAddReport(){
		InspectionReport report = new InspectionReport();
		report.setMaintUser("root");
		report.setMaintAccount("root");
		report.setMobDestHostID("2");
		report.setInspectionIsException("N");
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		report.setInspectionTime(time);
		serv.addReport(report);
		System.out.println("报告ID = " + report.getInspectionReportID());
	}
}
