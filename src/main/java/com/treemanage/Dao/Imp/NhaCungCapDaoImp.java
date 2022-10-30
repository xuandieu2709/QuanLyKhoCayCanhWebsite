package com.treemanage.Dao.Imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.treemanage.Dao.NhaCungCapDao;
import com.treemanage.Entity.CayCanh;
import com.treemanage.Entity.NhaCungCap;
import com.treemanage.Entity.Mapper.CayCanhMapper;
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
    @Override
    public int add(NhaCungCap nhacungcap) {
    	String sql="insert into nhacungcap (tennhacungcap,sodienthoai,email,diachi,ghichu) values(?,?,?,?,?)";
    	int kq=jdbcTemplate.update(sql,
    			new Object[]
    			{nhacungcap.getTennhacungcap(),nhacungcap.getSodienthoai(),nhacungcap.getEmail(),
    			nhacungcap.getDiachi(),nhacungcap.getGhichu()});
    	return kq;
    }
    @Override
   	public int delete(int manhacungcap) {
   		String sql = "delete from quanlykhocaycanh.nhacungcap where manhacungcap = "+manhacungcap;
   		int kq= jdbcTemplate.update(sql);
   		return kq;
   	}
    @Override
	public int update(NhaCungCap nhacungcap) {
		String query;		  
        query = "UPDATE `quanlykhocaycanh`.`nhacungcap` SET `tennhacungcap` = ?, `sodienthoai` = ?, `email` = ?, `diachi` = ?, `ghichu` = ?  WHERE `manhacungcap` = ?";
        int kq = jdbcTemplate.update(query,
            		new Object[]{nhacungcap.getTennhacungcap(), nhacungcap.getSodienthoai(), nhacungcap.getEmail(), nhacungcap.getDiachi(),
    						nhacungcap.getGhichu(), nhacungcap.getManhacungcap()});   
        return kq;
		
	}
       @Override
       public NhaCungCap findOne(int manhacungcap){
       	String sql="select*from nhacungcap where manhacungcap="+manhacungcap;
       	List<NhaCungCap> list=new ArrayList<NhaCungCap>();
       	list=jdbcTemplate.query(sql,new NhaCungCapMapper());
       	
       	return list.get(0);
       }
       @Override
   	public List<NhaCungCap> findlistbyname(String tennhacungcap) {
   		String sql = "SELECT * FROM nhacungcap where concat_ws('',manhacungcap,tennhacungcap,sodienthoai,email,diachi,ghichu) like '%" + tennhacungcap + "%'";
   		List<NhaCungCap> list = new ArrayList<NhaCungCap>();
   		list = jdbcTemplate.query(sql, new NhaCungCapMapper());
   		return list;
   	}
}
