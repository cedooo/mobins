package cn.com.dhcc.cgn.mobins.report.service.impl;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.po.InspectionRecords;
import cn.com.dhcc.cgn.mobins.report.service.InspectionRecordsService;

public class InspectionRecordsServiceImpl implements InspectionRecordsService {

	@Override
	public boolean addInspectionRecord(InspectionRecords record) {
		int addedCount = -1;
		SqlSession session = null;
		try {
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			addedCount = session
					.insert("cn.com.dhcc.cgn.mobins.po.InspectionRecords.insert", record);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return addedCount==1;
	}

}
