package cn.com.dhcc.cgn.mobins.setting.service;

import cn.com.dhcc.cgn.mobins.po.InspectionItemApply;

public interface InspectionItemApplyService {
	/**
	 * 添加、删除巡检项
	 * @param item
	 * @return
	 */
	boolean inspectionApply(InspectionItemApply item, boolean valid);
}
