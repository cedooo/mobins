package cn.com.dhcc.cgn.mobins.report.service.impl;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.po.InspectionReport;
import cn.com.dhcc.cgn.mobins.po.MobDestHost;
import cn.com.dhcc.cgn.mobins.po.MobInsTarget;

public class ReportServiceImplTest {
	private ReportServiceImpl serv = new ReportServiceImpl();
	@Test
	public void testListReportAll() {
		List<InspectionReport> list = serv.listReportAll();
		assertEquals(true, list!=null);
	}
	//@Test
	public void testAddReport(){
		InspectionReport report = new InspectionReport();
		report.setMaintUser("root");
		report.setMaintAccount("root");
		report.setMobDestHostID("3");
		report.setInspectionIsException("异常");
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		report.setInspectionTime(time);
		serv.addReport(report);
		System.out.println("报告ID = " + report.getInspectionReportID());
	}
	//@Test
	public void testAllMobInsTarget(){
		List<MobInsTarget> list = serv.listAllMobInsTarget();
		assertEquals(true, list!=null);
		System.out.println(list);
	}
	//@Test
	public void testMobDestHost(){
		String targetID = "1";
		List<MobDestHost> list = serv.listMobDestHost(targetID);
		assertEquals(true, list!=null);
		System.out.println(list);
	}

	//@Test
	public void testGetReportByDate(){
		String hostID = "3";
		String formatDate = "2014-08-05";
		List<InspectionReport> list = serv.listReportByDate(hostID, formatDate);
		assertEquals(true, list!=null);
		System.out.println(list);
	}
}
