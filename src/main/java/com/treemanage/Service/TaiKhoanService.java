package com.treemanage.Service;

import java.util.List;

import com.treemanage.Entity.taikhoan;

public interface TaiKhoanService {
	taikhoan dangnhap(String taikhoan,String matkhau);

	boolean CheckAccount(String taikhoan, String matkhau);
}
