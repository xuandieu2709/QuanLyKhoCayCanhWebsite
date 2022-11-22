package com.treemanage.Entity.Mapper;
import org.springframework.jdbc.core.RowMapper;

import com.mysql.cj.jdbc.Blob;
import com.treemanage.Entity.taikhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Mappertaikhoan implements RowMapper<taikhoan> {
	@Override
    public taikhoan mapRow(ResultSet rs,int rowNum) throws SQLException {
    	taikhoan tk = new taikhoan();
    	tk.setTaikhoan(rs.getString("taikhoan"));
    	tk.setMatkhau(rs.getString("matkhau"));
		tk.setHotennv(rs.getString("hotennv"));
		tk.setNgaysinh(rs.getString("ngaysinh"));
		tk.setGioitinh(rs.getString("gioitinh"));
		tk.setSdt(rs.getString("sdt"));
		tk.setEmail(rs.getString("email"));
		tk.setDiachi(rs.getString("diachi"));
		tk.setVaitro(rs.getString("vaitro"));
		tk.setHinhanh((Blob)rs.getBlob("hinhanh"));
    	return tk;
    }
}
