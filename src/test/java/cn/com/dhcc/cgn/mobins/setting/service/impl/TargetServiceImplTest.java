package cn.com.dhcc.cgn.mobins.setting.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.po.MobInsTarget;
import cn.com.dhcc.cgn.mobins.setting.service.TargetService;

public class TargetServiceImplTest {

	TargetService service = new TargetServiceImpl();
	@Test
	public void testAddTarget() {
		MobInsTarget target = new MobInsTarget();
		target.setTargetName("测试添加");
		target.setTargetNote("测试添加备注");
		boolean addSucc = service.addTarget(target);
		assertEquals(true, addSucc);
	}

	@Test
	public void testModTarget() {
		MobInsTarget target = new MobInsTarget();
		target.setTargetID("1");
		target.setTargetName("测试添加-1");
		target.setTargetNote("测试添加备注-1");
		boolean modSucc = service.modTarget(target);
		assertEquals(true, modSucc);
	}
	
	@Test
	public void testDelTarget() {
		MobInsTarget target = new MobInsTarget();
		target.setTargetID("1");
		boolean delSucc = service.delTarget(target);
		assertEquals(true, delSucc);
	}

	@Test
	public void testQuery() {
		List<MobInsTarget> list = service.query(null);
		System.out.println(list);
	}

}
