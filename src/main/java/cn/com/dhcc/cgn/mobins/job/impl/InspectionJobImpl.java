package cn.com.dhcc.cgn.mobins.job.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dhcc.cgn.mobins.inspection.service.HostInspectionPointService;
import cn.com.dhcc.cgn.mobins.job.InspectionJob;

public class InspectionJobImpl implements InspectionJob{
	
	@Autowired
	private HostInspectionPointService hostInspectionPointService = null;
	
	public HostInspectionPointService getHostInspectionPointService() {
		return hostInspectionPointService;
	}

	public void setHostInspectionPointService(
			HostInspectionPointService hostInspectionPointService) {
		this.hostInspectionPointService = hostInspectionPointService;
	}

	@Override
	public void execute() {
		
	}

}
