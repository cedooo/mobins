package cn.com.dhcc.cgn.mobins.setting.service.impl;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.po.InspectionItemApply;
import cn.com.dhcc.cgn.mobins.setting.service.InspectionItemApplyService;

public class InspectionItemApplyServiceImpl implements
		InspectionItemApplyService {

	@Override
	public boolean inspectionApply(InspectionItemApply item, boolean valid) {
		if(valid){
			SqlSession session = null;
			try{
				session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
				int upd = session.update("cn.com.dhcc.cgn.mobins.po.InspectionApply.updateItemValid", item);
				session.commit();
				if(upd==1){
					return true;
				}else{
					int insertCount = session.update("cn.com.dhcc.cgn.mobins.po.InspectionApply.insertItemValid", item);
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
				int upd = session.update("cn.com.dhcc.cgn.mobins.po.InspectionApply.updateItemInvalid", item);
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
