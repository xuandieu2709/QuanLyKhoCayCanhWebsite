package com.treemanage.Service;

import java.util.List;

import com.treemanage.Entity.BaoCao;

public interface BaoCaoService {
    List<BaoCao> showList();
    int InsertRP(BaoCao baoCao);
    BaoCao FindReportByContent(String content);
    BaoCao findRPByID(int idRP);
    int removeReport(int id);
    List<BaoCao> searchRP(String key);
}
