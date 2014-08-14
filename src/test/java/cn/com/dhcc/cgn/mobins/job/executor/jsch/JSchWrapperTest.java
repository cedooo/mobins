package cn.com.dhcc.cgn.mobins.job.executor.jsch;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.job.executor.result.ExecutorResult;
import cn.com.dhcc.cgn.mobins.po.HostInspectionPoint;

public class JSchWrapperTest {

	//@Test
	public void testValidate() {
		JSchWrapper jsw = new JSchWrapper("122.10.119.173","root","9351af5064");
		ConnectResult val = jsw.validate();
		assertEquals(true, val!=null);
	}

	@Test
	public void testExecuteCommands() {
		JSchWrapper jsw = new JSchWrapper("122.10.119.173","root","9351af5064");
		List<HostInspectionPoint> listPoint = new ArrayList<HostInspectionPoint>();
		HostInspectionPoint insPoint = new HostInspectionPoint();
		insPoint.setOperCommand("ping baidu.com -c 5 -i 0.3");
		listPoint.add(insPoint);
		HostInspectionPoint ifPoint = new HostInspectionPoint();
		ifPoint.setOperCommand("ifconfig");
		listPoint.add(ifPoint);
		HostInspectionPoint pwdPoint = new HostInspectionPoint();
		pwdPoint.setOperCommand("grep -e 'error' /var/log/ha-log.log");
		listPoint.add(pwdPoint);
		Map<HostInspectionPoint, ExecutorResult> maps = jsw.executeCommands(listPoint);
		Iterator<Entry<HostInspectionPoint, ExecutorResult>> iterator = maps.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<HostInspectionPoint, ExecutorResult> entry = iterator.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		assertEquals(true, maps!=null);
	}

}
