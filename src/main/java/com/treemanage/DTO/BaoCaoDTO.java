package com.treemanage.DTO;

import java.util.List;

import com.treemanage.Entity.BaoCao;
import com.treemanage.Entity.CTBaoCao;
import com.treemanage.Entity.CayCanh;

public class BaoCaoDTO {
    private List<CTBaoCao> ctbaocaos;
    private BaoCao baocao;
    private List<CayCanh> caycanhs;


    public BaoCaoDTO() {
    }

    public BaoCaoDTO(List<CTBaoCao> ctbaocaos, BaoCao baocao) {
        this.ctbaocaos = ctbaocaos;
        this.baocao = baocao;
    }
    public BaoCaoDTO(List<CTBaoCao> ctbaocaos, List<CayCanh> caycanhs) {
        this.ctbaocaos = ctbaocaos;
        this.caycanhs = caycanhs;
    }

    public BaoCaoDTO(List<CTBaoCao> ctbaocaos, BaoCao baocao, List<CayCanh> caycanhs) {
        this.ctbaocaos = ctbaocaos;
        this.baocao = baocao;
        this.caycanhs = caycanhs;
    }

    public List<CTBaoCao> getCtbaocaos() {
        return this.ctbaocaos;
    }

    public void setCtbaocaos(List<CTBaoCao> ctbaocaos) {
        this.ctbaocaos = ctbaocaos;
    }

    public BaoCao getBaocao() {
        return this.baocao;
    }

    public void setBaocao(BaoCao baocao) {
        this.baocao = baocao;
    }

    public List<CayCanh> getCaycanhs() {
        return this.caycanhs;
    }

    public void setCaycanhs(List<CayCanh> caycanhs) {
        this.caycanhs = caycanhs;
    }


}
