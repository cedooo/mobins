package cn.com.dhcc.cgn.mobins.inspection.match.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.com.dhcc.cgn.mobins.inspection.dao.AnalysisInfo;
import cn.com.dhcc.cgn.mobins.inspection.match.ResultMatch;
import cn.com.dhcc.cgn.mobins.inspection.match.result.MatchResult;

/**
 * 关键字匹配
 * @author CeDo
 *
 */
public class ExpressMatch extends ResultMatch {

	@Override
	protected MatchResult doIt() {
		AnalysisInfo anaInfo = this.getAnalysisInfo();
		MatchResult result = new MatchResult();
		
		String regex = anaInfo.getKeyRegex();
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(anaInfo.getProtoData());
		
		if(anaInfo.getResultFormat()!=null){
			result.setCheckResult(String.format(anaInfo.getResultFormat(), anaInfo.getProtoData()));
		}
		if(matcher.matches()){
			result.setIsException(NORMAL);
		}else{
			result.setIsException(EXCEPTION);
		}
		result.setCheckComplete(true);
		return result;
	}

}
