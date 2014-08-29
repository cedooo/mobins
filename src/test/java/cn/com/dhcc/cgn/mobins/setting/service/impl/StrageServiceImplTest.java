package cn.com.dhcc.cgn.mobins.setting.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.po.InspectionStrage;
import cn.com.dhcc.cgn.mobins.pojo.pagging.Pagging;
import cn.com.dhcc.cgn.mobins.pojo.search.impl.StrageSearchCondition;
import cn.com.dhcc.cgn.mobins.setting.service.StrageService;

public class StrageServiceImplTest {

	private StrageService strageService = new StrageServiceImpl();
	//@Test
	public void testList() {
		List<InspectionStrage> listStrage= strageService.list(null);
		System.out.println(listStrage);
		assertEquals(true, listStrage!=null);
	}
	@Test
	public void testListHost() {
		Pagging pagging = new Pagging();
		pagging.setPage("1");
		pagging.setRecords("10");
		pagging.setRows("10");
		pagging.setTotal("5");
		StrageSearchCondition strageSearchCondition = new StrageSearchCondition();
		strageSearchCondition.setPagging(pagging);
		strageSearchCondition.setHostID("20");
		List<InspectionStrage> listStrage= strageService.listWithHostApply(strageSearchCondition);
		System.out.println(listStrage.size());
		System.out.println(listStrage);
		assertEquals(true, listStrage!=null);
	}
}
