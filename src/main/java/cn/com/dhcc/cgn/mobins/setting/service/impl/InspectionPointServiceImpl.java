package cn.com.dhcc.cgn.mobins.setting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.cgn.mobins.db.DBFactoryBuilder;
import cn.com.dhcc.cgn.mobins.po.InspectionAlarmHold;
import cn.com.dhcc.cgn.mobins.po.InspectionPoint;
import cn.com.dhcc.cgn.mobins.pojo.search.impl.InspectionPointSearchCondition;
import cn.com.dhcc.cgn.mobins.setting.service.InspectionPointService;

public class InspectionPointServiceImpl implements InspectionPointService{

	@Override
	public List<InspectionPoint> list(InspectionPointSearchCondition condition) {
		List<InspectionPoint> list = new ArrayList<InspectionPoint>();
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			List<InspectionPoint> li = session.selectList("cn.com.dhcc.cgn.mobins.po.InspectionPoint.queryByCondition", condition);
			//读取修改后的配置阀值
			for (InspectionPoint inspectionPoint : li) {
				String holdStrageID = condition.getInspectionStrageID();
				String inspectionPointID = inspectionPoint.getInspectionPointID();
				InspectionAlarmHold alarmHold = new InspectionAlarmHold();
				alarmHold.setInspectionPointID(inspectionPointID);
				alarmHold.setHoldStrageID(holdStrageID);
				List<InspectionAlarmHold> listHold = session.selectList("cn.com.dhcc.cgn.mobins.po.InspectionPoint.selectAlarmHold", alarmHold);
				for (InspectionAlarmHold inspectionAlarmHold : listHold) {
					if(inspectionAlarmHold.getValueMax()!=null){
						inspectionPoint.setValCompareMax(inspectionAlarmHold.getValueMax());
					}
					if(inspectionAlarmHold.getValueMin()!=null){
						inspectionPoint.setValCompareMin(inspectionAlarmHold.getValueMin());
					}
					if(inspectionAlarmHold.getAlarmLevel()!=null){
						inspectionPoint.setExceptionWeight(inspectionAlarmHold.getAlarmLevel());
					}
				}
			}
			if(li!=null){
				list.addAll(li);
			}
			session.commit();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return list;
	}

	@Override
	public int count(InspectionPointSearchCondition conditon) {
		int cont = 0;
		SqlSession session = null;
		try{
			session = DBFactoryBuilder.getSqlSessionFactory().openSession(false);
			cont = (Integer)session.selectOne("cn.com.dhcc.cgn.mobins.po.InspectionPoint.countByCondition", conditon);
			session.commit();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return cont;
	}
}
