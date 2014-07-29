package cn.com.dhcc.cgn.mobins.db;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


public final class DBProxy {
	static final private Logger log = Logger.getLogger(DBProxy.class.getClass());
	static private SqlSessionFactory sqlSessionFactory;
	static private final String resource = "cn/com/dhcc/cgn/mobins/db/mybatis-config.xml";
	static{
		log.info("==============数据库连接初始化==============");
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			log.fatal("数据库连接初始化失败");
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
		log.info("数据库环境: " + conf.getEnvironment().getId());
		log.info("===========初始化完成===========");
	}
	private DBProxy(){}
	static public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}
