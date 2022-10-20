package com.treemanage.Dao.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.treemanage.Dao.BaoCaoDao;
import com.treemanage.Entity.BaoCao;
import com.treemanage.Entity.Mapper.BaoCaoMapper;

@Repository
public class BaoCaoDaoImp implements BaoCaoDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<BaoCao> showList(){
        String sql = "Select * from baocao";
        List<BaoCao> list = jdbcTemplate.query(sql, new BaoCaoMapper());
        return list;
    }
}
