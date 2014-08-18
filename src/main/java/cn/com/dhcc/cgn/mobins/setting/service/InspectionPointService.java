package cn.com.dhcc.cgn.mobins.setting.service;

import java.util.List;

import cn.com.dhcc.cgn.mobins.po.InspectionPoint;
import cn.com.dhcc.cgn.mobins.pojo.search.impl.InspectionPointSearchCondition;

public interface InspectionPointService {
	/**
	 * 巡检点列表
	 * @param conditon
	 * @return
	 */
	List<InspectionPoint> list(InspectionPointSearchCondition conditon);
	/**
	 * 个数
	 * @param conditon
	 * @return
	 */
	int count(InspectionPointSearchCondition conditon);
}
