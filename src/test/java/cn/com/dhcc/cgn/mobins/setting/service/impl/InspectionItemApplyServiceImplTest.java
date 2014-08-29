package cn.com.dhcc.cgn.mobins.setting.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.po.InspectionItemApply;

public class InspectionItemApplyServiceImplTest {

	@Test
	public void testInspectionApply() {
		InspectionItemApplyServiceImpl srvImpl = new InspectionItemApplyServiceImpl();
		InspectionItemApply item = new InspectionItemApply();
		item.setInspectionItemID("8");
		item.setStrageID("1");
		boolean rt = srvImpl.inspectionApply(item, true);
		assertEquals(true, rt);
	}

}
