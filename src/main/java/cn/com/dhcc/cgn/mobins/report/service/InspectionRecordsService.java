package cn.com.dhcc.cgn.mobins.report.service;

import cn.com.dhcc.cgn.mobins.po.InspectionRecords;

public interface InspectionRecordsService {
	/**
	 * 添加巡检记录
	 * @param record
	 * @return
	 */
	boolean addInspectionRecord(InspectionRecords record);
}
