package com.treemanage.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treemanage.Dao.PhieuXuatDao;
import com.treemanage.Entity.PhieuXuat;
import com.treemanage.Service.PhieuXuatService;

@Service
public class PhieuXuatServiceImp implements PhieuXuatService{
    @Autowired
    PhieuXuatDao phieuXuatDao;

    @Override
    public List<PhieuXuat> showList(){
        return phieuXuatDao.showList();
    }
}
