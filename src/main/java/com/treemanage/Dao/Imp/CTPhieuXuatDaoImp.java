package com.treemanage.Dao.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.treemanage.Dao.CTPhieuXuatDao;
import com.treemanage.Entity.ChiTietPhieuXuat;
import com.treemanage.Entity.Mapper.CTPhieuXuatMapper;

@Repository
public class CTPhieuXuatDaoImp implements CTPhieuXuatDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<ChiTietPhieuXuat> showAllList() {
        String sql = "SELECT * from chitietphieuxuat";
        List<ChiTietPhieuXuat> list = jdbcTemplate.query(sql, new CTPhieuXuatMapper());
        return list;
    }

    @Override
    public List<ChiTietPhieuXuat> FindByIDExport(int maphieuxuat) {
        String sql ="SELECT * FROM quanlykhocaycanh.chitietphieuxuat where maphieuxuat = "+maphieuxuat+"";
        return jdbcTemplate.query(sql, new CTPhieuXuatMapper());
    }

    @Override
    public int insertDetailsTicket(ChiTietPhieuXuat chiTietPhieuXuat) {
        String sql ="INSERT INTO `quanlykhocaycanh`.`chitietphieuxuat`(`maphieuxuat`,`macay`,`soluong`,`giaban`,`thanhtien`) VALUES(?,?,?,?,?);";
        return jdbcTemplate.update(sql, new Object[]{chiTietPhieuXuat.getMaphieu(),chiTietPhieuXuat.getMacay(),
            chiTietPhieuXuat.getSoluong(),chiTietPhieuXuat.getGia(),chiTietPhieuXuat.getThanhtien()});
    }

    @Override
    public int updateDetailsTicket(ChiTietPhieuXuat chiTietPhieuXuat) {
        String sql ="UPDATE `quanlykhocaycanh`.`chitietphieuxuat` SET `maphieuxuat` = ?,`macay` = ?,`soluong` = ?,`giaban` = ?,`thanhtien` = ? WHERE `machitietxuat` = ?;";
        jdbcTemplate.update(sql, new Object[]{chiTietPhieuXuat.getMaphieu(),chiTietPhieuXuat.getMacay(),
            chiTietPhieuXuat.getSoluong(),chiTietPhieuXuat.getGia(),chiTietPhieuXuat.getThanhtien(),chiTietPhieuXuat.getMachitiet()});
        return 0;
    }

    @Override
    public int deleteDetailsTicket(int id) {
        String sql = "Delete from `quanlykhocaycanh`.`chitietphieuxuat`  Where maphieuxuat=" + id + "";
        return jdbcTemplate.update(sql);
    }

}
