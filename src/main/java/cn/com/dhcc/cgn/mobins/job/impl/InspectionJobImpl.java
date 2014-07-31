package cn.com.dhcc.cgn.mobins.job.impl;

import java.util.List;
import java.util.Map;

import cn.com.dhcc.cgn.mobins.inspection.service.HostInspectionPointService;
import cn.com.dhcc.cgn.mobins.job.InspectionJob;
import cn.com.dhcc.cgn.mobins.job.executor.CommandExecutor;
import cn.com.dhcc.cgn.mobins.job.executor.result.ExecutorResult;
import cn.com.dhcc.cgn.mobins.po.HostInspectionPoint;

public class InspectionJobImpl implements InspectionJob{
	
	private HostInspectionPointService hostInspectionPointService = null;
	private CommandExecutor commandExecutor = null;
	public HostInspectionPointService getHostInspectionPointService() {
		return hostInspectionPointService;
	}

	public void setHostInspectionPointService(
			HostInspectionPointService hostInspectionPointService) {
		this.hostInspectionPointService = hostInspectionPointService;
	}

	public CommandExecutor getCommandExecutor() {
		return commandExecutor;
	}

	public void setCommandExecutor(CommandExecutor commandExecutor) {
		this.commandExecutor = commandExecutor;
	}

	@Override
	public void execute() {
		System.out.println("执行巡检任务");
		List<HostInspectionPoint> list = hostInspectionPointService.getList();
		System.out.println("巡检点列表:" + list);
		Map<HostInspectionPoint, ExecutorResult> maps = commandExecutor.execute(list);
		System.out.println(maps);
		System.out.println("执行完成");
	}

}
