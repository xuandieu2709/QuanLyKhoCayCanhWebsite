package com.treemanage.Dao;

import java.io.IOException;
import java.util.List;

import com.treemanage.Entity.CayCanh;

public interface CayCanhDao {
	int add(CayCanh caycanh) throws IOException;
	
    List<CayCanh> showList();
    int delete(int Macay);
    CayCanh findOne(int macay);
	int update(CayCanh caycanh) throws IOException;
	List<CayCanh> findlistbyname(String tencay);
	List<CayCanh> showListByML(int maloai);
	List<CayCanh> orderbyprice(int value);
	List<CayCanh> findAll();
	int updateInventoryByID(CayCanh caycanh,int macay);
}
