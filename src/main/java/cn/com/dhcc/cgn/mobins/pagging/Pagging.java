package cn.com.dhcc.cgn.mobins.pagging;
/**
 * 分页
 * @author CeDo
 *
 */
public class Pagging {
	private String page = null;
	private String total = null;
	private String records = null;
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getRecords() {
		return records;
	}
	public void setRecords(String records) {
		this.records = records;
	}
	
}
