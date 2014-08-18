package cn.com.dhcc.cgn.mobins.setting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.po.InspectionItem;
import cn.com.dhcc.cgn.mobins.pojo.search.impl.InspectionItemSearchCondition;
import cn.com.dhcc.cgn.mobins.setting.service.InspectionItemService;

public class InspectionItemServiceImpl implements InspectionItemService {

	@Override
	public List<InspectionItem> list(InspectionItemSearchCondition conditon) {
		List<InspectionItem> list = new ArrayList<InspectionItem>();
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			List<InspectionItem> li = session.selectList("cn.com.dhcc.cgn.mobins.po.InspectionItem.queryByCondition", conditon);
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
	public int count(InspectionItemSearchCondition conditon) {
		int cont = 0;
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			cont = (Integer)session.selectOne("cn.com.dhcc.cgn.mobins.po.InspectionItem.countByCondition", conditon);
			session.commit();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return cont;
	}

}
