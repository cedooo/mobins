package cn.com.dhcc.cgn.mobins.inspection.service;

import java.util.List;

import cn.com.dhcc.cgn.mobins.po.HostInspectionPoint;
import cn.com.dhcc.cgn.mobins.po.MobDestHost;

public interface HostInspectionPointService {
	/**
	 * 得到巡检列表
	 * @return
	 */
	List<HostInspectionPoint> getListAll();

	List<HostInspectionPoint> getListByMobDestHost(MobDestHost host);
	
}
