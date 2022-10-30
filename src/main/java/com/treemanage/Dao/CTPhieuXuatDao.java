package com.treemanage.Dao;

import java.util.List;

import com.treemanage.Entity.ChiTietPhieuXuat;

public interface CTPhieuXuatDao {
    List<ChiTietPhieuXuat> FindByIDExport(int maphieuxuat);
    List<ChiTietPhieuXuat> showAllList();
    int insertDetailsTicket(ChiTietPhieuXuat chiTietPhieuXuat);
    int updateDetailsTicket(ChiTietPhieuXuat chiTietPhieuXuat);
    int deleteDetailsTicket(int id);
}
