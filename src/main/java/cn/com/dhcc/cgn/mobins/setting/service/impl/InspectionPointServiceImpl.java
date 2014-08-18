package cn.com.dhcc.cgn.mobins.setting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.po.InspectionPoint;
import cn.com.dhcc.cgn.mobins.pojo.search.impl.InspectionPointSearchCondition;
import cn.com.dhcc.cgn.mobins.setting.service.InspectionPointService;

public class InspectionPointServiceImpl implements InspectionPointService{

	@Override
	public List<InspectionPoint> list(InspectionPointSearchCondition condition) {
		List<InspectionPoint> list = new ArrayList<InspectionPoint>();
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			List<InspectionPoint> li = session.selectList("cn.com.dhcc.cgn.mobins.po.InspectionPoint.queryByCondition", condition);
			if(li!=null){
				list.addAll(li);
			}
			session.commit();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return list;
	}

	@Override
	public int count(InspectionPointSearchCondition conditon) {
		int cont = 0;
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			cont = (Integer)session.selectOne("cn.com.dhcc.cgn.mobins.po.InspectionPoint.countByCondition", conditon);
			session.commit();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return cont;
	}
}
