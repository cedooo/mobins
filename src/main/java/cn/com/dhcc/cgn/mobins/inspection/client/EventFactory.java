package cn.com.dhcc.cgn.mobins.inspection.client;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.po.InspectionRecords;
import cn.com.dhcc.cgn.mobins.pojo.ConstantsAndCommon;

public class EventFactory {
	private static final String MOB_APP_CODE = "mobileAppMosn";
	public static Event getMobAppEvent(){
		Event event = new Event();
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			String mosn = session.selectOne("cn.com.dhcc.cgn.mobins.inspection.wsclient.valueByKey", MOB_APP_CODE);
			if(mosn!=null){
				event.setMosn(mosn);
			}
			session.commit();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		if(event.getMosn()!=null){
			return event;
		}else{
			return null;
		}
	}
	/**
	 * 得到事件
	 * @param inspectionRecords
	 * @return
	 */
	public static Event getMobAppEvent(InspectionRecords inspectionRecords) {
		Event event = getMobAppEvent();
		if(event!=null){
			event.setSeverity(inspectionRecords.getRecordAlarmLevel());    //告警级别
			event.setOccurtime(ConstantsAndCommon.dateFormat.format(new Date()));    //告警发生时间
			event.setAddinfo("");    //附加信息
			event.setCause("巡检:" + inspectionRecords.getCheckItem());    //告警原因
			event.setDetail(inspectionRecords.getCheckResult());    //告警详情
			event.setOrigininfo(inspectionRecords.getProtoData());    //原始信息
			event.setStatus(Event.OCCUR);    //告警状态，发生/解除
		}
		return event;
	}
	public static void main(String[] args) {
		Event event = EventFactory.getMobAppEvent(null);
		System.out.println(event);
	}
}
