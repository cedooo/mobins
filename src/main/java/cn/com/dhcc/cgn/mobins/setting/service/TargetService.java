package cn.com.dhcc.cgn.mobins.setting.service;

import java.util.List;

import cn.com.dhcc.cgn.mobins.po.MobInsTarget;

public interface TargetService {
	/**
	 * 添加巡检目标
	 * @param target
	 * @return
	 */
	boolean addTarget(MobInsTarget target);
	/**
	 * 删除巡检目标
	 * @param target
	 * @return
	 */
	boolean delTarget(MobInsTarget target);
	/**
	 * 修改巡检目标
	 * @param target
	 * @return
	 */
	boolean modTarget(MobInsTarget target);
	/**
	 * 查找巡检目标
	 * @return
	 */
	List<MobInsTarget> query(MobInsTarget target);
	
}
