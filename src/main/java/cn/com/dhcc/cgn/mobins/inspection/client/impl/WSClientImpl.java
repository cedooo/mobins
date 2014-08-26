package cn.com.dhcc.cgn.mobins.inspection.client.impl;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import cn.com.dhcc.cgn.mobins.inspection.client.Event;
import cn.com.dhcc.cgn.mobins.inspection.client.WSClient;

public class WSClientImpl extends WSClient {

	@Override
	public String postAlarm(Event event) {
		String queryParam = event.parseRequestParam();    //"mosn=998500130&addinfo=test&cause=test&origininfo=test&detail=test&occurtime=2014-08-26 17:22:53&severity=5&status=%B7%A2%C9%FA";
		System.out.println(queryParam);
		Client client = Client.create();
		WebResource webRes = client.resource("http://10.10.13.33:7981//event");
		WebResource webResParam = webRes.queryParam("params", queryParam);
		String response = null;
		/*try{
			response = webResParam.post(String.class);
		}catch(UniformInterfaceException ue){
			System.out.println(ue.getMessage());
		}*/
		return response;
	}

}
