package cn.com.dhcc.cgn.mobins.pojo.pagging;
/**
 * 分页
 * @author CeDo
 *
 */
public class Pagging {
	private String page = null;
	private String total = null;
	private String records = null;
	private String rows = null;
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
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public int getSkip(){
		int pagei = 1;
		int rowsi = 10;
		try{
			pagei = Integer.parseInt(page);
			rowsi = Integer.parseInt(rows);
		}catch(NumberFormatException e){
			
		}
		int skip = 0;
		skip = (pagei-1)*rowsi;
		return skip;
	}
	
	@Override
	public String toString() {
		return "Pagging [page=" + page + ", total=" + total + ", records="
				+ records + ", rows=" + rows + "]";
	}
	
}
