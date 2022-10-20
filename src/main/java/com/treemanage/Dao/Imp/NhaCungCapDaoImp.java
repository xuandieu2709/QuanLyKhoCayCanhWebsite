package com.treemanage.Dao.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.treemanage.Dao.NhaCungCapDao;
import com.treemanage.Entity.NhaCungCap;
import com.treemanage.Entity.Mapper.NhaCungCapMapper;

@Repository
public class NhaCungCapDaoImp implements NhaCungCapDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<NhaCungCap> showList(){
        String sql = "Select * from nhacungcap";
        List<NhaCungCap> list = jdbcTemplate.query(sql, new NhaCungCapMapper());
        return list;
    }
}
