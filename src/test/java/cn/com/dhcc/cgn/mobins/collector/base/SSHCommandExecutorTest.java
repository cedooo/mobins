package cn.com.dhcc.cgn.mobins.collector.base;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import cn.com.dhcc.cgn.mobins.collector.client.base.SSHCommandExecutor;

public class SSHCommandExecutorTest {

	@Test
	public void testExecute() {
		SSHCommandExecutor sshExecutor = new SSHCommandExecutor("192.168.1.118", "root", "g667259");
        sshExecutor.execute("ifconfig");
        
        Vector<String> stdout = sshExecutor.getStandardOutput();
        for (String str : stdout) {
            System.out.println(str);
        }
        assertEquals(true, stdout!=null && stdout.size()>0);
        sshExecutor.execute("pwd");
        stdout = sshExecutor.getStandardOutput();
        for (String str : stdout) {
            System.out.println(str);
        }
        assertEquals(true, stdout!=null && stdout.size()>0);
        sshExecutor.execute("ping baidu.com -c 5 -i 0.4");
        stdout = sshExecutor.getStandardOutput();
        for (String str : stdout) {
            System.out.println(str);
        }
        assertEquals(true, stdout!=null && stdout.size()>0);
	}

}
