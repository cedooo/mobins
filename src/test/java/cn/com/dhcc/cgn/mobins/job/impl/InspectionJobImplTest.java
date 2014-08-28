package cn.com.dhcc.cgn.mobins.job.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InspectionJobImplTest {

	@Test
	public void testExecute() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:inspectionJob.xml"); 
		int i = 0;
		while(i++<160){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(ac);
		assertEquals(true, ac!=null);
	}
	
}
