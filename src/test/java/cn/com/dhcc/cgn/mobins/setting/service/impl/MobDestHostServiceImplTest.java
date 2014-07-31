package cn.com.dhcc.cgn.mobins.setting.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.po.MobDestHost;

public class MobDestHostServiceImplTest {

	private MobDestHostServiceImpl serviceImpl = new MobDestHostServiceImpl();
	@Test
	public void testAdd() {
		MobDestHost host = new MobDestHost();
		host.setTargetID("1");
		host.setHostNote("XX服务器");
		host.setHostUser("root");
		host.setHostPasswd("root");
		host.setHostType("0");
		host.setMobDestHostIP("10.10.10.13");
		boolean addSucc = serviceImpl.add(host);
		assertEquals(true, addSucc);
	}

	@Test
	public void testDel() {
		MobDestHost host = new MobDestHost();
		host.setMobDestHostID("2");
		boolean delSucc = serviceImpl.del(host);
		assertEquals(true, delSucc);
	}

	@Test
	public void testMod() {
		MobDestHost host = new MobDestHost();
		host.setMobDestHostID("2");
		host.setTargetID("1");
		host.setHostNote("XX服务器xx");
		host.setHostUser("root");
		host.setHostPasswd("root");
		host.setHostType("0");
		host.setMobDestHostIP("10.10.111.13");
		boolean modSucc = serviceImpl.mod(host);
		assertEquals(true, modSucc);
	}

	@Test
	public void testQuery() {
		List<MobDestHost> list = serviceImpl.query(null);
		System.out.println(list);
	}

}
