package com.treemanage.Dao.Imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.treemanage.Dao.taikhoanDao;
import com.treemanage.Entity.CayCanh;
import com.treemanage.Entity.taikhoan;
import com.treemanage.Entity.Mapper.CayCanhMapper;
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
	@Override
	public boolean CheckTaiKhoanAC(String taikhoan) {
		String sql = "select * from taikhoan where taikhoan =  '" + taikhoan + "'";
		List<taikhoan> list = jdbctemplate.query(sql, new Mappertaikhoan());
		if (list.size() < 1) {
			return false;
		}
		return true;

	}
	// ngao nay keu m lam ben quan lys con cai kia r tlam ok vay sua lai di

	// INSERT INTO `quanlykhocaycanh`.`taikhoan`(`taikhoan`,`matkhau`) VALUES(?,?)
	@Override
	public List<taikhoan> showList() {
		String sql = "Select * from taikhoan";
		List<taikhoan> list = jdbctemplate.query(sql, new Mappertaikhoan());
		return list;
	}
	@Override
	public int add(taikhoan taikhoan) throws IOException {
		String sql = "insert into taikhoan(taikhoan,matkhau,hotennv,ngaysinh,gioitinh,sdt,diachi,vaitro,email,hinhanh) values(?,?,?,?,?,?,?,?,?,?)";
		byte[] photoBytes = taikhoan.getPhoto().getBytes();
		int kq = jdbctemplate.update(sql,
				new Object[] { taikhoan.getTaikhoan(), taikhoan.getMatkhau(), taikhoan.getHotennv(), 
						taikhoan.getNgaysinh(),taikhoan.getGioitinh(),taikhoan.getSdt(),taikhoan.getDiachi(),taikhoan.getVaitro(),taikhoan.getEmail(),photoBytes,});
		return kq;
	}

	@Override
	public int delete(String taikhoan) {
		String sql = "delete from quanlykhocaycanh.taikhoan where taikhoan = " + taikhoan;
		int kq = jdbctemplate.update(sql);
		return kq;
	}

	@Override
	public taikhoan findOne(String taikhoan) {
		String sql = "select*from taikhoan where taikhoan= '" + taikhoan +"'";
		List<taikhoan> list = new ArrayList<taikhoan>();
		list = jdbctemplate.query(sql, new Mappertaikhoan());

		return list.get(0);
	}

	@Override
	public int update(taikhoan taikhoan) throws IOException {
		String query;
		byte[] photoBytes;
		int kq;
		if (!taikhoan.getPhoto().isEmpty()) {
			photoBytes = taikhoan.getPhoto().getBytes();
			query = "UPDATE `quanlykhocaycanh`.`taikhoan` SET `matkhau` = ?, `hotennv` = ?, `ngaysinh` = ?, `gioitinh` = ?, `sdt` = ?, `diachi` =?, `vaitro` = ?,`email`=?,`hinhanh`=?  WHERE `taikhoan` = ?";
			kq = jdbctemplate.update(query,
					new Object[] {taikhoan.getMatkhau(), taikhoan.getHotennv(), 
							taikhoan.getNgaysinh(),taikhoan.getGioitinh(),taikhoan.getSdt(),taikhoan.getDiachi(),taikhoan.getVaitro(),taikhoan.getEmail(),photoBytes,taikhoan.getTaikhoan()});
		} else {
			query = "UPDATE `quanlykhocaycanh`.`taikhoan` SET `matkhau` = ?, `hotennv` = ?, `ngaysinh` = ?, `gioitinh` = ?, `sdt` = ?, `diachi` =?, `vaitro` = ?,`email`=?  WHERE `taikhoan` = ?";
			kq = jdbctemplate.update(query,
					new Object[] {taikhoan.getMatkhau(), taikhoan.getHotennv(), 
							taikhoan.getNgaysinh(),taikhoan.getGioitinh(),taikhoan.getSdt(),taikhoan.getDiachi(),taikhoan.getVaitro(),taikhoan.getEmail(),taikhoan.getTaikhoan()});
		}
		return kq;

	}

	@Override
	public List<taikhoan> findlistbyaccount(String taikhoan) {
		String sql = "SELECT * FROM taikhoan where concat_ws('',taikhoan,matkhau,hotennv,ngaysinh,gioitinh,sdt,diachi,vaitro,email,hinhanh) like '%"
				+ taikhoan + "%'";
		List<taikhoan> list = new ArrayList<taikhoan>();
		list = jdbctemplate.query(sql, new Mappertaikhoan());
		return list;
	}

	@Override
	public int changPass(taikhoan taikhoan){
		String sql = "UPDATE `quanlykhocaycanh`.`taikhoan` SET `matkhau` = ? Where `taikhoan` = ?";
		return jdbctemplate.update(sql, new Object[]{taikhoan.getMatkhau(),taikhoan.getTaikhoan()});
	}

}
