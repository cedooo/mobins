package cn.com.dhcc.cgn.mobins.setting.service;

import java.util.List;

import cn.com.dhcc.cgn.mobins.po.MobInsTarget;

public abstract class TargetService {
	/**
	 * 添加巡检目标
	 * @param target
	 * @return
	 */
	public abstract boolean addTarget(MobInsTarget target);
	/**
	 * 删除巡检目标
	 * @param target
	 * @return
	 */
	public abstract boolean delTarget(MobInsTarget target);
	/**
	 * 修改巡检目标
	 * @param target
	 * @return
	 */
	public abstract boolean modTarget(MobInsTarget target);
	/**
	 * 查找巡检目标
	 * @return
	 */
	public abstract List<MobInsTarget> query(MobInsTarget target);
	
}
