package com.treemanage.Dao.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.treemanage.Dao.CTPhieuNhapDao;
import com.treemanage.Entity.ChiTietPhieuNhap;
import com.treemanage.Entity.Mapper.CTPhieuNhapMapper;

@Repository
public class CTPhieuNhapDaoImp implements CTPhieuNhapDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<ChiTietPhieuNhap> showList(int maphieunhap) {
        String sql = "select machitietnhap, ct.maphieunhap, macay, manhacungcap, soluong, gianhap,thanhtien from chitietphieunhap ct join phieunhap p on ct.maphieunhap = p.maphieunhap where ct.maphieunhap = "
                + maphieunhap + "";
                List<ChiTietPhieuNhap> list = jdbcTemplate.query(sql, new CTPhieuNhapMapper());
        return list;
    }

    @Override
    public int insertDetailsTicket(ChiTietPhieuNhap chiTietPhieuNhap) {
        String sql = "INSERT INTO `quanlykhocaycanh`.`chitietphieunhap`(`maphieunhap`,`macay`,`manhacungcap`,`soluong`,`gianhap`,`thanhtien`) VALUES(?,?,?,?,?,?);";
        return jdbcTemplate.update(sql, new Object[]{chiTietPhieuNhap.getMaphieu(),chiTietPhieuNhap.getMacay(),
        chiTietPhieuNhap.getManhacungcap(),chiTietPhieuNhap.getSoluong(),chiTietPhieuNhap.getGia(),chiTietPhieuNhap.getThanhtien()});
    }

    @Override
    public int updateDetailsTicket(ChiTietPhieuNhap chiTietPhieuNhap) {
        String sql = "UPDATE `quanlykhocaycanh`.`chitietphieunhap` SET `maphieunhap` = ?,`macay` = ?,`manhacungcap` = ?,`soluong` = ?,`gianhap` = ?,`thanhtien` = ? WHERE `machitietnhap` = ?;";
        return jdbcTemplate.update(sql, new Object[]{chiTietPhieuNhap.getMaphieu(),chiTietPhieuNhap.getMacay(),
            chiTietPhieuNhap.getManhacungcap(),chiTietPhieuNhap.getSoluong(),chiTietPhieuNhap.getGia(),chiTietPhieuNhap.getThanhtien(),chiTietPhieuNhap.getMachitiet()});
    }

    @Override
    public int deleteDetailsTicket(int id) {
        String sql = "Delete from `quanlykhocaycanh`.`chitietphieunhap`  Where maphieunhap="+id+"";
        return jdbcTemplate.update(sql);
    }


}
