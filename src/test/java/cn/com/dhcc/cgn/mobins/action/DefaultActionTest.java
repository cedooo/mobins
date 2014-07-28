package cn.com.dhcc.cgn.mobins.action;

import static org.junit.Assert.*;

import org.junit.Test;

public class DefaultActionTest {

	@Test
	public void testExecute() {
		DefaultAction da = new DefaultAction();
		assertEquals("success", da.execute());
	}

}
