package cn.com.dhcc.cgn.mobins.inspection.analysis;

import java.util.ArrayList;
import java.util.List;

import cn.com.dhcc.cgn.mobins.inspection.analysis.rules.AnalysisRules;


/**
 * 解析器
 * @author CeDo
 *
 */
public abstract class Analysis {
	protected List<AnalysisRules> listRules = new ArrayList<AnalysisRules>();     //�������򼯺�

	public List<AnalysisRules> getListRules() {
		return listRules;
	}
	/**
	 * 添加解析规则
	 * @param rule
	 * @throws Exception
	 */
	public abstract void addRules(AnalysisRules rule) throws Exception;
	/**
	 * 添加解析规则集合
	 * @param list 规则集合
	 * @throws Exception
	 */
	public void addAllRules(List<AnalysisRules> list) throws Exception{
		for (AnalysisRules analysisRules : list) {
			this.addRules(analysisRules);
		}
	}

	
}
