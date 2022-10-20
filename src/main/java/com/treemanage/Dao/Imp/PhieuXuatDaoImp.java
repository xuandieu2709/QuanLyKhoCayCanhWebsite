package com.treemanage.Dao.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.treemanage.Dao.PhieuXuatDao;
import com.treemanage.Entity.PhieuXuat;
import com.treemanage.Entity.Mapper.PhieuXuatMapper;

@Repository
public class PhieuXuatDaoImp implements PhieuXuatDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<PhieuXuat> showList(){
        String sql = "Select * from phieuxuat";
        List<PhieuXuat> list = jdbcTemplate.query(sql, new PhieuXuatMapper());
        return list;
    }
}
