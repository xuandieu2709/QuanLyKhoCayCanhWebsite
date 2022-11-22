package com.treemanage.Service;

import java.util.List;

import com.treemanage.Entity.LoaiCay;

public interface LoaiCayService {
	List<LoaiCay> showlist();
	int add(LoaiCay loaicay);
    int delete(int maloai);
    LoaiCay findOne(int maloai);
	int update(LoaiCay loaicay);
}
