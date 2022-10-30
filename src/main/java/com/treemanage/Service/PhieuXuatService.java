package com.treemanage.Service;

import java.util.List;

import com.treemanage.Entity.PhieuXuat;

public interface PhieuXuatService {
    List<PhieuXuat> showList();

    List<PhieuXuat> findbyId(int id);

    int addExport(PhieuXuat phieuXuat);

    int editExport(PhieuXuat phieuXuat);

    int removeExport(int maphieu);

    List<PhieuXuat> searchExport(String key);

    PhieuXuat FindLastID();
}
