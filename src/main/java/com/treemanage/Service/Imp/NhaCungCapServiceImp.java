package com.treemanage.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treemanage.Dao.NhaCungCapDao;
import com.treemanage.Entity.NhaCungCap;
import com.treemanage.Service.NhaCungCapService;

@Service
public class NhaCungCapServiceImp implements NhaCungCapService{
    @Autowired
    NhaCungCapDao nhaCungCapDao;

    @Override
    public List<NhaCungCap> showList(){
        return nhaCungCapDao.showList(); 
    }
}
