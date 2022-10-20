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
}
