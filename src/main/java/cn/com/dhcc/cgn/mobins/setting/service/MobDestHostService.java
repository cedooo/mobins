package cn.com.dhcc.cgn.mobins.setting.service;

import java.util.List;

import cn.com.dhcc.cgn.mobins.po.MobDestHost;
import cn.com.dhcc.cgn.mobins.pojo.search.impl.DestHostSearchCondition;

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
	List<MobDestHost> listHostTarget(DestHostSearchCondition searchCondition);
	/**
	 * 修改主机巡检帐号密码
	 * @param host
	 * @return
	 */
	boolean updateAccountAndPassword(MobDestHost host);
	/**
	 * 修改巡检启用状态
	 * @param target
	 * @return
	 */
	boolean validHostInspect(MobDestHost host);
	/**
	 * 主机记录数
	 * @param searchCondition
	 * @return
	 */
	int count(DestHostSearchCondition searchCondition);
}
