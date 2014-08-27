package cn.com.dhcc.cgn.mobins.inspection.client.impl;

import org.apache.ibatis.session.SqlSession;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.inspection.client.Event;
import cn.com.dhcc.cgn.mobins.inspection.client.WSClient;

public class WSClientImpl extends WSClient {
	static private final String ALARM_URI_KEY = "alarmURI";
	private static String BASE_URI = null;
	static{
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			BASE_URI = session.selectOne("cn.com.dhcc.cgn.mobins.inspection.wsclient.valueByKey", ALARM_URI_KEY);
			session.commit();
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}
	@Override
	public String postAlarm(Event event) {
		String queryParam = event.parseRequestParam();    //"mosn=998500130&addinfo=test&cause=test&origininfo=test&detail=test&occurtime=2014-08-26 17:22:53&severity=5&status=%B7%A2%C9%FA";
		System.out.println(queryParam);
		String response = null;
		System.out.println(BASE_URI);
		System.out.println(event);
		/*Client client = Client.create();
		WebResource webRes = client.resource(BASE_URI);
		WebResource webResParam = webRes.queryParam("params", queryParam);
		try{
			response = webResParam.post(String.class);
		}catch(UniformInterfaceException ue){
			System.out.println(ue.getMessage());
		}*/
		return response;
	}

}
