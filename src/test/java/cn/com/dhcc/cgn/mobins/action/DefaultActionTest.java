package cn.com.dhcc.cgn.mobins.action;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.commons.action.IndexAction;

public class DefaultActionTest {

	@Test
	public void testExecute() {
		IndexAction da = new IndexAction();
		assertEquals("success", da.execute());
	}

}
