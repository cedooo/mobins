package cn.com.dhcc.cgn.mobins.report.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.report.dao.InspectionReport;
import cn.com.dhcc.cgn.mobins.report.dao.InspectionReportDao;

public class InspectionReportDaoImplTest {

	@Test
	public void testListReport() {
		InspectionReportDao dao = new InspectionReportDaoImpl();
		List<InspectionReport> list = dao.listReport();
		for (InspectionReport inspectionReport : list) {
			System.out.println(inspectionReport);
		}
		assertEquals(true, list!=null);
	}

}
