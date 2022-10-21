package com.treemanage.Entity;

public class ChiTiet extends Phieu {
    private int machitiet;
    private int manhacungcap;
    private int macay;
    private int soluong;
    private double gia;
    private double thanhtien;

    public ChiTiet() {
    }

    public ChiTiet(int machitiet, int maphieu, int macay, int soluong, double gia, double thanhtien) {
        super(maphieu);
        this.machitiet = machitiet;
        this.macay = macay;
        this.soluong = soluong;
        this.gia = gia;
        this.thanhtien = thanhtien;
    }

    public ChiTiet(int machitiet, int maphieu, int manhacungcap, int macay, int soluong, double gia, double thanhtien) {
        super(maphieu);
        this.machitiet = machitiet;
        this.manhacungcap = manhacungcap;
        this.macay = macay;
        this.soluong = soluong;
        this.gia = gia;
        this.thanhtien = thanhtien;
    }

    public int getMachitiet() {
        return this.machitiet;
    }

    public void setMachitiet(int machitiet) {
        this.machitiet = machitiet;
    }

    public int getManhacungcap() {
        return this.manhacungcap;
    }

    public void setManhacungcap(int manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public int getMacay() {
        return this.macay;
    }

    public void setMacay(int macay) {
        this.macay = macay;
    }

    public int getSoluong() {
        return this.soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGia() {
        return this.gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getThanhtien() {
        return this.thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

}
