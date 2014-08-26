package cn.com.dhcc.cgn.mobins.inspection.client.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.inspection.client.Event;

public class WSClientImplTest {
	private WSClientImpl wsClient = new WSClientImpl();
	@Test
	public void testPostAlarm() {
		Event event = new Event();
		event.setMosn("9999");
		event.setAddinfo("test");
		event.setCause("告警原因");
		event.setDetail("事件详细信息");
		event.setOccurtime("2014-08-25 16:44:20");
		event.setOrigininfo("事件详细信息");
		event.setSeverity("3");
		event.setStatus("发生");
		String rt = wsClient.postAlarm(event);
		assertEquals(true, rt=="success");
	}

}
