package cn.com.dhcc.cgn.mobins.inspection.service;

public interface ReportAnalysisService {
	/**
	 * 扫描数据库中未解析的结果并解析，无法解析的记录删除。
	 * @return -1:未执行， 0:失败，1:成功， 2：部分成功
	 */
	int analysis();
}
