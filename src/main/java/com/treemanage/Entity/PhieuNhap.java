package com.treemanage.Entity;

import java.util.List;

public class PhieuNhap extends Phieu{
    public List<ChiTietPhieuNhap> cTietPhieuNhaps;
    public PhieuNhap() {
    }

    public PhieuNhap(int maphieunhap,String tenphieu,String thoigiannhap, int soluong, double tongtien) {
        super(maphieunhap, tenphieu, thoigiannhap, soluong, tongtien);
    }
    public PhieuNhap(int ma){
        super(ma);
    }
    public PhieuNhap(int maphieunhap,String tenphieu,String thoigiannhap, int soluong, double tongtien, List<ChiTietPhieuNhap> cTietPhieuNhaps){
        super(maphieunhap, tenphieu, thoigiannhap, soluong, tongtien);
        this.cTietPhieuNhaps = cTietPhieuNhaps;
    }

    public PhieuNhap(List<ChiTietPhieuNhap> cTietPhieuNhaps){
        this.cTietPhieuNhaps = cTietPhieuNhaps;
    }

    public List<ChiTietPhieuNhap> getCTietPhieuNhaps() {
        return this.cTietPhieuNhaps;
    }

    public void setCTietPhieuNhaps(List<ChiTietPhieuNhap> cTietPhieuNhaps) {
        this.cTietPhieuNhaps = cTietPhieuNhaps;
    }

}
