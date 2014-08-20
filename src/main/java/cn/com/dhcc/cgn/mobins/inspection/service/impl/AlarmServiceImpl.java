package cn.com.dhcc.cgn.mobins.inspection.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.inspection.match.ResultMatch;
import cn.com.dhcc.cgn.mobins.inspection.service.AlarmService;
import cn.com.dhcc.cgn.mobins.inspection.service.impl.alarm.Alarm;
import cn.com.dhcc.cgn.mobins.po.InspectionRecords;
import cn.com.dhcc.cgn.mobins.po.InspectionReport;

public class AlarmServiceImpl extends AlarmService {

	@Override
	public void explore() {
		//告警扫描
		SqlSession session = null;
		try {
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			List<InspectionReport> listReport = session
					.selectList("cn.com.dhcc.cgn.mobins.inspection.service.AlarmService.uncheckReportList");
			LOG.info("巡检告警分析");
			session.commit();
			for (InspectionReport inspectionReport : listReport) {
				LOG.info(inspectionReport.toString());
				String reportID = inspectionReport.getInspectionReportID();
				List<InspectionRecords> listRecords = 
						session.selectList("cn.com.dhcc.cgn.mobins.po.InspectionReport.queryRecordsByReportID", reportID);
				InspectionReport upReport = new InspectionReport();
				upReport.setInspectionReportID(inspectionReport.getInspectionReportID());
				if(listRecords.size()>0){
					int excepCount = 0;
					for (InspectionRecords inspectionRecords : listRecords) {
						if(ResultMatch.EXCEPTION.equals(inspectionRecords.getIsException())){
							Alarm alarm = Alarm.parseAlarm(inspectionRecords);
							if(alarm!=null){
								LOG.info(alarm.toString());
								//TODO 异常入库
								excepCount++;
							}
						}
					}
					if(excepCount>0){
						upReport.setInspectionIsException(ResultMatch.EXCEPTION);
					}else{
						upReport.setInspectionIsException(ResultMatch.NORMAL);
					}
					upReport.setInspectionComplete(ResultMatch.COMPLETE);
				}else if(listRecords.size()==0){
					upReport.setInspectionIsException(ResultMatch.EXCEPTION);
					upReport.setInspectionComplete(ResultMatch.INSPECTIOIN_FAIL);
				}
				int uptedCnt = 
						session.update("cn.com.dhcc.cgn.mobins.inspection.service.AlarmService.updateReportStatus", upReport);
				if(uptedCnt==1){
					LOG.debug("巡检报告状态(正常/异常)更新成功");
				}else{
					LOG.info("巡检报告状态(正常/异常)更新失败:" + inspectionReport);
				}
				session.commit();
			}
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
