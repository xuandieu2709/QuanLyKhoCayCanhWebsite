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
}
