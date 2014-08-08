package cn.com.dhcc.cgn.mobins.inspection.match.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.com.dhcc.cgn.mobins.inspection.dao.AnalysisInfo;
import cn.com.dhcc.cgn.mobins.inspection.match.ResultMatch;
import cn.com.dhcc.cgn.mobins.inspection.match.result.MatchResult;
/**
 * 检测进程是否存在
 * @author CeDo
 *
 */
public class ProgressExistMatch extends ResultMatch{

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
			/*System.out.println(data + ":" + regex);
			System.err.println(matcher.matches());
System.err.println(matcher.group(1));*/
			if(matcher.matches() && gcount==1){
				String strcount = matcher.group(1);
				int pscount = -1;
				try{
					pscount = Integer.parseInt(strcount);
				}catch(NumberFormatException e){
				}
				String rs = "";
//System.err.println(pscount);
				if(pscount>0){
					result.setIsException(NORMAL);
					rs = "存在";
				}else if(pscount == 0){
					result.setIsException(EXCEPTION);
					rs = "不存在";
				}else if(pscount == 0){
					result.setIsException(EXCEPTION);
					rs = "巡检出现异常";
				}

				if(anaInfo.getResultFormat()!=null){
					rs = String.format(anaInfo.getResultFormat(), rs);
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
