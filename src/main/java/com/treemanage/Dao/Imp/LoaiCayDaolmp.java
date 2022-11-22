package com.treemanage.Dao.Imp;

import java.util.ArrayList;
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
	@Override
    public int add(LoaiCay loaicay)   {
    	String sql="insert into loaicay(tenloai) values(?)";
    	
    	int kq= jdbcTemplate.update(sql,
    			new Object[] {loaicay.getTenloai()});
    	return kq;
    }
	@Override
	public int delete(int maloai) {
		String sql = "delete from quanlykhocaycanh.loaicay where maloai = "+maloai;
		int kq= jdbcTemplate.update(sql);
		return kq;
	}
    @Override
    public LoaiCay findOne(int maloai){
    	String sql="select*from loaicay where maloai="+maloai;
    	List<LoaiCay> list=new ArrayList<LoaiCay>();
    	list=jdbcTemplate.query(sql,new LoaiCayMapper());
    	
    	return list.get(0);
    }

	@Override
	public int update(LoaiCay loaicay)  {
		String query;		  
        query = "UPDATE `quanlykhocaycanh`.`loaicay` SET `tenloai` = ?  WHERE `maloai` = ?";
        int kq = jdbcTemplate.update(query,
            		new Object[]{loaicay.getTenloai(), loaicay.getMaloai()});   
        return kq;
		
	}
}
