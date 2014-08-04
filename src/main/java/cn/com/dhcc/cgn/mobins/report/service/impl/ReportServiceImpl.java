package cn.com.dhcc.cgn.mobins.report.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.po.HostInspectionPoint;
import cn.com.dhcc.cgn.mobins.po.InspectionReport;
import cn.com.dhcc.cgn.mobins.report.service.ReportService;

public class ReportServiceImpl implements ReportService{

	@Override
	public List<InspectionReport> listReportAll() {
		List<InspectionReport> list = new ArrayList<InspectionReport>();
		SqlSession session = null;
		try {
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			List<InspectionReport> li = session
					.selectList("cn.com.dhcc.cgn.mobins.po.InspectionReport.queryAll");
			if (li != null) {
				list.addAll(li);
			}
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public boolean addReport(InspectionReport report) {
		int addedCount = -1;
		SqlSession session = null;
		try {
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			addedCount = session
					.insert("cn.com.dhcc.cgn.mobins.po.InspectionReport.insert", report);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return addedCount==1;
	}

	public boolean addReport(HostInspectionPoint point) {
		InspectionReport report = new InspectionReport();
		report.setMobDestHostID(point.getMobDestHostID());
		report.setMaintAccount(point.getHostUser());
		report.setMaintUser(point.getHostUser());
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		report.setInspectionTime(time);
		return this.addReport(report);
	}
	
}
