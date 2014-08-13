package cn.com.dhcc.cgn.mobins.setting.service;

import java.util.List;

import cn.com.dhcc.cgn.mobins.pagging.Pagging;
import cn.com.dhcc.cgn.mobins.po.InspectionStrage;

public interface StrageService {
	/**
	 * 巡检策略列表
	 * @return
	 */
	List<InspectionStrage> list(Pagging pagging);
}
