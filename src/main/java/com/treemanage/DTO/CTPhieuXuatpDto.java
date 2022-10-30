package com.treemanage.DTO;

import java.util.ArrayList;
import java.util.List;

import com.treemanage.Entity.ChiTietPhieuXuat;
import com.treemanage.Entity.PhieuXuat;

public class CTPhieuXuatpDto {
    private List<ChiTietPhieuXuat> CTPhieuXuats = new ArrayList<>();
    private PhieuXuat PhieuXuat;

    private int tonkho;

    public CTPhieuXuatpDto() {

    }


    public CTPhieuXuatpDto(List<ChiTietPhieuXuat> CTPhieuXuats, PhieuXuat PhieuXuat) {
        this.CTPhieuXuats = CTPhieuXuats;
        this.PhieuXuat = PhieuXuat;
    }
    public CTPhieuXuatpDto(List<ChiTietPhieuXuat> CTPhieuXuats) {
        this.CTPhieuXuats = CTPhieuXuats;
    }

    public void addDetailsPhieu(ChiTietPhieuXuat ct){
        this.CTPhieuXuats.add(ct);
    }
    public void addPhieu(PhieuXuat phieu){
        this.PhieuXuat = phieu;
    }

    public List<ChiTietPhieuXuat> getCTPhieuXuats() {
        return this.CTPhieuXuats;
    }

    public void setCTPhieuXuats(List<ChiTietPhieuXuat> CTPhieuXuats) {
        this.CTPhieuXuats = CTPhieuXuats;
    }

    public PhieuXuat getPhieuXuat() {
        return this.PhieuXuat;
    }

    public void setPhieuXuat(PhieuXuat PhieuXuat) {
        this.PhieuXuat = PhieuXuat;
    }


}
