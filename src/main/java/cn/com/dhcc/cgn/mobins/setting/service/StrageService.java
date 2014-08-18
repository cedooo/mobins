package cn.com.dhcc.cgn.mobins.setting.service;

import java.util.List;

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
}
