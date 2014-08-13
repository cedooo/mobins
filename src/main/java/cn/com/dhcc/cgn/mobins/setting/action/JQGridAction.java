package cn.com.dhcc.cgn.mobins.setting.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 适用于jqgrid查询的action
 * @author CeDo
 *
 */
public abstract class JQGridAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1820355085979018419L;
	static public final String OPER_EDIT = "edit";
	static public final String OPER_DEL = "del";
	static public final String OPER_ADD = "add";
	
	private String  id = null;
	private String _search = null;
	private String nd = null;
	private String page = null;
	private String rows = null;
	private String sidx = null;
	private String sord = null;
	private String nd_ = null;
	private String oper = null;
	private String filters = null;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String get_search() {
		return _search;
	}
	public void set_search(String _search) {
		this._search = _search;
	}
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	public String getNd_() {
		return nd_;
	}
	public void setNd_(String nd_) {
		this.nd_ = nd_;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public String getFilters() {
		return filters;
	}
	public void setFilters(String filters) {
		this.filters = filters;
	}
	
}
