package cn.com.dhcc.cgn.mobins.inspection.job.executor;

import java.util.List;
import java.util.Map;

import cn.com.dhcc.cgn.mobins.inspection.job.executor.jsch.ConnectResult;
import cn.com.dhcc.cgn.mobins.inspection.job.executor.result.ExecutorResult;
import cn.com.dhcc.cgn.mobins.po.HostInspectionPoint;
import cn.com.dhcc.cgn.mobins.po.MobDestHost;

public interface CommandExecutor {

	/**
	 * 执行巡检
	 * @param list 巡检点
	 * @return 返回map的映射含义：<巡检点, 执行结果>
	 */
	Map<HostInspectionPoint, ExecutorResult> execute(MobDestHost host, List<HostInspectionPoint> list);
	/**
	 * 连接测试
	 * @return
	 */
	ConnectResult connectValid(MobDestHost host);
}
