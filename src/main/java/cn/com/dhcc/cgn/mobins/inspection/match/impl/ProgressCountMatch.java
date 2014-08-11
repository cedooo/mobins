package cn.com.dhcc.cgn.mobins.inspection.match.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.com.dhcc.cgn.mobins.inspection.dao.AnalysisInfo;
import cn.com.dhcc.cgn.mobins.inspection.match.ResultMatch;
import cn.com.dhcc.cgn.mobins.inspection.match.result.MatchResult;
/**
 * 进程数量检查
 * @author CeDo
 *
 */
public class ProgressCountMatch extends ResultMatch {

	@Override
	protected MatchResult doIt() {
		AnalysisInfo anaInfo = this.getAnalysisInfo();
		MatchResult result = new MatchResult();
		
		String regex = anaInfo.getKeyRegex();
		String data = anaInfo.getProtoData();
		boolean valid = regex!=null && data!=null;
		if(valid){
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(data);
			int gcount = matcher.groupCount();
			if(matcher.matches() && gcount==1){
				String strcount = matcher.group(1);
				int pscount = -1;
				String strmax = anaInfo.getValCompareMax();
				double max = -1;
				try{
					pscount = Integer.parseInt(strcount);
					max = Double.parseDouble(strmax);
				}catch(NumberFormatException e){
				}
				String rs = "";
				if(pscount >=0 && pscount<=max){
					result.setIsException(NORMAL);
					rs = "，少于" + (int)max;
				}else if(pscount > max){
					result.setIsException(EXCEPTION);
					rs = "资源异常";
				}else if(pscount == -1){
					result.setIsException(EXCEPTION);
					rs = "巡检出现异常";
				}

				if(anaInfo.getResultFormat()!=null){
					rs = String.format(anaInfo.getResultFormat(),pscount, rs);
				}
				result.setCheckResult(rs);
			}else{
				result.setIsException(EXCEPTION);
				result.setCheckResult("数据错误");
			}
			result.setCheckComplete(true);
		}else{
			result.setCheckComplete(false);
			LOG.debug("数据或解析表达式为null");
		}
		return result;
	}

}
