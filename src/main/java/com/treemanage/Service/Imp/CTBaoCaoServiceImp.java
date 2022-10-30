package com.treemanage.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treemanage.Dao.CTBaoCaoDao;
import com.treemanage.Entity.CTBaoCao;
import com.treemanage.Service.CTBaoCaoService;

@Service
public class CTBaoCaoServiceImp implements CTBaoCaoService{
    @Autowired
    CTBaoCaoDao ctBaoCaoDao;
    @Override
    public int InsertDeatailsRP(CTBaoCao ct){
        return ctBaoCaoDao.InsertDeatailsRP(ct);
    }

    @Override
    public List<CTBaoCao> showListByIDReport(int idRP){
        return ctBaoCaoDao.showListByIDReport(idRP);
    }

    @Override
    public int removeDetailsReport(int id){
        return ctBaoCaoDao.removeDetailsReport(id);
    }
}
