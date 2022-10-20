package com.treemanage.Dao.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.treemanage.Entity.CayCanh;
import com.treemanage.Dao.CayCanhDao;
import com.treemanage.Entity.Mapper.CayCanhMapper;

@Repository
public class CayCanhDaoImp implements CayCanhDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<CayCanh> showList(){
        String sql = "Select * from caycanh";
        List<CayCanh> list = jdbcTemplate.query(sql, new CayCanhMapper());
        return list;
    }
}
