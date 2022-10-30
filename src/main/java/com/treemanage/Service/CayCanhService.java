package com.treemanage.Service;

import java.io.IOException;
import java.util.List;

import com.treemanage.Entity.CayCanh;

public interface CayCanhService {
    List<CayCanh> showList();
    int add(CayCanh caycanh) throws IOException;
    int update(CayCanh caycanh) throws IOException;
    int delete(int macay);
    CayCanh findOne(int macay);
    List<CayCanh> findlistbyname(String tencay);
    List<CayCanh> showListByML(int maloai);
    List<CayCanh> orderbyprice(int value);
	List<CayCanh> findAll();
    int updateInventoryByID(CayCanh caycanh,int macay);
}
