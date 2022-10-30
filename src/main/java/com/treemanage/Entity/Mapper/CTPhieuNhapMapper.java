package com.treemanage.Entity.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.treemanage.Entity.ChiTietPhieuNhap;

public class CTPhieuNhapMapper implements RowMapper<ChiTietPhieuNhap>{

    @Override
    public ChiTietPhieuNhap mapRow(ResultSet rs, int rowNum) throws SQLException {
        ChiTietPhieuNhap ctnhap = new ChiTietPhieuNhap();
        ctnhap.setMachitiet(rs.getInt("machitietnhap"));
        ctnhap.setMaphieu(rs.getInt("maphieunhap"));
        ctnhap.setMacay(rs.getInt("macay"));
        ctnhap.setManhacungcap(rs.getInt("manhacungcap"));
        ctnhap.setSoluong(rs.getInt("soluong"));
        ctnhap.setGia(rs.getDouble("gianhap"));
        ctnhap.setThanhtien(rs.getDouble("thanhtien"));
        return ctnhap;
    }
    
}
