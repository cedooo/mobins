package cn.com.dhcc.cgn.mobins.setting.service.impl;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.po.StrageApplyHost;
import cn.com.dhcc.cgn.mobins.setting.service.StrageApplyService;

public class StrageApplyServiceImpl implements StrageApplyService{

	@Override
	public boolean inspectionApply(StrageApplyHost strageApplyHost,
			boolean valid) {
		if(valid){
			SqlSession session = null;
			try{
				session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
				int upd = session.update("cn.com.dhcc.cgn.mobins.po.InspectionApply.updateStrageValid", strageApplyHost);
				session.commit();
				if(upd==1){
					return true;
				}else{
					int insertCount = session.update("cn.com.dhcc.cgn.mobins.po.InspectionApply.insertStrageValid", strageApplyHost);
					session.commit();
					if(insertCount==1){
						return true;
					}else{
						return false;
					}
				}
			}finally{
				if(session!=null){
					session.close();
				}
			}
		}else{
			SqlSession session = null;
			try{
				session = DBFactoryBuilder.getSqlSessionFactory().openSession(true);
				int upd = session.update("cn.com.dhcc.cgn.mobins.po.InspectionApply.updateStrageInvalid", strageApplyHost);
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

}
