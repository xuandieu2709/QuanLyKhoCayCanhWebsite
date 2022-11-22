package com.treemanage.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treemanage.Dao.CayCanhDao;
import com.treemanage.Dao.LoaiCayDao;
import com.treemanage.Entity.LoaiCay;
import com.treemanage.Service.LoaiCayService;

@Service
public class LoaiCayServicelmp implements LoaiCayService {
	@Autowired
    LoaiCayDao loaiCayDao;
	public List<LoaiCay> showlist(){
		return loaiCayDao.showlist();
	}
	public int add(LoaiCay loaicay) {
		return loaiCayDao.add(loaicay);
	}
	
    public int delete(int maloai) {
    	return loaiCayDao.delete(maloai);
    }
    public LoaiCay findOne(int maloai) {
    	return loaiCayDao.findOne(maloai);
    }
	public int update(LoaiCay loaicay) {
		return loaiCayDao.update(loaicay);
	}
}
