package cn.com.dhcc.cgn.mobins.setting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.pagging.Pagging;
import cn.com.dhcc.cgn.mobins.po.InspectionStrage;
import cn.com.dhcc.cgn.mobins.setting.service.StrageService;

public class StrageServiceImpl implements StrageService {

	@Override
	public List<InspectionStrage> list(Pagging pagging) {
		List<InspectionStrage> list = new ArrayList<InspectionStrage>();
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			List<InspectionStrage> li = session.selectList("cn.com.dhcc.cgn.mobins.po.InspectionStrage.queryByPagging", pagging);
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
	
}
