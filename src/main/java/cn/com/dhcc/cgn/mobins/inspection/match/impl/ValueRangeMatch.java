package cn.com.dhcc.cgn.mobins.inspection.match.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import cn.com.dhcc.cgn.mobins.inspection.dao.AnalysisInfo;
import cn.com.dhcc.cgn.mobins.inspection.match.ResultMatch;
import cn.com.dhcc.cgn.mobins.inspection.match.result.MatchResult;

/**
 * 取值范围匹配
 * @author CeDo
 *
 */
public class ValueRangeMatch extends ResultMatch{
	static final private Logger LOG = LoggerFactory.getLogger(ValueRangeMatch.class.getClass());
	static final public String LINE_SPLIT = "<br />";
	static final public String EXCEPTION = "异常";
	static final public String NORMAL = "正常";
	@Override
	protected MatchResult doIt() {
		AnalysisInfo anaInfo = this.getAnalysisInfo();
		MatchResult result = new MatchResult();
		
		if(anaInfo.getKeyRegex()!=null){
			String data = anaInfo.getProtoData();
			boolean inRange = false;
			double[] range = new double[2];
			double val = -1d;

			try{
				range[0] = Double.parseDouble(anaInfo.getValCompareMin());
				range[1] = Double.parseDouble(anaInfo.getValCompareMax());
			}catch (Exception e){
				
			}
			
			String[] dataArray = null;
			if(data.contains(LINE_SPLIT)){
				dataArray = data.split(LINE_SPLIT);
			}else{
				dataArray = new String[1];
				dataArray[0] = data;
			}
			String regex = anaInfo.getKeyRegex();
			Pattern pattern = Pattern.compile(regex);
			for (String str : dataArray) {
				LOG.debug("正则表达式：" + regex + ",匹配字符串：" + str);
				str = str.trim();
				Matcher matcher = pattern.matcher(str);
				//LOG.info(matcher.find() + "-" + matcher.matches() );
				if(matcher.matches()){
					int count = matcher.groupCount();
					inRange = false;
					for (int i = 1; i <= count; i++) {
						String matched = matcher.group(i);
						try{
							val = Double.parseDouble(matched);
							inRange = val>=range[0] && val<=range[1];
							if(result.getIsException()==null){
								if(inRange){
									result.setCheckResult(val + "在"  + (int)range[0] + "到" + (int)range[1] +  "之间");
									result.setIsException(NORMAL);
								}else{
									result.setCheckResult(val + "超超出"  + (int)range[0] + "到" + (int)range[1] +  "范围");
									result.setIsException(EXCEPTION);
								}
							}else{
								if(inRange){
									result.setCheckResult(result.getCheckResult() + LINE_SPLIT + 
											val + "在"  + (int)range[0] + "到" + (int)range[1] +  "之间");
								}else{
									result.setCheckResult(result.getCheckResult() + LINE_SPLIT + 
											val + "超超出"  + (int)range[0] + "到" + (int)range[1] +  "范围");
									result.setIsException(EXCEPTION);
								}
							}
						}catch(NumberFormatException e){}
					}
				}else{
					LOG.debug("正则表达式匹配失败");
				}
			}
			result.setCheckComplete(true);
		}else{
			LOG.debug("解析表达式为空");
		}
		return result;
	}
	
}
