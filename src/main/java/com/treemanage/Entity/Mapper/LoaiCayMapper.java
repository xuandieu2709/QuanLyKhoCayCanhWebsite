package com.treemanage.Entity.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.treemanage.Entity.LoaiCay;

public class LoaiCayMapper implements RowMapper<LoaiCay> {

	@Override
	public LoaiCay mapRow(ResultSet rs, int rowNum) throws SQLException {
		LoaiCay loaicay=new LoaiCay();
		loaicay.setMaloai(rs.getInt("maloai"));
		loaicay.setTenloai(rs.getString("tenloai"));
		return loaicay;
	}
     
}
