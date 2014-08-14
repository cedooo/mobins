package cn.com.dhcc.cgn.mobins.inspection.match.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.com.dhcc.cgn.mobins.inspection.dao.AnalysisInfo;
import cn.com.dhcc.cgn.mobins.inspection.match.ResultMatch;
import cn.com.dhcc.cgn.mobins.inspection.match.result.MatchResult;

public class HAErrorMatch extends ResultMatch {

	@Override
	protected MatchResult doIt() {
		AnalysisInfo anaInfo = this.getAnalysisInfo();
		MatchResult result = new MatchResult();

		String data = null;
		String regex = null;
		if(anaInfo!= null){
			data = anaInfo.getProtoData();
			regex = anaInfo.getKeyRegex();
		}
		boolean valid = anaInfo!= null && regex!=null &&  data !=null;
		if(valid){
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(data);
			String rs = "";
			if(matcher.matches()){
				result.setCheckComplete(true);
				rs = "存在关键字";
				result.setIsException(EXCEPTION);
			}else{
				result.setCheckComplete(true);
				rs = "不存在关键字";
				result.setIsException(NORMAL);
			}
			if(anaInfo.getResultFormat()!=null){
				rs = String.format(anaInfo.getResultFormat(), rs);
			}
			result.setCheckResult(rs);
		}else{
			result.setCheckComplete(true);
			result.setIsException(EXCEPTION);
			result.setCheckResult("出现错误");
		}
		return result;
	}

}
