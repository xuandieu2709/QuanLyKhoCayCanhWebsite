package com.treemanage.Dao;

import java.util.List;

import com.treemanage.Entity.PhieuNhap;

public interface PhieuNhapDao {
    List<PhieuNhap> showList();
    List<PhieuNhap> findbyId(int id);

    int addImport(PhieuNhap phieunhap);

    int editImport(PhieuNhap phieunhap);

    int removeImport(int maphieu);

    List<PhieuNhap> searchImport(String key);
}
