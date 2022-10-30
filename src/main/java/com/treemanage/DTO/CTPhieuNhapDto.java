package com.treemanage.DTO;

import java.util.ArrayList;
import java.util.List;

import com.treemanage.Entity.ChiTietPhieuNhap;
import com.treemanage.Entity.PhieuNhap;

public class CTPhieuNhapDto {
    private List<ChiTietPhieuNhap> chiTietPhieuNhaps = new ArrayList<>();
    private PhieuNhap phieuNhap;
    public CTPhieuNhapDto() {
    } 

    public CTPhieuNhapDto(List<ChiTietPhieuNhap> chiTietPhieuNhaps) {
        this.chiTietPhieuNhaps = chiTietPhieuNhaps;
    }
    public CTPhieuNhapDto(List<ChiTietPhieuNhap> chiTietPhieuNhaps,PhieuNhap phieuNhap) {
        this.chiTietPhieuNhaps = chiTietPhieuNhaps;
        this.phieuNhap = phieuNhap;
    }

    public List<ChiTietPhieuNhap> getChiTietPhieuNhaps() {
        return this.chiTietPhieuNhaps;
    }
    public void setChiTietPhieuNhaps(List<ChiTietPhieuNhap> chiTietPhieuNhaps) {
        this.chiTietPhieuNhaps = chiTietPhieuNhaps;
    }
    public void addCT(ChiTietPhieuNhap ct){
        this.chiTietPhieuNhaps.add(ct);
    }
    public void addPhieu(PhieuNhap phieuNhap){
        this.phieuNhap = phieuNhap;
    }

    public PhieuNhap getPhieuNhap() {
        return this.phieuNhap;
    }

    public void setPhieuNhap(PhieuNhap phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    
    
    // public int sumNumberTotal(){
    //     int sl = 0;
    //     for(ChiTietPhieuNhap ct: this.chiTietPhieuNhaps){
    //         sl+=ct.getSoluong();
    //     }
    //     this.phieuNhap.setSoluong(sl);
    //     return this.phieuNhap.getSoluong();
    // }
    // public double sumPrice(){
    //     double price =0;
    //     for(ChiTietPhieuNhap ct: this.chiTietPhieuNhaps){
    //         price+=ct.getGia();
    //     }
    //     this.phieuNhap.setTongtien(price);
    //     return this.phieuNhap.getTongtien();
    // }

}
