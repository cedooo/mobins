package cn.com.dhcc.cgn.mobins.setting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.po.InspectionStrage;
import cn.com.dhcc.cgn.mobins.pojo.search.impl.StrageSearchCondition;
import cn.com.dhcc.cgn.mobins.setting.service.StrageService;

public class StrageServiceImpl implements StrageService {

	@Override
	public List<InspectionStrage> list(StrageSearchCondition condition) {
		List<InspectionStrage> list = new ArrayList<InspectionStrage>();
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			List<InspectionStrage> li = session.selectList("cn.com.dhcc.cgn.mobins.po.InspectionStrage.queryByCondition", condition);
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
	public int count(StrageSearchCondition conditon) {
		int cont = 0;
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			cont = (Integer)session.selectOne("cn.com.dhcc.cgn.mobins.po.InspectionStrage.countByCondition", conditon);
			session.commit();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return cont;
	}

}
