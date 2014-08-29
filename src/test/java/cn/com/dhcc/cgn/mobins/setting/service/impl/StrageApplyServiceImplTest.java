package cn.com.dhcc.cgn.mobins.setting.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.po.StrageApplyHost;

public class StrageApplyServiceImplTest {

	private StrageApplyServiceImpl srvImpl = new StrageApplyServiceImpl();
	private StrageApplyHost strageApplyHost = new StrageApplyHost();
	@Test
	public void testInspectionApply() {
		strageApplyHost.setStrageID("3");
		strageApplyHost.setMobDestHostID("17");
		assertEquals(true,srvImpl.inspectionApply(strageApplyHost, true));
		//assertEquals(true,srvImpl.inspectionApply(strageApplyHost, false));
	}

}
