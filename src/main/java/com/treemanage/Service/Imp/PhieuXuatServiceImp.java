package com.treemanage.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treemanage.Dao.PhieuXuatDao;
import com.treemanage.Entity.PhieuXuat;
import com.treemanage.Service.PhieuXuatService;

@Service
public class PhieuXuatServiceImp implements PhieuXuatService {
    @Autowired
    PhieuXuatDao phieuXuatDao;

    @Override
    public List<PhieuXuat> showList() {
        return phieuXuatDao.showList();
    }

    @Override
    public List<PhieuXuat> findbyId(int id) {
        return phieuXuatDao.findbyId(id);
    }
    @Override
    public int addExport(PhieuXuat phieuXuat){
        return phieuXuatDao.addExport(phieuXuat);
    }

    @Override
    public int editExport(PhieuXuat phieuXuat){
        return phieuXuatDao.editExport(phieuXuat);
    }

    @Override
    public int removeExport(int maphieu){
        return phieuXuatDao.removeExport(maphieu);
    }

    @Override
    public List<PhieuXuat> searchExport(String key){
        return phieuXuatDao.searchExport(key);  
    }

    @Override
    public PhieuXuat FindLastID(){
        return phieuXuatDao.FindLastID().get(0);
    }
}
