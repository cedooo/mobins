package cn.com.dhcc.cgn.mobins.inspection.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.po.HostInspectionPoint;
import cn.com.dhcc.cgn.mobins.po.MobDestHost;

public class HostInspectionPointServiceImplTest {

	private HostInspectionPointServiceImpl serviceImpl = new HostInspectionPointServiceImpl();
	@Test
	public void testGetList() {
		List<HostInspectionPoint> list = serviceImpl.getListAll();
		System.out.println(list);
		assertEquals(true, list!=null&&list.size()>0);
	}
	@Test
	public void getListByMobDestHost() {
		MobDestHost MHost = new MobDestHost();
		MHost.setMobDestHostID("3");
		List<HostInspectionPoint> list = serviceImpl.getListByMobDestHost(MHost);
		System.out.println(list);
		assertEquals(true, list!=null&&list.size()>0);
	}
}
