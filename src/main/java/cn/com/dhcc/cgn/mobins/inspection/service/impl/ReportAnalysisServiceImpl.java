package cn.com.dhcc.cgn.mobins.inspection.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.inspection.service.ReportAnalysisService;
import cn.com.dhcc.cgn.mobins.po.InspectionRecords;
import cn.com.dhcc.cgn.mobins.po.InspectionReport;

public class ReportAnalysisServiceImpl implements ReportAnalysisService {
	static final private Logger LOG = LoggerFactory.getLogger(ReportAnalysisServiceImpl.class.getClass());

	@Override
	public int analysis() {
		/**
		 * 查找状态为null的报告，查找结果，更新报告状态
		 */
		SqlSession session = null;
		LOG.info("解析未更新结果的报告"	);
		try {
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			List<InspectionReport> listReport = 
					session.selectList("cn.com.dhcc.cgn.mobins.inspection.service.ReportAnalysisService.queryReportUnInspection");
			for (InspectionReport inspectionReport : listReport) {
				//System.out.println(inspectionReport);
				String reportID = inspectionReport.getInspectionReportID();
				List<InspectionRecords> listRecord = 
						session.selectList("cn.com.dhcc.cgn.mobins.inspection.service.ReportAnalysisService.queryReportRecords", reportID);
				for (InspectionRecords inspectionRecords : listRecord) {
					System.out.println(inspectionRecords);
				}
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return 0;
	}

}
