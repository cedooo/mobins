package cn.com.dhcc.cgn.it100.job;

import org.junit.Test;

public class SendResourcesJobTest {

	@Test
	public void testExecute() {
		SendResourcesJob job = new SendResourcesJob();
		job.execute();
	}

}
