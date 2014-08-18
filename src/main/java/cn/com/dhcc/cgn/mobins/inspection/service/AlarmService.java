package cn.com.dhcc.cgn.mobins.inspection.service;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * 告警
 * @author CeDo
 *
 */
public abstract class AlarmService {
	static final protected Logger LOG = LoggerFactory.getLogger(AlarmService.class.getClass());
	/**
	 * 告警扫描
	 */
	public abstract void explore();
}
