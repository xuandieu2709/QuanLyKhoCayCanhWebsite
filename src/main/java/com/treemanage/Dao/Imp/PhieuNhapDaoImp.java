package com.treemanage.Dao.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.treemanage.Dao.PhieuNhapDao;
import com.treemanage.Entity.PhieuNhap;
import com.treemanage.Entity.Mapper.PhieuNhapMapper;

@Repository
public class PhieuNhapDaoImp implements PhieuNhapDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<PhieuNhap> showList(){
        String sql = "Select * from phieunhap";
        List<PhieuNhap> list = jdbcTemplate.query(sql, new PhieuNhapMapper());
        return list;
    }
}
