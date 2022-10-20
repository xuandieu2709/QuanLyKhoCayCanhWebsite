package com.treemanage.Entity.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.treemanage.Entity.BaoCao;

public class BaoCaoMapper implements RowMapper<BaoCao>{

    @Override
    public BaoCao mapRow(ResultSet rs, int rowNum) throws SQLException {
        BaoCao bc = new BaoCao();
        bc.setMabaocao(rs.getInt("mabaocao"));
        bc.setNgaybaocao(rs.getString("ngaybaocao"));
        bc.setNoidung(rs.getString("noidung"));
        return bc;
    }
    
}
