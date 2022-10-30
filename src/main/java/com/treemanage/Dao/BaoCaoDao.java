package com.treemanage.Dao;

import java.util.List;

import com.treemanage.Entity.BaoCao;

public interface BaoCaoDao {
    List<BaoCao> showList();
    int InsertRP(BaoCao baoCao);
    List<BaoCao> showListByContent(String content);
    List<BaoCao> findRPByID(int idRP);
    int removeReport(int id);
    List<BaoCao> searchRP(String key);
}
