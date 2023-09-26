package in.achievers.dto;

public class Product {
	private long pid;
	private String pname;
	private double pprice;
	
	public long getPid() {
		return pid;
	}
	
	public void setPid(long pid) {
		this.pid = pid;
	}
	
	public String getPname() {
		return pname;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public double getPprice() {
		return pprice;
	}
	
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + "]";
	}
	
	
}
