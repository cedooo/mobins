package cn.com.dhcc.cgn.mobins.action;

import junit.framework.TestCase;

public class DefaultActionTest extends TestCase {

	public void testExecute() {
		DefaultAction da = new DefaultAction();
		assertEquals("success", da.execute());
	}

}