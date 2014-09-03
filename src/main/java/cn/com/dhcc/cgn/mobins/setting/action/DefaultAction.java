package cn.com.dhcc.cgn.mobins.setting.action;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import cn.com.dhcc.cgn.mobins.setting.service.MosnService;

public class DefaultAction extends JQGridAction {
	static final private Logger LOG = LoggerFactory.getLogger(DefaultAction.class.getClass());

	/**
	 * 
	 */
	private static final long serialVersionUID = 3418999182679963406L;
	private String mosn=null;
	private MosnService mosnService = null;
	public String getMosn() {
		return mosn;
	}
	public void setMosn(String mosn) {
		this.mosn = mosn;
	}
	
	public MosnService getMosnService() {
		return mosnService;
	}
	public void setMosnService(MosnService mosnService) {
		this.mosnService = mosnService;
	}
	static final private String MOSN_REGEX = "^\\d{9}$";
	@Override
	public String execute(){
		if(mosn!=null && mosn.matches(MOSN_REGEX)){
			boolean refSucc = this.mosnService.refreshMosn(mosn);
			LOG.info("更新mosn: " + mosn + (refSucc?"[成功]":"[失败]"));
		}else{
			LOG.info("mosn = " + mosn + (mosn.matches(MOSN_REGEX)?"格式正确":"格式错误"));
		}
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
