package cn.com.dhcc.cgn.mobins.inspection.client.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.ws.rs.core.MediaType;

import org.apache.ibatis.session.SqlSession;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.inspection.client.Event;
import cn.com.dhcc.cgn.mobins.inspection.client.WSClient;

public class WSClientImpl extends WSClient {
	static private final String ALARM_URI_KEY = "alarmURI";
	static private final String DEFAULT_ENCODE = "gbk";
	static private final int TIME_OUT_INTERN = 3000;
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
		String response = null;
		if(event!=null){
			String queryParam = event.parseRequestParam();    
			try {
				queryParam = URLEncoder.encode(queryParam, DEFAULT_ENCODE);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			try{
			    ClientConfig config = new DefaultClientConfig();
				Client client = Client.create(config);
				client.setFollowRedirects(true);
				client.setConnectTimeout(TIME_OUT_INTERN);
				WebResource webRes = client.resource(BASE_URI);
				WebResource webResParam = webRes.queryParam("params", queryParam);
				response = webResParam.accept(MediaType.APPLICATION_XML).post(String.class);
				System.out.println(webResParam.head());
			}catch(UniformInterfaceException ue){
				System.out.println(ue.getMessage());
			}catch(Exception e ){
				
			}
		}else{
			response = "事件格式错误，告警无效.";
		}
		return response;
	}

}
