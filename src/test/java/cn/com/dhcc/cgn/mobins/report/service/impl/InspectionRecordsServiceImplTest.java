package cn.com.dhcc.cgn.mobins.report.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.po.InspectionRecords;

public class InspectionRecordsServiceImplTest {
	InspectionRecordsServiceImpl service = new InspectionRecordsServiceImpl();
	@Test
	public void testAddInspectionRecord() {
		InspectionRecords record = new InspectionRecords();
		record.setInspectionReportID("669");
		record.setRecordAlarmLevel("4");
		assertEquals(true,service.addInspectionRecord(record));
	}

}
