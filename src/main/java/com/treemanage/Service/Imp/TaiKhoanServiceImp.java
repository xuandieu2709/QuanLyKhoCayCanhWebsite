package com.treemanage.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treemanage.Dao.taikhoanDao;
import com.treemanage.Entity.taikhoan;
import com.treemanage.Service.TaiKhoanService;

@Service
public class TaiKhoanServiceImp implements TaiKhoanService{
	
	@Autowired
	taikhoanDao taikhoanDao;
	
	@Override
	public taikhoan dangnhap(String taikhoan,String matkhau){
		return taikhoanDao.dangnhap(taikhoan, matkhau).get(0);
	}

	@Override
	public boolean CheckAccount(String taikhoan, String matkhau){
		return taikhoanDao.CheckAccount(taikhoan, matkhau);
	}
}
