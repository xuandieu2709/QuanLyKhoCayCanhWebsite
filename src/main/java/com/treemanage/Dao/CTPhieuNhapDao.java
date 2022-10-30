package com.treemanage.Dao;

import java.util.List;

import com.treemanage.Entity.ChiTietPhieuNhap;

public interface CTPhieuNhapDao {
    List<ChiTietPhieuNhap> showList(int maphieunhap);

    int insertDetailsTicket(ChiTietPhieuNhap chiTietPhieuNhap);

    int updateDetailsTicket(ChiTietPhieuNhap chiTietPhieuNhap);

    int deleteDetailsTicket(int id);

}
