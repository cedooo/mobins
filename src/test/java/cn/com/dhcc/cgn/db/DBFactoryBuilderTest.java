package cn.com.dhcc.cgn.db;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class DBFactoryBuilderTest {

	@Test
	public void testGetSqlSessionFactory() {
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession();
			session.commit();
			assertEquals(true, session!=null);
		}finally{
			if(session!=null){
				session.close();
			}
		}
		
	}

}
