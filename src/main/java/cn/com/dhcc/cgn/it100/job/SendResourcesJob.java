package cn.com.dhcc.cgn.it100.job;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.it100.pojo.ITIMSResourceInfo;
import cn.com.dhcc.cgn.it100.webservice.impl.WebServiceImpl;

public class SendResourcesJob{
	
	public void execute() {
		
		SqlSession sess = DBFactoryBuilder.getSqlSessionFactory().openSession(true); 
		List<ITIMSResourceInfo> listResouceInfo = new ArrayList<ITIMSResourceInfo>();
		try{
			List<ITIMSResourceInfo> listResouceInfoDB = sess.selectList("cn.com.dhcc.cgn.it100.selectCMO");
			if(listResouceInfoDB!=null && listResouceInfoDB.size()>0){
				listResouceInfo.addAll(listResouceInfoDB);
			}
		}finally{
			if(sess!=null){
				sess.commit();
				sess.close();
			}
		}
		WebServiceImpl webServiceImpl = new WebServiceImpl();
		int result = webServiceImpl.sendAllResouceInfo(listResouceInfo);
System.out.println("发送所有网元设备信息：" + (result==1?"成功":(result==2?"部分成功":"失败")));
	}

}
