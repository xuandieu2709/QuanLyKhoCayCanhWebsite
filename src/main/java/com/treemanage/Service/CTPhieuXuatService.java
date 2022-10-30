package com.treemanage.Service;

import java.util.List;

import com.treemanage.Entity.ChiTietPhieuXuat;

public interface CTPhieuXuatService {
    List<ChiTietPhieuXuat> showAllList();
    int insertDetailsTicket(ChiTietPhieuXuat chiTietPhieuXuat);
    int updateDetailsTicket(ChiTietPhieuXuat chiTietPhieuXuat);
    int deleteDetailsTicket(int id);
    List<ChiTietPhieuXuat> FindByIDExport(int maphieuxuat);
    
}
