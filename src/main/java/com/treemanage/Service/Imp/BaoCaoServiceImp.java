package com.treemanage.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treemanage.Dao.BaoCaoDao;
import com.treemanage.Entity.BaoCao;
import com.treemanage.Service.BaoCaoService;

@Service
public class BaoCaoServiceImp implements BaoCaoService{
    @Autowired
    BaoCaoDao baoCaoDao;

    @Override
    public List<BaoCao> showList(){
        return baoCaoDao.showList();
    }

    @Override
    public int InsertRP(BaoCao baoCao){
        return baoCaoDao.InsertRP(baoCao);
    }

    @Override
    public BaoCao FindReportByContent(String content){
        return baoCaoDao.showListByContent(content).get(0);
    }

    @Override
    public BaoCao findRPByID(int idRP){
        return baoCaoDao.findRPByID(idRP).get(0);
    }

    @Override
    public int removeReport(int id){
        return baoCaoDao.removeReport(id);
    }

    @Override
    public List<BaoCao> searchRP(String key){
        return baoCaoDao.searchRP(key);
    }

}
