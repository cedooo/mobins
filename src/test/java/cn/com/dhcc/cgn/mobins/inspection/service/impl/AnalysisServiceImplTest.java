package cn.com.dhcc.cgn.mobins.inspection.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnalysisServiceImplTest {
	private AnalysisServiceImpl service = new AnalysisServiceImpl();
	@Test
	public void testAnalysis() {
		int ana = service.analysis();
		System.out.println(ana);
		assertEquals(true, ana==1);
	}

}
