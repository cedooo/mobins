package cn.com.dhcc.cgn.mobins.report.action;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReportActionTest {

	@Test
	public void testExecute() {
		ReportDefaultAction action = new ReportDefaultAction();
		String r = action.execute();
		assertEquals("success", r);
	}

}
