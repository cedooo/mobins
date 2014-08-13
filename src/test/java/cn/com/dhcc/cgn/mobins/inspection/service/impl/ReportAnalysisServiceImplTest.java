package cn.com.dhcc.cgn.mobins.inspection.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReportAnalysisServiceImplTest {
	private ReportAnalysisServiceImpl service = new ReportAnalysisServiceImpl();
	@Test
	public void testAnalysis() {
		int is = service.analysis();
		assertEquals(true, is>=0);
	}

}
