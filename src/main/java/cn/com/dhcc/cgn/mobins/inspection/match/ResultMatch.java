package cn.com.dhcc.cgn.mobins.inspection.match;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import cn.com.dhcc.cgn.mobins.inspection.dao.AnalysisInfo;
import cn.com.dhcc.cgn.mobins.inspection.match.result.MatchResult;

public abstract class ResultMatch {
	static final protected Logger LOG = LoggerFactory.getLogger(ResultMatch.class.getClass());
	static final public String LINE_SPLIT = "<br />";
	static final public String EXCEPTION = "异常";
	static final public String NORMAL = "正常";
	static final public String COMPLETE = "已完成";
	static final public String INSPECTIOIN_FAIL = "巡检失败";
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
