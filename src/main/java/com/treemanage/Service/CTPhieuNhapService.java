package com.treemanage.Service;

import java.util.List;

import com.treemanage.Entity.ChiTietPhieuNhap;

public interface CTPhieuNhapService {
    List<ChiTietPhieuNhap> showList(int maphieunhap);
    int insertDetailsTicket(ChiTietPhieuNhap chiTietPhieuNhap);
}
