package cn.com.dhcc.cgn.mobins.collector.analysis;

import java.util.ArrayList;
import java.util.List;

import cn.com.dhcc.cgn.mobins.collector.analysis.rules.AnalysisRules;

/**
 * ������
 * @author CeDo
 *
 */
public abstract class Analysis {
	protected List<AnalysisRules> listRules = new ArrayList<AnalysisRules>();     //�������򼯺�

	public List<AnalysisRules> getListRules() {
		return listRules;
	}
	/**
	 * ��ӹ���
	 * @param rule
	 * @throws Exception
	 */
	public abstract void addRules(AnalysisRules rule) throws Exception;
	/**
	 * ��ӹ���
	 * @param list���򼯺�
	 * @throws Exception
	 */
	public void addAllRules(List<AnalysisRules> list) throws Exception{
		for (AnalysisRules analysisRules : list) {
			this.addRules(analysisRules);
		}
	}

	
}
