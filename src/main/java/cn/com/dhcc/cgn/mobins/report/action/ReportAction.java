package cn.com.dhcc.cgn.mobins.report.action;

import cn.com.dhcc.cgn.mobins.report.service.ReportService;
import cn.com.dhcc.cgn.mobins.report.service.impl.ReportServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class ReportAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8970178348111114598L;
	
	@Override 
	public String execute(){
		ReportService service = new ReportServiceImpl();
		return SUCCESS;
	}
}
