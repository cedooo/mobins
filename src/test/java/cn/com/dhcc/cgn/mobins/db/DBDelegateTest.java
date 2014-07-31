package cn.com.dhcc.cgn.mobins.db;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class DBDelegateTest {

	@Test
	public void testGetSqlSessionFactory() {
		SqlSession session = null;
		try{
			session = DBResourcesBuilder.getSqlSessionFactory().openSession();
			session.commit();
			assertEquals(true, session!=null);
		}finally{
			if(session!=null){
				session.close();
			}
		}
		
	}

}
