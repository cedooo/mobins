package cn.com.dhcc.cgn.mobins.setting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.mobins.db.DBResourcesBuilder;
import cn.com.dhcc.cgn.mobins.po.MobInsTarget;
import cn.com.dhcc.cgn.mobins.setting.service.TargetService;

public class TargetServiceImpl implements TargetService{

	@Override
	public boolean addTarget(MobInsTarget target) {
		SqlSession session = null;
		try{
			session = DBResourcesBuilder.getSqlSessionFactory().openSession(false);
			int inser = session.insert("cn.com.dhcc.cgn.mobins.po.MobInsTarget.insert", target);
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
	public boolean delTarget(MobInsTarget target) {
		SqlSession session = null;
		try{
			session = DBResourcesBuilder.getSqlSessionFactory().openSession(false);
			int del = session.update("cn.com.dhcc.cgn.mobins.po.MobInsTarget.del", target);
			session.commit();
			if(del==1){
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
	public boolean modTarget(MobInsTarget target) {
		SqlSession session = null;
		try{
			session = DBResourcesBuilder.getSqlSessionFactory().openSession(false);
			int upd = session.update("cn.com.dhcc.cgn.mobins.po.MobInsTarget.update", target);
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
	public List<MobInsTarget> query(MobInsTarget target) {
		List<MobInsTarget> list = new ArrayList<MobInsTarget>();
		SqlSession session = null;
		try{
			session = DBResourcesBuilder.getSqlSessionFactory().openSession(false);
			List<MobInsTarget> li = session.selectList("cn.com.dhcc.cgn.mobins.po.MobInsTarget.query", target);
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
