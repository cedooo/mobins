package cn.com.dhcc.cgn.mobins.setting.service;

import cn.com.dhcc.cgn.mobins.po.StrageApplyHost;

public interface StrageApplyService {
	/**
	 * 添加删除 策略应用
	 * @param strageApplyHost
	 * @param b
	 * @return
	 */
	boolean inspectionApply(StrageApplyHost strageApplyHost, boolean valid);
	
}
