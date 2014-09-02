package cn.com.dhcc.cgn.mobins.setting.service;

import java.util.List;

import cn.com.dhcc.cgn.mobins.po.InspectionAlarmHold;
import cn.com.dhcc.cgn.mobins.po.InspectionStrage;
import cn.com.dhcc.cgn.mobins.pojo.search.impl.StrageSearchCondition;

public interface StrageService {
	/**
	 * 巡检策略列表
	 * @param conditon 搜索条件
	 * @return
	 */
	List<InspectionStrage> list(StrageSearchCondition conditon);
	/**
	 * 查询总数
	 * @param conditon
	 * @return
	 */
	int count(StrageSearchCondition conditon);
	/**
	 * 更新策略
	 * 只限于名称、备注
	 * @param strage
	 * @return
	 */
	boolean update(InspectionStrage strage);
	/**
	 * 添加策略
	 * @param strage
	 * @return
	 */
	boolean add(InspectionStrage strage);
	/**
	 * 删除巡检策略
	 * @param strage
	 * @return
	 */
	boolean del(InspectionStrage strage);
	/**
	 * 修改巡检启用状态
	 * @param target
	 * @return
	 */
	boolean validStrageInspect(InspectionStrage strage);
	/**
	 * 根据主机，查找所有策略，以及策略应用情况
	 * @param strageSearchCondition
	 * @return
	 */
	List<InspectionStrage> listWithHostApply(
			StrageSearchCondition strageSearchCondition);
	/**
	 * 添加告警阀值设置
	 */
	boolean refreshAlarmHold(InspectionAlarmHold alarmHold);
}
