package cn.com.dhcc.cgn.mobins.job.impl;

import java.util.List;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import cn.com.dhcc.cgn.mobins.inspection.service.HostInspectionPointService;
import cn.com.dhcc.cgn.mobins.job.InspectionJob;
import cn.com.dhcc.cgn.mobins.job.executor.CommandExecutor;
import cn.com.dhcc.cgn.mobins.po.HostInspectionPoint;
import cn.com.dhcc.cgn.mobins.po.InspectionRecords;
import cn.com.dhcc.cgn.mobins.po.InspectionReport;
import cn.com.dhcc.cgn.mobins.po.MobDestHost;
import cn.com.dhcc.cgn.mobins.report.service.InspectionRecordsService;
import cn.com.dhcc.cgn.mobins.report.service.ReportService;
import cn.com.dhcc.cgn.mobins.setting.service.MobDestHostService;

public class InspectionJobImpl implements InspectionJob{
	static final private Logger LOG = LoggerFactory.getLogger(InspectionJobImpl.class.getClass());
	
	private HostInspectionPointService hostInspectionPointService = null;
	private ReportService reportService = null;
	private InspectionRecordsService recordsService = null;
	private MobDestHostService mobHostService = null;
	
	private CommandExecutor commandExecutor = null;
	public HostInspectionPointService getHostInspectionPointService() {
		return hostInspectionPointService;
	}

	public void setHostInspectionPointService(
			HostInspectionPointService hostInspectionPointService) {
		this.hostInspectionPointService = hostInspectionPointService;
	}

	public ReportService getReportService() {
		return reportService;
	}

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	public InspectionRecordsService getRecordsService() {
		return recordsService;
	}

	public void setRecordsService(InspectionRecordsService recordsService) {
		this.recordsService = recordsService;
	}

	public MobDestHostService getMobHostService() {
		return mobHostService;
	}

	public void setMobHostService(MobDestHostService mobHostService) {
		this.mobHostService = mobHostService;
	}

	public CommandExecutor getCommandExecutor() {
		return commandExecutor;
	}

	public void setCommandExecutor(CommandExecutor commandExecutor) {
		this.commandExecutor = commandExecutor;
	}
	/**
	 * 
	 * 取得主机列表->遍历
	 * <br />遍历过程：执行巡检->生成报告头部->生成报告项目->结束
	 */
	@Override
	public void execute() {
		LOG.info("执行巡检任务");
		List<MobDestHost> listHost = mobHostService.query(null);
		for (MobDestHost mobDestHost : listHost) {
			InspectionReport report = generateReport(mobDestHost);
			reportService.addReport(report);
			List<HostInspectionPoint> list = hostInspectionPointService.getListAll();
			for (HostInspectionPoint hostInspectionPoint : list) {
				InspectionRecords record = generateInspectionRecord(hostInspectionPoint);
				recordsService.addInspectionRecord(record);
			}
		}
		
	}
	
	static private InspectionReport generateReport(MobDestHost host){
		return null;
	}
	
	static private InspectionRecords generateInspectionRecord(HostInspectionPoint hostPoint){
		return null;
	}

}
