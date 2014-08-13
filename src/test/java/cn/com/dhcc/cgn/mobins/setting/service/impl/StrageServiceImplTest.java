package cn.com.dhcc.cgn.mobins.setting.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.po.InspectionStrage;
import cn.com.dhcc.cgn.mobins.setting.service.StrageService;

public class StrageServiceImplTest {

	private StrageService strageService = new StrageServiceImpl();
	@Test
	public void testList() {
		List<InspectionStrage> listStrage= strageService.list(null);
		System.out.println(listStrage);
		assertEquals(true, listStrage!=null);
	}

}
