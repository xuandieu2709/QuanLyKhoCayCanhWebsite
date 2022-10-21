package com.treemanage.Dao;

import java.util.List;

import com.treemanage.Entity.ChiTietPhieuXuat;

public interface CTPhieuXuatDao {
    List<ChiTietPhieuXuat> showList(int maphieuxuat);
    int insertDetailsTicket(ChiTietPhieuXuat chiTietPhieuXuat);
    int updateDetailsTicket(ChiTietPhieuXuat chiTietPhieuXuat);
    int deleteDetailsTicket(int id);
}
