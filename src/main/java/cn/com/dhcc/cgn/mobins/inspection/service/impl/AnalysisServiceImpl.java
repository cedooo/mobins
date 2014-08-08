package cn.com.dhcc.cgn.mobins.inspection.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.inspection.dao.AnalysisInfo;
import cn.com.dhcc.cgn.mobins.inspection.match.ResultMatch;
import cn.com.dhcc.cgn.mobins.inspection.match.result.MatchResult;
import cn.com.dhcc.cgn.mobins.inspection.service.AnalysisService;

public class AnalysisServiceImpl implements AnalysisService {
	static final private Logger LOG = LoggerFactory.getLogger(AnalysisServiceImpl.class.getClass());
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:inspection-matches.xml"); 
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
			if (li != null) {
				list.addAll(li);
			}
			session.commit();
			LOG.info("解析个数: " + list.size());
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
						int updated = session.update("cn.com.dhcc.cgn.mobins.inspection.service.AnalysisService.updateResult", analysisInfo);
						session.commit();
						updatedCount += updated;
						if(updated==1){
							LOG.warn("更新成功:" + analysisInfo);
						}else{
							LOG.debug("更新失败");
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
		return rv;
	}
	
}
