package com.treemanage.Dao.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.treemanage.Dao.BaoCaoDao;
import com.treemanage.Entity.BaoCao;
import com.treemanage.Entity.Mapper.BaoCaoMapper;

@Repository
public class BaoCaoDaoImp implements BaoCaoDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<BaoCao> showList() {
        String sql = "Select * from baocao order by mabaocao desc";
        List<BaoCao> list = jdbcTemplate.query(sql, new BaoCaoMapper());
        return list;
    }

    @Override
    public int InsertRP(BaoCao baoCao) {
        String sql = "INSERT INTO `quanlykhocaycanh`.`baocao`(`noidung`) VALUES(?);";
        return jdbcTemplate.update(sql, new Object[] { baoCao.getNoidung() });
    }

    @Override
    public List<BaoCao> showListByContent(String content) {
        String sql = "Select * from baocao where noidung like '%" + content + "%'";
        List<BaoCao> list = jdbcTemplate.query(sql, new BaoCaoMapper());
        return list;
    }

    @Override
    public List<BaoCao> findRPByID(int idRP) {
        String sql = "Select * from quanlykhocaycanh.baocao where mabaocao = " + idRP + ";";
        List<BaoCao> list = jdbcTemplate.query(sql, new BaoCaoMapper());
        return list;
    }

    @Override
    public int removeReport(int id) {
        String sql = "DELETE FROM `quanlykhocaycanh`.`baocao` WHERE mabaocao = " + id + "";
        return jdbcTemplate.update(sql);

    }

    @Override
    public List<BaoCao> searchRP(String key) {
        String sql = "SELECT * FROM baocao where concat_ws('',noidung,mabaocao,ngaybaocao) like '%"+key+"%'";
        return jdbcTemplate.query(sql, new BaoCaoMapper());
    }
}
