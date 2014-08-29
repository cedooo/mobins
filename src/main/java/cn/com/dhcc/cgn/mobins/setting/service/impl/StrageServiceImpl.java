package cn.com.dhcc.cgn.mobins.setting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.inspection.job.impl.InspectionJobImpl;
import cn.com.dhcc.cgn.mobins.po.InspectionStrage;
import cn.com.dhcc.cgn.mobins.po.StrageApplyHost;
import cn.com.dhcc.cgn.mobins.pojo.search.impl.StrageSearchCondition;
import cn.com.dhcc.cgn.mobins.setting.service.StrageService;

public class StrageServiceImpl implements StrageService {
	static final private Logger LOG = LoggerFactory.getLogger(InspectionJobImpl.class.getClass());

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

	@Override
	public boolean update(InspectionStrage strage) {
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			int upd = session.update("cn.com.dhcc.cgn.mobins.po.InspectionStrage.update", strage);
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

	@Override
	public boolean validStrageInspect(InspectionStrage strage) {
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			int upd = session.update("cn.com.dhcc.cgn.mobins.po.InspectionStrage.updateValid", strage);
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

	@Override
	public boolean add(InspectionStrage strage) {
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			int inser = session.insert("cn.com.dhcc.cgn.mobins.po.InspectionStrage.insert", strage);
			session.commit();
			if(inser==1){
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

	@Override
	public boolean del(InspectionStrage strage) {
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			int upd = session.update("cn.com.dhcc.cgn.mobins.po.InspectionStrage.updateDelete", strage);
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

	@Override
	public List<InspectionStrage> listWithHostApply(
			StrageSearchCondition strageSearchCondition) {
		List<InspectionStrage> list = new ArrayList<InspectionStrage>();
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			List<InspectionStrage> li = session.selectList("cn.com.dhcc.cgn.mobins.po.InspectionStrage.queryByCondition", strageSearchCondition);
			StrageApplyHost strageApplyHost = new StrageApplyHost();
			strageApplyHost.setMobDestHostID(strageSearchCondition.getHostID());
			for (InspectionStrage inspectionStrage : li) {
				LOG.info(inspectionStrage.toString());
				strageApplyHost.setStrageID(inspectionStrage.getStrageID());
				LOG.info(strageApplyHost.toString());
				int count = session.selectOne("cn.com.dhcc.cgn.mobins.po.InspectionStrage.countApply", strageApplyHost);
				if(count==1){
					inspectionStrage.setHostApplyValid("true");
				}else{
					inspectionStrage.setHostApplyValid("false");
				}
			}
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
