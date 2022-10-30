package com.treemanage.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treemanage.Dao.CTPhieuNhapDao;
import com.treemanage.Entity.ChiTietPhieuNhap;
import com.treemanage.Service.CTPhieuNhapService;

@Service
public class CTPhieuNhapServiceImp implements CTPhieuNhapService {
    @Autowired
    CTPhieuNhapDao ctPhieuNhapDao;

    @Override
    public List<ChiTietPhieuNhap> showList(int maphieunhap) {
        return ctPhieuNhapDao.showList(maphieunhap);
    }

    @Override
    public int insertDetailsTicket(ChiTietPhieuNhap chiTietPhieuNhap) {
        return ctPhieuNhapDao.insertDetailsTicket(chiTietPhieuNhap);
    }

    @Override
    public int updateDetailsTicket(ChiTietPhieuNhap chiTietPhieuNhap){
        return ctPhieuNhapDao.updateDetailsTicket(chiTietPhieuNhap);
    }
    

    @Override
    public int deleteDetailsTicket(int id){
        return ctPhieuNhapDao.deleteDetailsTicket(id);
    }
}
