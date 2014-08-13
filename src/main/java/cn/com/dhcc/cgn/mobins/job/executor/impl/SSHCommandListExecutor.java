package cn.com.dhcc.cgn.mobins.job.executor.impl;

import java.util.List;
import java.util.Map;

import cn.com.dhcc.cgn.mobins.job.executor.CommandExecutor;
import cn.com.dhcc.cgn.mobins.job.executor.jsch.ConnectResult;
import cn.com.dhcc.cgn.mobins.job.executor.jsch.JSchWrapper;
import cn.com.dhcc.cgn.mobins.job.executor.result.ExecutorResult;
import cn.com.dhcc.cgn.mobins.po.HostInspectionPoint;
import cn.com.dhcc.cgn.mobins.po.MobDestHost;

public class SSHCommandListExecutor implements  CommandExecutor{

	@Override
	public Map<HostInspectionPoint, ExecutorResult> execute(MobDestHost host,
			List<HostInspectionPoint> list) {
		JSchWrapper jsw = new JSchWrapper(host.getMobDestHostIP(), host.getHostUser(), host.getHostPasswd());
		Map<HostInspectionPoint, ExecutorResult> maps = jsw.executeCommands(list);
		return maps;
	}

	@Override
	public ConnectResult connectValid(MobDestHost host) {
		JSchWrapper jsw = new JSchWrapper(host.getMobDestHostIP(), host.getHostUser(), host.getHostPasswd());
		ConnectResult val = jsw.validate();
		return val;
	}

}
