package com.treemanage.Entity;

public class Phieu {
    private int maphieu;
    private String tenphieu;
    private String thoigian;
    private int soluong;
    private double tongtien;


    public Phieu() {
    }

    public Phieu(int maphieu) {
        this.maphieu = maphieu;
    }

    public Phieu(int maphieu, String tenphieu, String thoigian, int soluong, double tongtien) {
        this.maphieu = maphieu;
        this.tenphieu = tenphieu;
        this.thoigian = thoigian;
        this.soluong = soluong;
        this.tongtien = tongtien;
    }

    public int getMaphieu() {
        return this.maphieu;
    }

    public void setMaphieu(int maphieu) {
        this.maphieu = maphieu;
    }

    public String getTenphieu() {
        return this.tenphieu;
    }

    public void setTenphieu(String tenphieu) {
        this.tenphieu = tenphieu;
    }

    public String getThoigian() {
        return this.thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public int getSoluong() {
        return this.soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getTongtien() {
        return this.tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    @Override
    public String toString() {
        return "{" +
            " maphieu='" + getMaphieu() + "'" +
            ", tenphieu='" + getTenphieu() + "'" +
            ", thoigian='" + getThoigian() + "'" +
            ", soluong='" + getSoluong() + "'" +
            ", tongtien='" + getTongtien() + "'" +
            "}";
    }
}
