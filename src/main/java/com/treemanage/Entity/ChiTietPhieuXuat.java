package com.treemanage.Entity;

public class ChiTietPhieuXuat extends ChiTiet{

    public ChiTietPhieuXuat() {
    }
    public ChiTietPhieuXuat(int machitietxuat, int maphieuxuat, int macay, int soluong, double gia, double thanhtien,int slton) {
        super(machitietxuat, maphieuxuat, macay, soluong, gia, thanhtien);
        this.slton = slton;
    }
    public ChiTietPhieuXuat(int machitietxuat, int maphieuxuat, int macay, int soluong, double gia, double thanhtien) {
        super(machitietxuat, maphieuxuat, macay, soluong, gia, thanhtien);
      
    }
    public ChiTietPhieuXuat(int machitietxuat){
        super(machitietxuat);
    }
    private int slton;

    public int getSlton() {
        return this.slton;
    }

    public void setSlton(int slton) {
        this.slton = slton;
    }

    
}
