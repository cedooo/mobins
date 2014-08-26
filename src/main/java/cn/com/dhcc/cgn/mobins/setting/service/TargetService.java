package cn.com.dhcc.cgn.mobins.setting.service;

import java.util.List;

import cn.com.dhcc.cgn.mobins.po.MobInsTarget;
import cn.com.dhcc.cgn.mobins.pojo.pagging.Pagging;

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
	/**
	 * 分页查找目标
	 * @param pagging
	 * @return
	 */
	List<MobInsTarget> listTarget(Pagging pagging);
	/**
	 * 修改巡检启用状态
	 * @param target
	 * @return
	 */
	boolean validTargetInspect(MobInsTarget target);
}
