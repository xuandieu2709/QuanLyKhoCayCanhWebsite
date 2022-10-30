package com.treemanage.Service;

import java.util.List;

import com.treemanage.Entity.NhaCungCap;

public interface NhaCungCapService {
	List<NhaCungCap> showList();
    int add(NhaCungCap nhacungcap);
    int delete(int manhacungcap);
    NhaCungCap findOne(int manhacungcap);
	int update(NhaCungCap nhacungcap) ;
	List<NhaCungCap> findlistbyname(String tennhacungcap);
}
