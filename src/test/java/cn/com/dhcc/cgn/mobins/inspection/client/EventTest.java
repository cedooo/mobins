package cn.com.dhcc.cgn.mobins.inspection.client;

import static org.junit.Assert.*;

import org.junit.Test;

public class EventTest {

	@Test
	public void testParseRequestParam() {
		Event event = new Event();
		event.setMosn("998500272");
		event.setAddinfo("test");
		event.setCause("test111dsf");
		event.setDetail("test");
		event.setOccurtime("2014-09-01 15:20:00");
		event.setOrigininfo("test");
		event.setSeverity("4");
		event.setStatus("发生");
		String right = "mosn%3D998500272%26addinfo%3Dtest%26cause%3Dtest111dsf%26origininfo%3Dtest%26detail%3Dtest%26occurtime%3D2014-09-01%2015%3A20%3A00%26severity%3D4%26status%3D%25B7%25A2%25C9%25FA";
		System.out.println(event.parseRequestParam());
		System.out.println(right);
		assertEquals(true, right.equals(event.parseRequestParam()));
	}

}
