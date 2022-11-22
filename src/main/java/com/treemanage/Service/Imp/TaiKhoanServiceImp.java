package com.treemanage.Service.Imp;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treemanage.Dao.taikhoanDao;
import com.treemanage.Entity.taikhoan;
import com.treemanage.Service.TaiKhoanService;

@Service
public class TaiKhoanServiceImp implements TaiKhoanService {

	@Autowired
	taikhoanDao taikhoanDao;

	@Override
	public taikhoan dangnhap(String taikhoan, String matkhau) {
		return taikhoanDao.dangnhap(taikhoan, matkhau).get(0);
	}

	@Override
	public boolean CheckAccount(String taikhoan, String matkhau) {
		return taikhoanDao.CheckAccount(taikhoan, matkhau);
	}

	@Override
	public List<taikhoan> showList() {
		return taikhoanDao.showList();
	}

	@Override
	public int add(taikhoan taikhoan) throws IOException {
		return taikhoanDao.add(taikhoan);
	}

	@Override
	public int delete(String taikhoan) {
		return taikhoanDao.delete(taikhoan);
	}

	@Override
	public taikhoan findOne(String taikhoan) {
		return taikhoanDao.findOne(taikhoan);
	}

	@Override
	public int update(taikhoan taikhoan) throws IOException {
		return taikhoanDao.update(taikhoan);
	}

	@Override
	public List<taikhoan> findlistbyaccount(String taikhoan) {
		return taikhoanDao.findlistbyaccount(taikhoan);
	}

	@Override
	public boolean CheckTaiKhoanAC(String taikhoan) {
		return taikhoanDao.CheckTaiKhoanAC(taikhoan);
	}

	@Override
	public int changPass(taikhoan taikhoan){
		return taikhoanDao.changPass(taikhoan);
	}
}
