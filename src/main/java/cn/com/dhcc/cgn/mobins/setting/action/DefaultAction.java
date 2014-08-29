package cn.com.dhcc.cgn.mobins.setting.action;

public class DefaultAction extends JQGridAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3418999182679963406L;
	
	@Override
	public String execute(){
		return SUCCESS;
	}
	/**
	 * 巡检目标
	 * @return
	 */
	public String target(){
		return SUCCESS;
	}
	/**
	 * 策略
	 * @return
	 */
	public String strage(){
		return SUCCESS;
	}
	/**
	 * 策略应用
	 * @return
	 */
	public String strageApply(){
		return SUCCESS;
	}
}
