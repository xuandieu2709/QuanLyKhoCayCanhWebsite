package com.treemanage.Entity.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.treemanage.Entity.ChiTietPhieuXuat;

public class CTPhieuXuatMapper implements RowMapper<ChiTietPhieuXuat>{
    @Override
    public ChiTietPhieuXuat mapRow(ResultSet rs, int rowNum) throws SQLException {
        ChiTietPhieuXuat ctxuat = new ChiTietPhieuXuat();
        ctxuat.setMachitiet(rs.getInt("machitietxuat"));
        ctxuat.setMaphieu(rs.getInt("maphieuxuat"));
        ctxuat.setMacay(rs.getInt("macay"));
        ctxuat.setSoluong(rs.getInt("soluong"));
        ctxuat.setGia(rs.getDouble("giaban"));
        ctxuat.setThanhtien(rs.getDouble("thanhtien"));
        return ctxuat;
    }
    
}
