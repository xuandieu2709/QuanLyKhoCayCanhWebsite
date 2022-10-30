package com.treemanage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.treemanage.Service.BaoCaoService;
import com.treemanage.Service.CTBaoCaoService;
import com.treemanage.Service.CTPhieuNhapService;
import com.treemanage.Service.CTPhieuXuatService;
import com.treemanage.Service.CayCanhService;
import com.treemanage.Service.LoaiCayService;
import com.treemanage.Service.NhaCungCapService;
import com.treemanage.Service.PhieuNhapService;
import com.treemanage.Service.PhieuXuatService;
import com.treemanage.Service.TaiKhoanService;

public class Common {

    ModelAndView mv = new ModelAndView();

    @Autowired
    TaiKhoanService taiKhoanService;

    @Autowired
    CayCanhService cayCanhService;

    @Autowired
    PhieuNhapService phieuNhapService;

    @Autowired
    PhieuXuatService phieuXuatService;

    @Autowired
    NhaCungCapService NhaCungCapService;

    @Autowired
    BaoCaoService baoCaoService;

    @Autowired
    CTPhieuNhapService ctPhieuNhapService;
    @Autowired
    CTPhieuXuatService ctPhieuXuatService;
    @Autowired
    CTBaoCaoService ctBaoCaoService;
    @Autowired
    LoaiCayService loaiCanhService;
}
