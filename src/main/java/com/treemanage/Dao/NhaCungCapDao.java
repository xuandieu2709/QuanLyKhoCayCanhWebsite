package com.treemanage.Dao;

import java.io.IOException;
import java.util.List;

import com.treemanage.Entity.CayCanh;
import com.treemanage.Entity.NhaCungCap;

public interface NhaCungCapDao {
    List<NhaCungCap> showList();
    int add(NhaCungCap nhacungcap);
    int delete(int manhacungcap);
    NhaCungCap findOne(int manhacungcap);
	int update(NhaCungCap nhacungcap) ;
	List<NhaCungCap> findlistbyname(String tennhacungcap);
}
