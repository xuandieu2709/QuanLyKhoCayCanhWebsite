package com.treemanage.Entity;

public class ChiTietPhieuNhap extends ChiTiet{
    
    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(int machitietnhap, int maphieunhap, int manhacungcap, int macay, int soluong, double gia, double thanhtien) {
        super(machitietnhap, maphieunhap, manhacungcap, macay, soluong, gia, thanhtien);
    }

    public ChiTietPhieuNhap(int ma){
        super(ma);
    }

    public double caculatorPrice(){
        this.setThanhtien(this.getGia()*getSoluong()); 
        return this.getThanhtien();
    }
}
