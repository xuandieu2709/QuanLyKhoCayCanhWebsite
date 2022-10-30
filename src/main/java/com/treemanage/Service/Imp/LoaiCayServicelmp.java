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

}
