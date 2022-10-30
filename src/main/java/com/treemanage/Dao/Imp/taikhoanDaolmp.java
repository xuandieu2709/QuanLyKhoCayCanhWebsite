package com.treemanage.Dao.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.treemanage.Dao.taikhoanDao;
import com.treemanage.Entity.taikhoan;
import com.treemanage.Entity.Mapper.Mappertaikhoan;

@Repository
public class taikhoanDaolmp implements taikhoanDao {
	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public List<taikhoan> dangnhap(String taikhoan, String matkhau) {
		String sql = "select * from taikhoan where taikhoan='" + taikhoan + "' and matkhau='" + matkhau + "'";
		List<taikhoan> list = jdbctemplate.query(sql, new Mappertaikhoan());
		taikhoan tk = new taikhoan("", "");
		if (list.size() < 1) {
			list.add(tk);
		}
		return list;
	}

	@Override
	public boolean CheckAccount(String taikhoan, String matkhau) {
		String sql = "select * from taikhoan where taikhoan='" + taikhoan + "' and matkhau='" + matkhau + "'";
		List<taikhoan> list = jdbctemplate.query(sql, new Mappertaikhoan());
		if (list.size() < 1) {
			return false;
		}
		return true;

	}

	// INSERT INTO `quanlykhocaycanh`.`taikhoan`(`taikhoan`,`matkhau`) VALUES(?,?)

}
