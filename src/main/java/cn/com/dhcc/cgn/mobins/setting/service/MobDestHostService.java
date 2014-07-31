package cn.com.dhcc.cgn.mobins.setting.service;

import java.util.List;

import cn.com.dhcc.cgn.mobins.po.MobDestHost;

public interface MobDestHostService {
	/**
	 * 添加主机
	 * @param host
	 * @return
	 */
	boolean add(MobDestHost host);
	/**
	 * 删除主机
	 * @param host
	 * @return
	 */
	boolean del(MobDestHost host);
	/**
	 * 修改主机
	 * @param host
	 * @return
	 */
	boolean mod(MobDestHost host);
	/**
	 * 查询主机
	 * @param host
	 * @return
	 */
	List<MobDestHost> query(MobDestHost host);
	
}
