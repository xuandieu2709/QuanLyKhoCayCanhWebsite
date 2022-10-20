package com.treemanage.Entity;

public class NhaCungCap {
    private int manhacungcap;
    private String tennhacungcap;
    private String sodienthoai;
    private String email;
    private String diachi;
    private String ghichu;

    public NhaCungCap() {
    }
    
    public NhaCungCap(int manhacungcap, String tennhacungcap, String sodienthoai, String email, String diachi, String ghichu) {
        this.manhacungcap = manhacungcap;
        this.tennhacungcap = tennhacungcap;
        this.sodienthoai = sodienthoai;
        this.email = email;
        this.diachi = diachi;
        this.ghichu = ghichu;
    }


    public int getManhacungcap() {
        return this.manhacungcap;
    }

    public void setManhacungcap(int manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public String getTennhacungcap() {
        return this.tennhacungcap;
    }

    public void setTennhacungcap(String tennhacungcap) {
        this.tennhacungcap = tennhacungcap;
    }

    public String getSodienthoai() {
        return this.sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
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

    public String getGhichu() {
        return this.ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public String toString() {
        return "{" +
            " manhacungcap='" + getManhacungcap() + "'" +
            ", tennhacungcap='" + getTennhacungcap() + "'" +
            ", sodienthoai='" + getSodienthoai() + "'" +
            ", email='" + getEmail() + "'" +
            ", diachi='" + getDiachi() + "'" +
            ", ghichu='" + getGhichu() + "'" +
            "}";
    }

}
