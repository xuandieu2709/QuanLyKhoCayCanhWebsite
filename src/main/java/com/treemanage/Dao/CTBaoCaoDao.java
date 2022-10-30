package com.treemanage.Dao;

import java.util.List;

import com.treemanage.Entity.CTBaoCao;

public interface CTBaoCaoDao {
    List<CTBaoCao> findbyIdReport(int id);
    int InsertDeatailsRP(CTBaoCao ct);
    List<CTBaoCao> showListByIDReport(int idRP);
    int removeDetailsReport(int id);
}
