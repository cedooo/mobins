package cn.com.dhcc.cgn.mobins.job.executor;

import java.util.List;
import java.util.Map;

import cn.com.dhcc.cgn.mobins.job.executor.result.ExecutorResult;
import cn.com.dhcc.cgn.mobins.po.HostInspectionPoint;

public interface CommandExecutor {

	/**
	 * 执行巡检
	 * @param list 巡检点
	 * @return 返回map的映射含义：<巡检点, 执行结果>
	 */
	Map<HostInspectionPoint, ExecutorResult> execute(List<HostInspectionPoint> list);
}
