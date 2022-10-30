package com.treemanage.Service.Imp;

import java.io.IOException;
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
    @Override
    public int add(CayCanh caycanh) throws IOException {
    	return cayCanhDao.add(caycanh);
    }
    @Override
    public int update(CayCanh caycanh) throws IOException {
    	return cayCanhDao.update(caycanh);
    }
    @Override
    public int delete(int macay) {
    	return cayCanhDao.delete(macay);
    }
    @Override
    public CayCanh findOne(int macay){
    	return cayCanhDao.findOne(macay);
    }
    @Override
    public List<CayCanh> findlistbyname(String tencay){
    	return cayCanhDao.findlistbyname(tencay);
    }
    @Override
	public List<CayCanh> orderbyprice(int value){
		return cayCanhDao.orderbyprice(value);
	}
    @Override
	public List<CayCanh> findAll(){
		return cayCanhDao.findAll();
	}
	@Override
	public List<CayCanh> showListByML(int maloai){
		return cayCanhDao.showListByML(maloai);
	}

    @Override
    public int updateInventoryByID(CayCanh caycanh,int macay){
        return cayCanhDao.updateInventoryByID(caycanh, macay);
    }
}
