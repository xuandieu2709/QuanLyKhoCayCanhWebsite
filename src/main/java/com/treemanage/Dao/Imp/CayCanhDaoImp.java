package com.treemanage.Dao.Imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.treemanage.Entity.CayCanh;
import com.treemanage.Dao.CayCanhDao;
import com.treemanage.Entity.Mapper.CayCanhMapper;

@Repository
public class CayCanhDaoImp implements CayCanhDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<CayCanh> showList() {
		String sql = "Select * from caycanh";
		List<CayCanh> list = jdbcTemplate.query(sql, new CayCanhMapper());
		return list;
	}

	@Override
	public List<CayCanh> showListByML(int maloai) {
		String sql = "Select * from quanlykhocaycanh.caycanh where maloai=" + maloai + "";
		List<CayCanh> list = jdbcTemplate.query(sql, new CayCanhMapper());
		return list;
	}

	@Override
	public int add(CayCanh caycanh) throws IOException {
		String sql = "insert into caycanh(tencay,giacay,tonkho,hinhanh,mota,dvt,maloai) values(?,?,?,?,?,?,?)";
		byte[] photoBytes = caycanh.getPhoto().getBytes();
		int kq = jdbcTemplate.update(sql,
				new Object[] { caycanh.getTencay(), caycanh.getGiacay(), caycanh.getTonkho(), photoBytes,
						caycanh.getMota(), caycanh.getDvt(), caycanh.getMaloai() });
		return kq;
	}

	@Override
	public int delete(int macay) {
		String sql = "delete from quanlykhocaycanh.caycanh where macay = " + macay;
		int kq = jdbcTemplate.update(sql);
		return kq;
	}

	@Override
	public CayCanh findOne(int macay) {
		String sql = "select*from caycanh where macay=" + macay;
		List<CayCanh> list = new ArrayList<CayCanh>();
		list = jdbcTemplate.query(sql, new CayCanhMapper());

		return list.get(0);
	}

	@Override
	public int update(CayCanh caycanh) throws IOException {
		String query;
		byte[] photoBytes;
		int kq;
		if (!caycanh.getPhoto().isEmpty()) {
			photoBytes = caycanh.getPhoto().getBytes();
			query = "UPDATE `quanlykhocaycanh`.`caycanh` SET `tencay` = ?, `giacay` = ?, `tonkho` = ?, `hinhanh` = ?, `mota` = ?, `dvt` =?, `maloai` = ?  WHERE `macay` = ?";
			kq = jdbcTemplate.update(query,
					new Object[] { caycanh.getTencay(), caycanh.getGiacay(), caycanh.getTonkho(), photoBytes,
							caycanh.getMota(), caycanh.getDvt(), caycanh.getMaloai(), caycanh.getMacay() });
		} else {
			query = "UPDATE `quanlykhocaycanh`.`caycanh` SET `tencay` = ?, `giacay` = ?, `tonkho` = ?, `mota` = ?, `dvt` =?, `maloai` = ?  WHERE `macay` = ?";
			kq = jdbcTemplate.update(query,
					new Object[] { caycanh.getTencay(), caycanh.getGiacay(), caycanh.getTonkho(),
							caycanh.getMota(), caycanh.getDvt(), caycanh.getMaloai(), caycanh.getMacay() });
		}
		return kq;

	}

	@Override
	public List<CayCanh> findlistbyname(String tencay) {
		String sql = "SELECT * FROM caycanh where concat_ws('',macay,tencay,giacay,tonkho,mota,dvt,maloai) like '%"
				+ tencay + "%'";
		List<CayCanh> list = new ArrayList<CayCanh>();
		list = jdbcTemplate.query(sql, new CayCanhMapper());
		return list;
	}

	@Override
	public List<CayCanh> orderbyprice(int value) {
		if (value == 1) {
			String sql = "SELECT * FROM caycanh ORDER  BY giacay desc ";
			List<CayCanh> list = new ArrayList<CayCanh>();
			list = jdbcTemplate.query(sql, new CayCanhMapper());
			return list;
		} else {
			if (value == 2) {
				String sql = "SELECT * FROM caycanh ORDER  BY giacay asc ";
				List<CayCanh> list = new ArrayList<CayCanh>();
				list = jdbcTemplate.query(sql, new CayCanhMapper());
				return list;
			} else if (value == 3) {

				String sql = "SELECT * FROM caycanh ORDER  BY tonkho desc ";
				List<CayCanh> list = new ArrayList<CayCanh>();
				list = jdbcTemplate.query(sql, new CayCanhMapper());
				return list;
			} else if (value == 4) {

				String sql = "SELECT * FROM caycanh ORDER  BY tonkho asc ";
				List<CayCanh> list = new ArrayList<CayCanh>();
				list = jdbcTemplate.query(sql, new CayCanhMapper());
				return list;
			}
		}
		return null;

	}

	@Override
	public List<CayCanh> findAll() {
		String sql = "select * from caycanh";
		List<CayCanh> list = new ArrayList<CayCanh>();
		list = jdbcTemplate.query(sql, new CayCanhMapper());
		return list;
	}

	@Override
	public int updateInventoryByID(CayCanh caycanh, int macay) {
		String sql = "UPDATE `quanlykhocaycanh`.`caycanh` SET `tonkho` = ? WHERE `macay` = " + macay + "";
		return jdbcTemplate.update(sql, new Object[] { caycanh.getTonkho() });
	}
}
