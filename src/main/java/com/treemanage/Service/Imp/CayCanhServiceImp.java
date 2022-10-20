package com.treemanage.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treemanage.Dao.CayCanhDao;
import com.treemanage.Entity.CayCanh;
import com.treemanage.Service.CayCanhService;

@Service
public class CayCanhServiceImp implements CayCanhService{
    @Autowired
    CayCanhDao cayCanhDao;

    @Override
    public List<CayCanh> showList(){
        return cayCanhDao.showList();
    }
}
