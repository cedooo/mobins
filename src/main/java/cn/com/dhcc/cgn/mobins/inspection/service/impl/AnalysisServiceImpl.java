package cn.com.dhcc.cgn.mobins.inspection.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import cn.com.dhcc.cgn.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.inspection.dao.AnalysisInfo;
import cn.com.dhcc.cgn.mobins.inspection.match.ResultMatch;
import cn.com.dhcc.cgn.mobins.inspection.match.result.MatchResult;
import cn.com.dhcc.cgn.mobins.inspection.service.AnalysisService;
import cn.com.dhcc.cgn.mobins.po.InspectionAlarmHold;

public class AnalysisServiceImpl implements AnalysisService {
	static final private Logger LOG = LoggerFactory.getLogger(AnalysisServiceImpl.class.getClass());
	private static final ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:inspectionMatches.xml"); 
	@Override
	public int analysis() {
		List<AnalysisInfo> list = new ArrayList<AnalysisInfo>();
		SqlSession session = null;
		int rv = -1;
		int updatedCount = -1;
		try {
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			List<AnalysisInfo> li = session
					.selectList("cn.com.dhcc.cgn.mobins.inspection.service.AnalysisService.queryRecordsNoAnalysis");
			// 更新自定义阀值
			for (AnalysisInfo analysisInfo : li) {
				String holdStrageID = analysisInfo.getStrageID();
				String inspectionPointID = analysisInfo.getPointID();
				InspectionAlarmHold alarmHold = new InspectionAlarmHold();
				alarmHold.setInspectionPointID(inspectionPointID);
				alarmHold.setHoldStrageID(holdStrageID);
				//LOG.info("解析结果:策略ID=" + holdStrageID  +",巡检点ID = " + inspectionPointID);
				List<InspectionAlarmHold> listHold = session.selectList("cn.com.dhcc.cgn.mobins.po.InspectionPoint.selectAlarmHold", alarmHold);
				for (InspectionAlarmHold inspectionAlarmHold : listHold) {
					if(inspectionAlarmHold.getValueMax()!=null){
						analysisInfo.setValCompareMax(inspectionAlarmHold.getValueMax());
					}
					if(inspectionAlarmHold.getValueMin()!=null){
						analysisInfo.setValCompareMin(inspectionAlarmHold.getValueMin());
					}
					if(inspectionAlarmHold.getAlarmLevel()!=null){
						analysisInfo.setAlarmLevel(inspectionAlarmHold.getAlarmLevel());
					}
				}
			}
			if (li != null) {
				list.addAll(li);
			}
			session.commit();
			LOG.info("解析条数: " + list.size());
			/**
			 * 解析、入库
			 */
			for (AnalysisInfo analysisInfo : list) {
				String matchType = analysisInfo.getMatchType();
				ResultMatch match  = null;
				if(AnalysisInfo.MATCH_TYPE_EXPRESS.equals(matchType)){
					match = (ResultMatch) appContext.getBean("ExpressMatch");
				}else if(AnalysisInfo.MATCH_TYPE_RANGE.equals(matchType)){
					match = (ResultMatch) appContext.getBean("ValueRangeMatch");
				}else if(AnalysisInfo.MATCH_TYPE_MEMRATE.equals(matchType)){
					match = (ResultMatch) appContext.getBean("MemRateComputeMatch");
				}else if(AnalysisInfo.MATCH_TYPE_PROGRESS_CHECK.equals(matchType)){
					match = (ResultMatch) appContext.getBean("ProgressExistMatch");
				}else if(AnalysisInfo.MATCH_TYPE_SOLOMO_SWITCH.equals(matchType)){
					match = (ResultMatch) appContext.getBean("SolomonSwitchMatch");
				}else if(AnalysisInfo.MATCH_TYPE_PORGRESS_COUNT.equals(matchType)){
					match = (ResultMatch) appContext.getBean("ProgressCountMatch");
				}else if(AnalysisInfo.MATCH_TYPE_HA_ERROR.equals(matchType)){
					match = (ResultMatch) appContext.getBean("HAErrorMatch");
				}else if(AnalysisInfo.MATCH_TYPE_INT_RANGE.equals(matchType)){
					match = (ResultMatch) appContext.getBean("IntValueRangeMatch");
				}else{
					LOG.warn("巡检记录类型错误");
					continue;
				}
				if(match!=null){
					MatchResult result = match.execute(analysisInfo);
					LOG.info("解析结果:" + result);
					if(result!=null && result.isCheckComplete()){
						analysisInfo.setIsException(result.getIsException());
						analysisInfo.setCheckResult(result.getCheckResult());
						analysisInfo.setCheckComplete("1");
						int updated = session.update("cn.com.dhcc.cgn.mobins.inspection.service.AnalysisService.updateResult", analysisInfo);
						session.commit();
						updatedCount += updated;
						if(updated==1){
							LOG.info("更新成功:" + analysisInfo);
						}else{
							LOG.info("更新失败");
						}
					}else{
						LOG.info("未解析成功");
					}
				}
			}//for
		} finally {
			if (session != null) {
				session.close();
			}
		}
		if(updatedCount==0){
			rv = 0;
		}else if(updatedCount>0 && updatedCount < list.size()){
			rv = 2;
		}else if(updatedCount == list.size()){
			rv = 1;
		}
		LOG.info("更新成功[" + updatedCount + "/" + list.size() + "]条");
		return rv;
	}
	
}
