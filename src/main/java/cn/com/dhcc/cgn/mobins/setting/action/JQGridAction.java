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
	
	private String  id = null;
	private String _search = null;
	private String nd = null;
	private String page = null;
	private String rows = null;
	private String sidx = null;
	private String sord = null;
	private String nd_ = null;
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
	
}
