package com.treemanage.Entity;

public class LoaiCay {
    private int maloai;
    private String tenloai;


    public LoaiCay() {
    }


    public LoaiCay(int maloai, String tenloai) {
        this.maloai = maloai;
        this.tenloai = tenloai;
    }

    public LoaiCay(int maloai) {
        this.maloai = maloai;
    }
    


    @Override
    public String toString() {
        return "{" +
            " maloai='" + getMaloai() + "'" +
            ", tenloai='" + getTenloai() + "'" +
            "}";
    }


    public int getMaloai() {
        return this.maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return this.tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

}
