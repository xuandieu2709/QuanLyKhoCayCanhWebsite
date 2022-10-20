package com.treemanage.Entity;

public class taikhoan {
    private String taikhoan;
    private String matkhau;
    public taikhoan() {
    	
    }
	public taikhoan(String taikhoan, String matkhau) {
		super();
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
	}
	
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	@Override
	public String toString() {
		return "taikhoan [taikhoan=" + taikhoan + ", matkhau=" + matkhau + "]";
	}
    
}
