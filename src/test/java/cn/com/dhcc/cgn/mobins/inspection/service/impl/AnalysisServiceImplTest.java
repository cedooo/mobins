package cn.com.dhcc.cgn.mobins.inspection.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnalysisServiceImplTest {
	private AnalysisServiceImpl service = new AnalysisServiceImpl();
	@Test
	public void testAnalysis() {
		boolean ana = service.analysis();
		assertEquals(true, ana);
	}

}
