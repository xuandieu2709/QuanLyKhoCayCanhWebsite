package com.treemanage.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treemanage.Dao.PhieuNhapDao;
import com.treemanage.Entity.PhieuNhap;
import com.treemanage.Service.PhieuNhapService;

@Service
public class PhieuNhapServiceImp implements PhieuNhapService{
    @Autowired
    PhieuNhapDao phieuNhapDao;

    @Override
    public List<PhieuNhap> showList(){
        return phieuNhapDao.showList();
    }

    @Override
    public List<PhieuNhap> findbyId(int id){
        return phieuNhapDao.findbyId(id);
    }

    @Override
    public int addImport(PhieuNhap PhieuNhap){
        return phieuNhapDao.addImport(PhieuNhap);
    }

    @Override
    public int editImport(PhieuNhap PhieuNhap){
        return phieuNhapDao.editImport(PhieuNhap);
    }

    @Override
    public int removeImport(int maphieu){
        return phieuNhapDao.removeImport(maphieu);
    }

    @Override
    public List<PhieuNhap> searchImport(String key){
        return phieuNhapDao.searchImport(key);  
    }
    @Override
    public List<PhieuNhap> findFinalInsert(){
        return phieuNhapDao.findFinalInsert();
    }
}
