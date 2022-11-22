package com.treemanage.Dao;

import java.io.IOException;
import java.util.List;

import com.treemanage.Entity.CayCanh;
import com.treemanage.Entity.taikhoan;

public interface taikhoanDao {

     List<taikhoan> dangnhap(String taikhoan, String matkhau);

     boolean CheckAccount(String taikhoan, String matkhau);

     List<taikhoan> showList();

     int add(taikhoan taikhoan) throws IOException;

     int delete(String taikhoan);

     taikhoan findOne(String taikhoan);

     int update(taikhoan taikhoan) throws IOException;

     List<taikhoan> findlistbyaccount(String taikhoan);

     boolean CheckTaiKhoanAC(String taikhoan);

     int changPass(taikhoan taikhoan);
}
