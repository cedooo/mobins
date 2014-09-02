package cn.com.dhcc.cgn.mobins.inspection.client.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.inspection.client.Event;

public class WSClientImplTest {
	private WSClientImpl wsClient = new WSClientImpl();
	@Test
	public void testPostAlarm() {
		Event event = new Event();
		event.setMosn("998500272");
		event.setAddinfo("testcafe测试");
		event.setCause("移动应用巡检,告警原因,测试，不用报。");
		event.setDetail("事件详细信息 cafe");
		event.setOccurtime("2014-09-01 18:17:24");
		event.setOrigininfo("事件详细信息 cafe");
		event.setSeverity("4");
		event.setStatus(Event.CLEAR);
		String rt = wsClient.postAlarm(event);
		assertEquals(true, "".equals(rt));
	}
	//@Test
	public void testPostAlarm2() {
		Event event = new Event();
		event.setMosn("998500272");
		event.setAddinfo("test");
		event.setCause("test111dsf");
		event.setDetail("test");
		event.setOccurtime("2014-09-01 15:21:00");
		event.setOrigininfo("test");
		event.setSeverity("4");
		event.setStatus("发生");
		String rt = wsClient.postAlarm(event);
		assertEquals(true, "".equals(rt));
	}

}
