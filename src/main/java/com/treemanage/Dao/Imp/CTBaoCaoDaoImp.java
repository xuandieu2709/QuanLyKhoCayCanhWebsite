package com.treemanage.Dao.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.treemanage.Dao.CTBaoCaoDao;
import com.treemanage.Entity.CTBaoCao;
import com.treemanage.Entity.Mapper.CTBaoCaoMapper;

@Repository
public class CTBaoCaoDaoImp implements CTBaoCaoDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int InsertDeatailsRP(CTBaoCao ct){
        String sql = "INSERT INTO `quanlykhocaycanh`.`chitietbaocao`(`mabaocao`,`macay`,`soluong`,`giaban`,`thanhtien`) VALUES(?,?,?,?,(soluong*giaban));";
        return jdbcTemplate.update(sql, new Object[]{ct.getMaphieu(),ct.getMacay(),ct.getSoluong(),ct.getGia()});
    }

    @Override
    public List<CTBaoCao> findbyIdReport(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CTBaoCao> showListByIDReport(int idRP){
        String sql = "select * from chitietbaocao where mabaocao = "+idRP+"";
        return jdbcTemplate.query(sql, new CTBaoCaoMapper());
    }

    @Override
    public int removeDetailsReport(int id){
        String sql = "DELETE FROM `quanlykhocaycanh`.`chitietbaocao` WHERE mabaocao ="+id+";";
        return jdbcTemplate.update(sql);
    }

}
