package cn.com.dhcc.cgn.mobins.job.executor.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import cn.com.dhcc.cgn.mobins.job.executor.CommandExecutor;
import cn.com.dhcc.cgn.mobins.job.executor.result.ExecutorResult;
import cn.com.dhcc.cgn.mobins.job.ssh.SSHCommandExecutor;
import cn.com.dhcc.cgn.mobins.po.HostInspectionPoint;

public class SSHCommandsExecutor implements CommandExecutor{

	@Override
	public Map<HostInspectionPoint, ExecutorResult> execute(
			List<HostInspectionPoint> list) {
		Map<HostInspectionPoint, ExecutorResult> maps = new HashMap<HostInspectionPoint, ExecutorResult>();
		for (HostInspectionPoint hostInspectionPoint : list) {
			SSHCommandExecutor sshExecutor = new SSHCommandExecutor(hostInspectionPoint.getMobDestHostIP(),
					hostInspectionPoint.getHostUser(), hostInspectionPoint.getHostPasswd());
	        sshExecutor.execute(hostInspectionPoint.getOperCommand());
	        
	        Vector<String> stdout = sshExecutor.getStandardOutput();
	        ExecutorResult result = new ExecutorResult();
	        result.setExecuteInfo("执行成功");
	        result.setResultVector(stdout);
	        maps.put(hostInspectionPoint, result);
	        
		}
		return maps;
	}
	
	
}
