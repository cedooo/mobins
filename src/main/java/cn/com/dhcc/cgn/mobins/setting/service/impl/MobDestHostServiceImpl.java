package cn.com.dhcc.cgn.mobins.setting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.po.MobDestHost;
import cn.com.dhcc.cgn.mobins.pojo.search.impl.DestHostSearchCondition;
import cn.com.dhcc.cgn.mobins.setting.service.MobDestHostService;

public class MobDestHostServiceImpl implements MobDestHostService {

	@Override
	public boolean add(MobDestHost host) {
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			int inser = session.insert("cn.com.dhcc.cgn.mobins.po.MobDestHost.insert", host);
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
	public boolean del(MobDestHost host) {
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			int del = session.update("cn.com.dhcc.cgn.mobins.po.MobDestHost.del", host);
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
	public boolean mod(MobDestHost host) {
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			int upd = session.update("cn.com.dhcc.cgn.mobins.po.MobDestHost.userUpdate", host);
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
	public List<MobDestHost> query(MobDestHost host) {
		List<MobDestHost> list = new ArrayList<MobDestHost>();
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			List<MobDestHost> li = session.selectList("cn.com.dhcc.cgn.mobins.po.MobDestHost.query", host);
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
	public List<MobDestHost> listHostTarget(DestHostSearchCondition condition) {
		List<MobDestHost> list = new ArrayList<MobDestHost>();
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			List<MobDestHost> li = session.selectList("cn.com.dhcc.cgn.mobins.po.MobDestHost.queryByCondition", condition);
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
	public boolean updateAccountAndPassword(MobDestHost host) {
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			int upd = session.update("cn.com.dhcc.cgn.mobins.po.MobDestHost.updateAccountAndPassword", host);
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
	public boolean validHostInspect(MobDestHost host) {
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			int upd = session.update("cn.com.dhcc.cgn.mobins.po.MobDestHost.updateValid", host);
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
	public int count(DestHostSearchCondition searchCondition) {
		int cont = 0;
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			cont = (Integer)session.selectOne("cn.com.dhcc.cgn.mobins.po.MobDestHost.countByCondition", searchCondition);
			session.commit();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return cont;
	}

}
