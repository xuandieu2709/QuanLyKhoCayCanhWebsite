package com.treemanage.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treemanage.Dao.CTPhieuXuatDao;
import com.treemanage.Entity.ChiTietPhieuXuat;
import com.treemanage.Service.CTPhieuXuatService;

@Service
public class CTPhieuXuatServiceImp implements CTPhieuXuatService{
    @Autowired
    CTPhieuXuatDao ctPhieuXuatDao;

    @Override
    public List<ChiTietPhieuXuat> showAllList(){
        return ctPhieuXuatDao.showAllList();
    }

    @Override
    public int insertDetailsTicket(ChiTietPhieuXuat chiTietPhieuXuat){
        return ctPhieuXuatDao.insertDetailsTicket(chiTietPhieuXuat);
    }

    public int updateDetailsTicket(ChiTietPhieuXuat chiTietPhieuXuat){
        return ctPhieuXuatDao.updateDetailsTicket(chiTietPhieuXuat);
    }

    @Override
    public int deleteDetailsTicket(int id){
        return ctPhieuXuatDao.deleteDetailsTicket(id);
    }

    @Override
    public List<ChiTietPhieuXuat> FindByIDExport(int maphieuxuat){
        return ctPhieuXuatDao.FindByIDExport(maphieuxuat);
    }
}
