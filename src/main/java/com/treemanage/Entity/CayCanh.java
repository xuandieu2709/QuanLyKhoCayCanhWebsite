package com.treemanage.Entity;

public class CayCanh extends LoaiCay{
    private int macay;
    private String tencay;
    private double giacay;
    private int tonkho;
    private String hinhanh;
    private String mota;
    private String dvt;


    public CayCanh() {
    }

    public CayCanh(int macay, String tencay, double giacay, int tonkho, String hinhanh, String mota, String dvt) {
        this.macay = macay;
        this.tencay = tencay;
        this.giacay = giacay;
        this.tonkho = tonkho;
        this.hinhanh = hinhanh;
        this.mota = mota;
        this.dvt = dvt;
    }
    public CayCanh(int macay, String tencay, double giacay, int tonkho, String hinhanh, String mota, String dvt,int maloai) {
        super(maloai);
        this.macay = macay;
        this.tencay = tencay;
        this.giacay = giacay;
        this.tonkho = tonkho;
        this.hinhanh = hinhanh;
        this.mota = mota;
        this.dvt = dvt;
    }

    public int getMacay() {
        return this.macay;
    }

    public void setMacay(int macay) {
        this.macay = macay;
    }

    public String getTencay() {
        return this.tencay;
    }

    public void setTencay(String tencay) {
        this.tencay = tencay;
    }

    public double getGiacay() {
        return this.giacay;
    }

    public void setGiacay(double giacay) {
        this.giacay = giacay;
    }

    public int getTonkho() {
        return this.tonkho;
    }

    public void setTonkho(int tonkho) {
        this.tonkho = tonkho;
    }

    public String getHinhanh() {
        return this.hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getMota() {
        return this.mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getDvt() {
        return this.dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    @Override
    public String toString() {
        return "{" +
            " macay='" + getMacay() + "'" +
            ", tencay='" + getTencay() + "'" +
            ", giacay='" + getGiacay() + "'" +
            ", tonkho='" + getTonkho() + "'" +
            ", hinhanh='" + getHinhanh() + "'" +
            ", mota='" + getMota() + "'" +
            ", dvt='" + getDvt() + "'" +
            "}";
    }


    
}
