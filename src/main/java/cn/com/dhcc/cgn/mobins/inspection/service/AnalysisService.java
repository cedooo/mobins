package cn.com.dhcc.cgn.mobins.inspection.service;
/**
 * 结果解析
 * @author CeDo
 *
 */
public interface AnalysisService {
	/**
	 * 扫描数据库中未解析的结果并解析，无法解析的记录删除。
	 * @return
	 */
	boolean analysis();
}
