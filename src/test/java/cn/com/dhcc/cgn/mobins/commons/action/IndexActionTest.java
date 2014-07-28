package cn.com.dhcc.cgn.mobins.commons.action;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.commons.action.IndexAction;

public class IndexActionTest {

	@Test
	public void testExecute() {
		IndexAction da = new IndexAction();
		assertEquals("success", da.execute());
	}

}
