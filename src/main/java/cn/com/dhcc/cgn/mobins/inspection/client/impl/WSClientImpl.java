package cn.com.dhcc.cgn.mobins.inspection.client.impl;

import org.json.JSONObject;

import cn.com.dhcc.cgn.mobins.inspection.client.Event;
import cn.com.dhcc.cgn.mobins.inspection.client.IP10101333;
import cn.com.dhcc.cgn.mobins.inspection.client.WSClient;

public class WSClientImpl extends WSClient {

	@Override
	public String postAlarm(Event event) {
		// TODO Auto-generated method stub
		JSONObject jsonObj = new JSONObject(event);
		System.out.println(jsonObj.toString());
		IP10101333 webservice = new IP10101333();
		
		return null;
	}

}
