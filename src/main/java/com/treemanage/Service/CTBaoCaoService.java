package com.treemanage.Service;

import java.util.List;

import com.treemanage.Entity.CTBaoCao;

public interface CTBaoCaoService {
    int InsertDeatailsRP(CTBaoCao ct);
    List<CTBaoCao> showListByIDReport(int idRP);
    int removeDetailsReport(int id);
}
