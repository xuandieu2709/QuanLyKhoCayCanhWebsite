package com.treemanage.Dao;

import java.util.List;

import com.treemanage.Entity.taikhoan;

public interface taikhoanDao {
    
     List<taikhoan> dangnhap(String taikhoan,String matkhau);

     boolean CheckAccount(String taikhoan, String matkhau);
}
