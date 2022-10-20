package com.treemanage.Entity.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.treemanage.Entity.PhieuXuat;

public class PhieuXuatMapper implements RowMapper<PhieuXuat> {

    @Override
    public PhieuXuat mapRow(ResultSet rs, int rowNum) throws SQLException {
        PhieuXuat PhieuXuat = new PhieuXuat();
        PhieuXuat.setMaphieu(rs.getInt("maphieuxuat"));
        PhieuXuat.setTenphieu(rs.getString("tenphieuxuat"));
        PhieuXuat.setThoigian(rs.getString("ngayxuat"));
        PhieuXuat.setSoluong(rs.getInt("tongsoluong"));
        PhieuXuat.setTongtien(rs.getDouble("tongtien"));
        return PhieuXuat;
    }
    
}
