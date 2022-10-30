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
    public int add(NhaCungCap nhacungcap) {
    	return nhaCungCapDao.add(nhacungcap);
    }
    public int delete(int manhacungcap) {
    	return nhaCungCapDao.delete(manhacungcap);
    }
    public NhaCungCap findOne(int manhacungcap) {
    	return nhaCungCapDao.findOne(manhacungcap);
    }
	public int update(NhaCungCap nhacungcap) {
		return nhaCungCapDao.update(nhacungcap);
	}
	public List<NhaCungCap> findlistbyname(String tennhacungcap){
		return nhaCungCapDao.findlistbyname(tennhacungcap);
	}
}
