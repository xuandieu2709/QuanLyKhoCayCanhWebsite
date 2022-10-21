package com.treemanage.Service;

import java.util.List;

import com.treemanage.Entity.PhieuNhap;

public interface PhieuNhapService {
    List<PhieuNhap> showList();   
    List<PhieuNhap> findbyId(int id);

    int addImport(PhieuNhap Phieunhap);

    int editImport(PhieuNhap Phieunhap);

    int removeImport(int maphieu);

    List<PhieuNhap> searchImport(String key);
}
