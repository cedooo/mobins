package cn.com.dhcc.cgn.mobins.inspection.client.impl;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.ibatis.session.SqlSession;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.inspection.client.Event;
import cn.com.dhcc.cgn.mobins.inspection.client.WSClient;

public class WSClientImpl extends WSClient {
	static final private Logger LOG = LoggerFactory.getLogger(WSClientImpl.class.getClass());
	static private final String ALARM_URI_KEY = "alarmURI";
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
			LOG.info(event.toString());
			String queryParam = event.parseRequestParam();    
			LOG.info(queryParam);

			Client client = null;
			try{
			    ClientConfig config = new DefaultClientConfig();
				client = Client.create(config);
				client.setFollowRedirects(true);
				client.setConnectTimeout(TIME_OUT_INTERN);
				WebResource webRes = client.resource(BASE_URI);
				MultivaluedMap<String, String> mapMulti = new MultivaluedMapImpl();
				mapMulti.putSingle("params", queryParam);
				WebResource webResParam = webRes.queryParams(mapMulti);
				ClientResponse resCli = webResParam
						.type(MediaType.APPLICATION_XML_TYPE)
						.post(ClientResponse.class);
				
				if(resCli.getStatus() == 204){
					LOG.info("返回状态204: "  + resCli.getLanguage());
					LOG.info(resCli.toString());
				}else if(505 == resCli.getStatus()){
					LOG.info("告警入库错误:格式或参数错误");
				}
				LOG.info(webResParam.head().toString());
			}catch(UniformInterfaceException ue){
				ue.printStackTrace();
				LOG.info(ue.getMessage());
			}catch(Exception e ){
				LOG.info("告警入库异常:" + e);
				e.printStackTrace();
			}finally{
				if(client!=null){
					client.destroy();
				}
			}
		}else{
			response = "事件格式错误，告警无效.";
		}
		return response;
	}

}
