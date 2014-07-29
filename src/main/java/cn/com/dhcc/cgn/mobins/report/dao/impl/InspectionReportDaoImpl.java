package cn.com.dhcc.cgn.mobins.report.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.mobins.db.DBDelegate;
import cn.com.dhcc.cgn.mobins.report.dao.InspectionReport;
import cn.com.dhcc.cgn.mobins.report.dao.InspectionReportDao;

public class InspectionReportDaoImpl implements InspectionReportDao {

	@Override
	public List<InspectionReport> listReport() {
		List<InspectionReport> list = new ArrayList<InspectionReport>();
		SqlSession session = null;
		try{
			session = DBDelegate.getSqlSessionFactory().openSession();
			List<InspectionReport> listR = session.selectList("cn.com.dhcc.cgn.mobins.report.dao.InspectionReport.selectAll");
			if(listR!=null){
				list.addAll(listR);
			}
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return list;
	}

}
