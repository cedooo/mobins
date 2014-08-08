package cn.com.dhcc.cgn.mobins.inspection.match.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
			List<Double> inrangeList = new ArrayList<Double>();
			List<Double> outrangeList = new ArrayList<Double>();
			boolean exception = false;
			for (String str : dataArray) {
				LOG.debug("正则表达式：" + regex + ",匹配字符串：" + str);
				str = str.trim();
				Matcher matcher = pattern.matcher(str);
				if(matcher.matches()){
					int count = matcher.groupCount();
					inRange = false;
					for (int i = 1; i <= count; i++) {
						String matched = matcher.group(i);
						try{
							val = Double.parseDouble(matched);
							inRange = val>=range[0] && val<=range[1];
							if(inRange){
								inrangeList.add(val);
							}else{
								outrangeList.add(val);
								exception = true;
							}
						}catch(NumberFormatException e){}
					}
				}else{
					LOG.debug("正则表达式匹配失败");
				}
			}
			result.setIsException(exception?EXCEPTION:NORMAL);
			String inrangShow = inrangeList.size()>5?"[" + inrangeList.get(0) + ", " 
					+ inrangeList.get(1) + ", " + inrangeList.get(2) + ", " + inrangeList.get(3) +  ", ...]":inrangeList+"";
			String outrangShow = outrangeList.size()>5?"[" + outrangeList.get(0) + ", " 
					+ outrangeList.get(1) + ", " + outrangeList.get(2) + ", " + outrangeList.get(3)+  ", ...]":outrangeList+"";
			String checkResult = (inrangeList.size()>0?
						(inrangShow+"在范围" + Arrays.toString(range) + "内<br />"):"") + 
					(outrangeList.size()>0?
							(outrangShow+"在范围" + Arrays.toString(range) + "之外<br />"):"") ;
			if(anaInfo.getResultFormat()!=null){
				List<Double> listAll = new ArrayList<Double>();
				listAll.addAll(inrangeList);
				listAll.addAll(outrangeList);
				String allrangShow = listAll.size()>5?"[" + listAll.get(0) + ", " 
						+ listAll.get(1) + ", " + listAll.get(2) +  ", ...]":listAll+"";
				if( listAll.size()==1 ){
					allrangShow = listAll.get(0)+"";
				}
				checkResult = String.format(anaInfo.getResultFormat(), allrangShow, LINE_SPLIT + checkResult);
			}
			result.setCheckResult(checkResult);
			result.setCheckComplete(true);
		}else{
			LOG.debug("解析表达式为空");
		}
		return result;
	}
	
}
