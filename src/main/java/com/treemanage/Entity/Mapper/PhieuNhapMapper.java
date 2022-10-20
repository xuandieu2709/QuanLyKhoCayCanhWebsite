package com.treemanage.Entity.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.treemanage.Entity.PhieuNhap;
public class PhieuNhapMapper implements RowMapper<PhieuNhap>{

    @Override
    public PhieuNhap mapRow(ResultSet rs, int rowNum) throws SQLException {
        PhieuNhap phieuNhap = new PhieuNhap();
        phieuNhap.setMaphieu(rs.getInt("maphieunhap"));
        phieuNhap.setTenphieu(rs.getString("tenphieunhap"));
        phieuNhap.setThoigian(rs.getString("ngaynhap"));
        phieuNhap.setSoluong(rs.getInt("tongsoluong"));
        phieuNhap.setTongtien(rs.getDouble("tongtien"));
        return phieuNhap;
    }
    
}
