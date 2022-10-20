package com.treemanage.Entity.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.treemanage.Entity.NhaCungCap;

public class NhaCungCapMapper implements RowMapper<NhaCungCap>{

    @Override
    public NhaCungCap mapRow(ResultSet rs, int rowNum) throws SQLException {
        NhaCungCap ncc = new NhaCungCap();
        ncc.setManhacungcap(rs.getInt("manhacungcap"));
        ncc.setTennhacungcap(rs.getString("tennhacungcap"));
        ncc.setSodienthoai(rs.getString("sodienthoai"));
        ncc.setDiachi(rs.getString("diachi"));
        ncc.setEmail(rs.getString("email"));
        ncc.setGhichu(rs.getString("ghichu"));
        return ncc;
    }
    
}
