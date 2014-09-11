package cn.com.dhcc.cgn.mobins.inspection.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.inspection.service.HostInspectionPointService;
import cn.com.dhcc.cgn.mobins.po.HostInspectionPoint;
import cn.com.dhcc.cgn.mobins.po.MobDestHost;

public class HostInspectionPointServiceImpl implements
		HostInspectionPointService {

	@Override
	public List<HostInspectionPoint> getListAll() {
		List<HostInspectionPoint> list = new ArrayList<HostInspectionPoint>();
		SqlSession session = null;
		try {
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			List<HostInspectionPoint> li = session
					.selectList("cn.com.dhcc.cgn.mobins.po.HostInspectionPoint.queryAll");
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
	public List<HostInspectionPoint> getListByMobDestHost(MobDestHost host) {
		List<HostInspectionPoint> list = new ArrayList<HostInspectionPoint>();
		SqlSession session = null;
		try {
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			List<HostInspectionPoint> li = session
					.selectList("cn.com.dhcc.cgn.mobins.po.HostInspectionPoint.queryByDestHost", host);
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

}
