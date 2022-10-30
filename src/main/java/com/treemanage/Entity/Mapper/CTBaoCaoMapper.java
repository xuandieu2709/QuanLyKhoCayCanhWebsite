package com.treemanage.Entity.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.treemanage.Entity.CTBaoCao;

public class CTBaoCaoMapper implements RowMapper<CTBaoCao> {
    @Override
    public CTBaoCao mapRow(ResultSet rs, int rowNum) throws SQLException {
        CTBaoCao ctbaocao = new CTBaoCao();
        ctbaocao.setMachitiet(rs.getInt("machitiet"));
        ctbaocao.setMaphieu(rs.getInt("mabaocao"));
        //ctbaocao.setTenphieu(rs.getString("noidung"));
        //ctbaocao.setThoigian(rs.getString("ngaybaocao"));
        ctbaocao.setMacay(rs.getInt("macay"));
        ctbaocao.setSoluong(rs.getInt("soluong"));
        ctbaocao.setGia(rs.getDouble("giaban"));
        ctbaocao.setThanhtien(rs.getDouble("thanhtien"));
        return ctbaocao;
    }

}
