package com.treemanage.Entity.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.treemanage.Entity.CayCanh;
import com.mysql.cj.jdbc.Blob;

public class CayCanhMapper implements RowMapper<CayCanh>{

    @Override
    public CayCanh mapRow(ResultSet rs, int rowNum) throws SQLException {
        CayCanh cayCanh = new CayCanh();
        cayCanh.setMacay(rs.getInt("macay"));
        cayCanh.setTencay(rs.getString("tencay"));
        cayCanh.setGiacay((int)rs.getDouble("giacay"));
        cayCanh.setTonkho(rs.getInt("tonkho"));
        cayCanh.setHinhanh(rs.getBlob("hinhanh"));
        cayCanh.setMota(rs.getString("mota"));
        cayCanh.setDvt(rs.getString("dvt"));
        cayCanh.setMaloai(rs.getInt("maloai"));
        return cayCanh;
    }
    
}
