package cn.com.dhcc.cgn.mobins.inspection.client.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.inspection.client.Event;

public class WSClientImplTest {
	private WSClientImpl wsClient = new WSClientImpl();
	@Test
	public void testPostAlarm() {
		Event event = new Event();
		event.setMosn("998500130");
		event.setAddinfo("test");
		event.setCause("巡检-告警原因-测试，不用报。");
		event.setDetail("事件详细信息");
		event.setOccurtime("2014-08-26 15:54:37");
		event.setOrigininfo("事件详细信息");
		event.setSeverity("3");
		event.setStatus("发生");
		String rt = wsClient.postAlarm(event);
		assertEquals(true, rt=="success");
	}

}
