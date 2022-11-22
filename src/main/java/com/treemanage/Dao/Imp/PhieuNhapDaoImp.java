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
        String sql = "Select * from phieunhap Order by maphieunhap  DESC";
        List<PhieuNhap> list = jdbcTemplate.query(sql, new PhieuNhapMapper());
        return list;
    }

    @Override
    public List<PhieuNhap> findbyId(int id){
        String sql = "Select * from phieunhap Where maphieunhap ="+id+"";
        List<PhieuNhap> list = jdbcTemplate.query(sql, new PhieuNhapMapper());
        if(list.size()>0){
            return list;
        }else{
        return null;
        }

    }
    @Override
    public int addImport(PhieuNhap phieunhap) {
        String sql = "INSERT INTO `quanlykhocaycanh`.`phieunhap`(`tenphieunhap`,`ngaynhap`,`tongsoluong`,`tongtien`) VALUES(?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[] { phieunhap.getTenphieu(), phieunhap.getThoigian(),
                phieunhap.getSoluong(), phieunhap.getTongtien() });
    }

    @Override
    public int editImport(PhieuNhap phieunhap) {
        String sql = "UPDATE `quanlykhocaycanh`.`phieunhap` SET `tenphieunhap` = ?,`ngaynhap` = ?,`tongsoluong` = ?,`tongtien` = ? WHERE `maphieunhap` = ?";
        return jdbcTemplate.update(sql, new Object[] { phieunhap.getTenphieu(), phieunhap.getThoigian(),
                phieunhap.getSoluong(), phieunhap.getTongtien(), phieunhap.getMaphieu() });
    }

    @Override
    public int removeImport(int maphieu) {
        String sql = "DELETE FROM `quanlykhocaycanh`.`phieunhap` WHERE maphieunhap= " + maphieu + ";";
        return jdbcTemplate.update(sql);
    }

    @Override
    public List<PhieuNhap> searchImport(String key){
        String sql = "SELECT * FROM phieunhap where concat_ws('',tenphieunhap,ngaynhap,tongsoluong,tongtien) like '%"+key+"%';";
        return jdbcTemplate.query(sql, new PhieuNhapMapper());
    }

    @Override
    public List<PhieuNhap> findFinalInsert(){
        String sql = "SELECT * FROM quanlykhocaycanh.phieunhap order by maphieunhap desc limit 1; ";
        return jdbcTemplate.query(sql, new PhieuNhapMapper());
    }
}
