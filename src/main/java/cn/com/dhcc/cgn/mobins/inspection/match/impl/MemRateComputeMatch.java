package cn.com.dhcc.cgn.mobins.inspection.match.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.com.dhcc.cgn.mobins.inspection.dao.AnalysisInfo;
import cn.com.dhcc.cgn.mobins.inspection.match.ResultMatch;
import cn.com.dhcc.cgn.mobins.inspection.match.result.MatchResult;
/**
 * 内存使用率计算 及 结果分析
 * @author CeDo
 *
 */
public class MemRateComputeMatch extends ResultMatch{

	@Override
	protected MatchResult doIt() {
		AnalysisInfo anaInfo = this.getAnalysisInfo();
		MatchResult result = new MatchResult();

		double memRate = -1d;
		double max = -1d;
		boolean isException = true;
		String data = null;
		String regex = null;
		if(anaInfo!= null){
			data = anaInfo.getProtoData();
			regex = anaInfo.getKeyRegex();
		}
		boolean valid = anaInfo!= null && regex!=null &&  data !=null;
		if(valid){
			Pattern pattern = Pattern.compile(regex);
			String[] dataArray = null;
			if(data.contains(LINE_SPLIT)){
				dataArray = data.split(LINE_SPLIT);
			}else{
				dataArray = new String[1];
				dataArray[0] = data;
			}
			for (String line : dataArray) {
				Matcher matcher = pattern.matcher(line);
				if(matcher.matches()){
					int count = matcher.groupCount();
					if(count==6){
						String total, 
						//used,
						free,
						//shared, 
						buffers, cached;
						total = matcher.group(1);
						//used = matcher.group(2);
						free = matcher.group(3);
						//shared = matcher.group(4);
						buffers = matcher.group(5);
						cached = matcher.group(6);
						try{
							int tot = Integer.parseInt(total);
							//int use = Integer.parseInt(total);
							int fre = Integer.parseInt(free);
							//int sha = Integer.parseInt(total);
							int buf = Integer.parseInt(buffers);
							int cac = Integer.parseInt(cached);
							memRate = 100d*(tot-fre-buf-cac)/tot;
							max = Double.parseDouble(anaInfo.getValCompareMax());
							if(memRate > 0 && memRate < max){
								isException = false;
							}else{
								isException = true;
							}
						}catch(NumberFormatException e){
							
						}
					}else{
						
					}
				}else{
					continue;
				}
			}
			String memRateStr = String.format("%.2f", memRate);
			if(memRate==-1){
				result.setCheckComplete(false);
			}else if(isException){
				result.setCheckComplete(true);
				result.setIsException(EXCEPTION);
				result.setCheckResult(String.format(anaInfo.getResultFormat(), memRateStr + "%, 超过" + max + "%."));
			}else if(!isException){
				result.setCheckComplete(true);
				result.setIsException(NORMAL);
				result.setCheckResult(String.format(anaInfo.getResultFormat(), memRateStr + "%, 在" + max + "%以下."));
			}
		}else{
			result.setCheckComplete(true);
			result.setIsException(EXCEPTION);
			result.setCheckResult("出现错误");
		}
		return result;
	}

}
