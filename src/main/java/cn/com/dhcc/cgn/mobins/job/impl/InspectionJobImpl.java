package cn.com.dhcc.cgn.mobins.job.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import cn.com.dhcc.cgn.mobins.inspection.service.AnalysisService;
import cn.com.dhcc.cgn.mobins.inspection.service.HostInspectionPointService;
import cn.com.dhcc.cgn.mobins.job.InspectionJob;
import cn.com.dhcc.cgn.mobins.job.executor.CommandExecutor;
import cn.com.dhcc.cgn.mobins.job.executor.jsch.ConnectResult;
import cn.com.dhcc.cgn.mobins.job.executor.result.ExecutorResult;
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
	private AnalysisService analysisService = null;
	private CommandExecutor commandExecutor = null;

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
			//执行巡检
			List<HostInspectionPoint> listHostPoint = hostInspectionPointService.getListByMobDestHost(mobDestHost);
			ConnectResult result = commandExecutor.connectValid(mobDestHost);
			if(result.isSuccess()){
				Map<HostInspectionPoint, ExecutorResult> resultsMap = commandExecutor.execute(mobDestHost, listHostPoint);
				LOG.debug("巡检点及结果: " + resultsMap);
				//生成报告头部
				InspectionReport report = generateReport(mobDestHost);
				boolean addReportSucc = reportService.addReport(report);
				LOG.debug(report + "");

				LOG.debug("添加巡检记录报告成功：id = " + report.getInspectionReportID());
				if(addReportSucc){
					//生成报告项目
					Iterator<Entry<HostInspectionPoint, ExecutorResult>> iterator = resultsMap.entrySet().iterator();
					while(iterator.hasNext()){
						Map.Entry<HostInspectionPoint, ExecutorResult> entry = iterator.next();
						HostInspectionPoint hostInspectionPoint = entry.getKey();
						InspectionRecords record = generateInspectionRecord(hostInspectionPoint);
						record.setInspectionReportID(report.getInspectionReportID());
						record.setProtoData(entry.getValue().getStrResultVector());
						recordsService.addInspectionRecord(record);
						LOG.info("添加成功：" + record);
					}
				}else{
					LOG.warn("巡检报告-报告头入库失败,巡检记录无法入库。");
				}
			}else{
				LOG.debug(result.toString());
			}
			
		}
		/**
		 * 结果解析
		 */
		int analysisResult = analysisService.analysis();
		//更新报告状态为已完成，记录巡检结果
		System.out.println("解析" + analysisResult);
	}
	/**
	 * 
	 * 根据主机信息生成报告
	 * @param host
	 * @return
	 */
	static private InspectionReport generateReport(MobDestHost host){
		InspectionReport report = new InspectionReport();
		report.setMaintAccount(host.getHostUser());
		report.setMaintUser(host.getHostUser());
		report.setMobDestHostID(host.getMobDestHostID());
		return report;
	}
	/**
	 * 根据主机巡检点生成巡检点巡检记录
	 * @param hostPoint
	 * @return
	 */
	static private InspectionRecords generateInspectionRecord(HostInspectionPoint hostPoint){
		InspectionRecords records = new InspectionRecords();
		records.setCheckCode(hostPoint.getInspectionCode());
		records.setCheckItem(hostPoint.getItemName());
		records.setCheckNote(hostPoint.getInspectionItemNote());
		
		records.setCheckItem(hostPoint.getItemName());
		records.setOperNote(hostPoint.getOperNote());
		records.setInspectionType(hostPoint.getInspectionType());
		records.setCheckPoint(hostPoint.getCheckPointName());
		return records;
	}
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

	public AnalysisService getAnalysisService() {
		return analysisService;
	}
	public void setAnalysisService(AnalysisService analysisService) {
		this.analysisService = analysisService;
	}
	public CommandExecutor getCommandExecutor() {
		return commandExecutor;
	}

	public void setCommandExecutor(CommandExecutor commandExecutor) {
		this.commandExecutor = commandExecutor;
	}

}
