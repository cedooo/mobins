package cn.com.dhcc.cgn.mobins.setting.service;

import java.util.List;

import cn.com.dhcc.cgn.mobins.po.InspectionItem;
import cn.com.dhcc.cgn.mobins.pojo.search.impl.InspectionItemSearchCondition;

public interface InspectionItemService {

	/**
	 * 巡检策略列表
	 * @return
	 */
	/**
	 * 巡检策略列表
	 * @param conditon 搜索条件
	 * @return
	 */
	List<InspectionItem> list(InspectionItemSearchCondition conditon);
	/**
	 * 查询总数
	 * @param conditon
	 * @return
	 */
	int count(InspectionItemSearchCondition conditon);
}
