package com.treemanage.Dao.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.treemanage.Dao.LoaiCayDao;
import com.treemanage.Entity.LoaiCay;
import com.treemanage.Entity.Mapper.LoaiCayMapper;
@Repository
public class LoaiCayDaolmp implements LoaiCayDao {
	@Autowired
    JdbcTemplate jdbcTemplate;
	@Override
    public List<LoaiCay> showlist(){
    	String sql="select*from loaicay";
    	List<LoaiCay> list=jdbcTemplate.query(sql, new LoaiCayMapper());
    	return list;
    }
}
