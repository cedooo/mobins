package cn.com.dhcc.cgn.mobins.inspection.match;

import cn.com.dhcc.cgn.mobins.inspection.dao.AnalysisInfo;
import cn.com.dhcc.cgn.mobins.inspection.match.result.MatchResult;

public abstract class ResultMatch {
	private AnalysisInfo analysisInfo = null;
	
	public AnalysisInfo getAnalysisInfo() {
		return analysisInfo;
	}

	public void setAnalysisInfo(AnalysisInfo analysisInfo) {
		this.analysisInfo = analysisInfo;
	}

	public MatchResult execute(AnalysisInfo analy){
		this.analysisInfo = analy;
		System.out.println("执行解析动作");
		return doIt();
	}
	
	protected  abstract MatchResult doIt();
}
