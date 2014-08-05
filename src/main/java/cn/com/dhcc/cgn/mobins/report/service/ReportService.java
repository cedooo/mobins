package cn.com.dhcc.cgn.mobins.report.service;

import java.util.List;

import cn.com.dhcc.cgn.mobins.po.InspectionReport;
import cn.com.dhcc.cgn.mobins.po.MobDestHost;
import cn.com.dhcc.cgn.mobins.po.MobInsTarget;

public interface ReportService {
	/**
	 * 所有巡检报告
	 * @return
	 */
	List<InspectionReport> listReportAll();
	/**
	 * 添加巡检报告
	 * @param point
	 * @return
	 */
	boolean addReport(InspectionReport report);
	/**
	 * 所有巡检目标
	 * @return
	 */
	List<MobInsTarget> listAllMobInsTarget();
	/**
	 * 所有巡检目标主机
	 * @return
	 */
	List<MobDestHost> listMobDestHost(String targetID);
	/**
	 * 通过日期获得报告
	 * @param formatDate 格式化日期（如：2014-08-05 10:10:24)
	 * @return 报告信息
	 */
	List<InspectionReport> listReportByDate(String hostID, String formatDate);
	
}
