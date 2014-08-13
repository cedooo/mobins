package cn.com.dhcc.cgn.mobins.setting.service;

import java.util.List;

import cn.com.dhcc.cgn.mobins.po.MobDestHost;
import cn.com.dhcc.cgn.mobins.po.MobInsTarget;

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

	/**
	 * 分页查找主机
	 * @param pagging
	 * @return
	 */
	List<MobDestHost> listHostTarget(MobInsTarget target);
	/**
	 * 修改主机巡检帐号密码
	 * @param host
	 * @return
	 */
	boolean updateAccountAndPassword(MobDestHost host);
}
