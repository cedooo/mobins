package cn.com.dhcc.cgn.mobins.inspection.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandFormat {
	static final private String MEL_REGEX = ".*(\\$\\{([A-Za-z_]+)\\}).*";
	static final private String MEL_REGEX_SUB = "\\$\\{[A-Za-z_]+\\}";
	static final private String DATE_FORMAT_DOT = "yyyy.MM.dd";
	static final public String format(String cmds){
		if(cmds!=null){
			String rtCmds = cmds;
			Pattern pattern = Pattern.compile(MEL_REGEX);
			Matcher matcher = pattern.matcher(cmds);
			while(matcher.find()){
				String exp  = matcher.group(1);
				String expType = matcher.group(2);
				System.out.println(exp + "-" + expType);
				if(expType.equals("DATE_DOT")){
					SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DOT);
					String dateStr = sdf.format(new Date());
					rtCmds = cmds.replaceAll(MEL_REGEX_SUB, dateStr);
				}// else if.... 添加命令 变化的参数
			}
			return rtCmds;
		}else{
			return null;
		}
	};
	
}
