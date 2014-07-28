package cn.com.dhcc.cgn.mobins.db;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


public final class DBDelegate {
	static final private Logger log = Logger.getLogger(DBDelegate.class.getClass());
	static private SqlSessionFactory sqlSessionFactory;
	static private final String resource = "cn/com/dhcc/cgn/mobins/db/mybatis-config.xml";
	static{
		log.info("==============���ݿ����ӳ�ʼ��==============");
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			log.fatal("�ɼ����ݿ����ӳ����޷��ɼ���");
		}finally{
			if(inputStream!=null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		Configuration conf = sqlSessionFactory.getConfiguration();
		log.info("���ݿ⻷����" + conf.getEnvironment().getId());
		log.info("===========���ݿ����ӳ�ʼ��--��ɣ�===========");
	}
	private DBDelegate(){}
	static public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}
