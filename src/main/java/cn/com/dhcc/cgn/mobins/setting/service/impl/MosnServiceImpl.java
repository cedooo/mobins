package cn.com.dhcc.cgn.mobins.setting.service.impl;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.setting.service.MosnService;

public class MosnServiceImpl implements MosnService {

	@Override
	public boolean refreshMosn(String mosn) {
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			int upd = session.update("cn.com.dhcc.cgn.mobins.mosn.update", mosn);
			session.commit();
			if(upd==1){
				return true;
			}else{
				return false;
			}
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}

}
