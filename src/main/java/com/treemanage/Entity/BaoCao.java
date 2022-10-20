package com.treemanage.Entity;

public class BaoCao {
    private int mabaocao;
    private String ngaybaocao;
    private String noidung;

    public BaoCao() {
    }

    public BaoCao(int mabaocao, String ngaybaocao, String noidung) {
        this.mabaocao = mabaocao;
        this.ngaybaocao = ngaybaocao;
        this.noidung = noidung;
    }


    public int getMabaocao() {
        return this.mabaocao;
    }

    public void setMabaocao(int mabaocao) {
        this.mabaocao = mabaocao;
    }

    public String getNgaybaocao() {
        return this.ngaybaocao;
    }

    public void setNgaybaocao(String ngaybaocao) {
        this.ngaybaocao = ngaybaocao;
    }

    public String getNoidung() {
        return this.noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    @Override
    public String toString() {
        return "{" +
            " mabaocao='" + getMabaocao() + "'" +
            ", ngaybaocao='" + getNgaybaocao() + "'" +
            ", noidung='" + getNoidung() + "'" +
            "}";
    }

}
