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
    public List<PhieuXuat> showList() {
        String sql = "Select * from phieuxuat";
        List<PhieuXuat> list = jdbcTemplate.query(sql, new PhieuXuatMapper());
        return list;
    }

    @Override
    public List<PhieuXuat> findbyId(int id) {
        String sql = "Select * from phieuxuat Where maphieuxuat =" + id + "";
        List<PhieuXuat> list = jdbcTemplate.query(sql, new PhieuXuatMapper());
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public int addExport(PhieuXuat phieuXuat) {
        String sql = "INSERT INTO `quanlykhocaycanh`.`phieuxuat`(`tenphieuxuat`,`ngayxuat`,`tongsoluong`,`tongtien`) VALUES(?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[] { phieuXuat.getTenphieu(), phieuXuat.getThoigian(),
                phieuXuat.getSoluong(), phieuXuat.getTongtien() });
    }

    @Override
    public int editExport(PhieuXuat phieuXuat) {
        String sql = "UPDATE `quanlykhocaycanh`.`phieuxuat` SET `tenphieuxuat` = ?,`ngayxuat` = ?,`tongsoluong` = ?,`tongtien` = ? WHERE `maphieuxuat` = ?";
        return jdbcTemplate.update(sql, new Object[] { phieuXuat.getTenphieu(), phieuXuat.getThoigian(),
                phieuXuat.getSoluong(), phieuXuat.getTongtien(), phieuXuat.getMaphieu() });
    }

    @Override
    public int removeExport(int maphieu) {
        String sql = "DELETE FROM `quanlykhocaycanh`.`phieuxuat` WHERE maphieuxuat= " + maphieu + ";";
        return jdbcTemplate.update(sql);
    }

    @Override
    public List<PhieuXuat> searchExport(String key){
        String sql = "SELECT * FROM phieuxuat where concat_ws('',tenphieuxuat,ngayxuat,tongsoluong,tongtien) like '%"+key+"%';";
        return jdbcTemplate.query(sql, new PhieuXuatMapper());
    }
}
