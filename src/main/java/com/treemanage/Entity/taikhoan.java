package com.treemanage.Entity;

import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.jdbc.Blob;

public class taikhoan {
    private String taikhoan;
    private String matkhau;
	private String hotennv;
	private String ngaysinh;
	private String gioitinh;
	private String sdt;
	private String email;
	private String diachi;
	private String vaitro;
	private Blob hinhanh;
	private MultipartFile photo;
    public taikhoan() {
    	
    }
	public taikhoan(String taikhoan, String matkhau) {
		super();
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
	}

	public taikhoan(String taikhoan, String matkhau, String hotennv, String ngaysinh, String gioitinh, String sdt, String email, String diachi, String vaitro,Blob hinhanh) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		this.hotennv = hotennv;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.sdt = sdt;
		this.email = email;
		this.diachi = diachi;
		this.vaitro = vaitro;
		this.hinhanh=hinhanh;
	}

	public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
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

	public String getHotennv() {
		return this.hotennv;
	}

	public void setHotennv(String hotennv) {
		this.hotennv = hotennv;
	}

	public String getNgaysinh() {
		return this.ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getGioitinh() {
		return this.gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiachi() {
		return this.diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getVaitro() {
		return this.vaitro;
	}

	public void setVaitro(String vaitro) {
		this.vaitro = vaitro;
	}
	public Blob getHinhanh() {
		return this.hinhanh;
	}

	public void setHinhanh(Blob hinhanh) {
		this.hinhanh = hinhanh;
	}
	@Override
	public String toString() {
		return "taikhoan [taikhoan=" + taikhoan + ", matkhau=" + matkhau + ", hotennv=" + hotennv + ", ngaysinh="
				+ ngaysinh + ", gioitinh=" + gioitinh + ", sdt=" + sdt + ", email=" + email + ", diachi=" + diachi
				+ ", vaitro=" + vaitro + ", hinhanh=" + hinhanh + "]";
	}
	
    
	
	

    
}
