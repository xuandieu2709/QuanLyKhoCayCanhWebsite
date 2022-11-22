package com.treemanage.Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.jdbc.Blob;
import com.treemanage.DTO.CTPhieuNhapDto;
import com.treemanage.DTO.CTPhieuXuatpDto;
import com.treemanage.Entity.BaoCao;
import com.treemanage.Entity.CTBaoCao;
import com.treemanage.Entity.CayCanh;
import com.treemanage.Entity.ChiTietPhieuNhap;
import com.treemanage.Entity.ChiTietPhieuXuat;
import com.treemanage.Entity.LoaiCay;
import com.treemanage.Entity.NhaCungCap;
import com.treemanage.Entity.PhieuNhap;
import com.treemanage.Entity.PhieuXuat;
import com.treemanage.Entity.taikhoan;
import com.treemanage.Service.CayCanhService;

@Controller
public class ManagementController extends Common {
    @Autowired
    CayCanhService cayCanhService;

    //
    public Boolean checkNullTKSession(HttpSession session) {
        if (!session.getAttribute("Account").equals(null)) {
            return false;
        }
        return true;

    }

    @GetMapping("manager-bonsai")
    public ModelAndView ManagementBonsai(Model model, HttpSession session) {
        if (checkNullTKSession(session) == true) {
            mv.setViewName("login");
            return mv;
        }
        List<CayCanh> list = cayCanhService.showList();
        List<NhaCungCap> list2 = NhaCungCapService.showList();
        List<LoaiCay> list3 = loaiCanhService.showlist();
        model.addAttribute("listNCC", list2);
        model.addAttribute("listCay", list);
        model.addAttribute("listLoaiCay", list3);
        model.addAttribute("number", 0);
        mv.addObject("messSreach", "");
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("manager-import")
    public ModelAndView importTicket(HttpSession session) {
        if (checkNullTKSession(session) == true) {
            mv.setViewName("login");
            return mv;
        }
        //
        if (checkNullTKSession(session) == true) {
            mv.setViewName("login");
            return mv;
        }
        taikhoan tk = taiKhoanService.findOne((String) session.getAttribute("Account"));
        if (tk.getVaitro().equals("3")) {
            mv.setViewName("403");
            return mv;
        }
        //
        List<PhieuNhap> list = phieuNhapService.showList();
        mv.addObject("listPhieu", list);
        mv.setViewName("import");
        CTPhieuNhapDto ctnhap = new CTPhieuNhapDto();
        for (int j = 0; j < 1; j++) {
            ctnhap.addCT(new ChiTietPhieuNhap());
        }
        ctnhap.addPhieu(new PhieuNhap());
        mv.addObject("form", ctnhap);
        mv.addObject("messSreach", "");
        return mv;
    }

    @PostMapping("/createLine")
    public ModelAndView Crearline(@ModelAttribute CTPhieuNhapDto form, @RequestParam("index") int index) {
        int x = form.getChiTietPhieuNhaps().size();
        // System.out.println(x);
        List<ChiTietPhieuNhap> list = form.getChiTietPhieuNhaps();
        for (int j = 0; j < index; j++) {
            list.add(new ChiTietPhieuNhap());
        }
        form.setChiTietPhieuNhaps(list);
        // ctnhap.addPhieu(new PhieuNhap());
        mv.addObject("form", form);
        mv.setViewName("import :: #divdetailsImport");
        return mv;
    }

    @PostMapping("/manager-import/showlistAdd")
    public ModelAndView showlistadd() {
        List<CayCanh> list = cayCanhService.showList();
        List<NhaCungCap> list1 = NhaCungCapService.showList();
        mv.addObject("listBonsai", list);
        mv.addObject("listSup", list1);
        mv.setViewName("import");
        return mv;
    }

    @GetMapping("manager-export")
    public ModelAndView exportTicket(HttpSession session) {
        if (checkNullTKSession(session) == true) {
            mv.setViewName("login");
            return mv;
        }
        List<PhieuXuat> list = phieuXuatService.showList();
        mv.addObject("listPhieu", list);
        CTPhieuXuatpDto ctxuat = new CTPhieuXuatpDto();
        for (int j = 0; j < 1; j++) {
            ctxuat.addDetailsPhieu(new ChiTietPhieuXuat());
        }
        // ctxuat.addPhieu(new PhieuXuat());
        mv.addObject("form", ctxuat);
        List<CayCanh> list1 = cayCanhService.showList();
        mv.addObject("listBonsai", list1);
        mv.addObject("messSreach", "");
        mv.setViewName("export");
        return mv;
    }

    @PostMapping("/createLine1")
    public ModelAndView Crearline1(@ModelAttribute CTPhieuXuatpDto form, @RequestParam("index") int index) {
        int x = form.getCTPhieuXuats().size();
        // System.out.println(x);
        List<ChiTietPhieuXuat> list = form.getCTPhieuXuats();
        for (int j = 0; j < index; j++) {
            list.add(new ChiTietPhieuXuat());
        }
        form.setCTPhieuXuats(list);
        mv.addObject("form", form);
        mv.setViewName("export :: #divdetailsExport");
        return mv;
    }

    @GetMapping("manager-report")
    public ModelAndView report(HttpSession session) {
        if (checkNullTKSession(session) == true) {
            mv.setViewName("login");
            return mv;
        }
        // taikhoan tk = taiKhoanService.findOne((String)
        // session.getAttribute("Account"));
        String role = (String) session.getAttribute("Role");
        System.out.println(role);
        if (!role.endsWith("0") && !role.endsWith("1")) {
            mv.setViewName("403");
            return mv;
        } else {

        }
        List<BaoCao> list = baoCaoService.showList();
        mv.addObject("list", list);
        mv.setViewName("report");
        mv.addObject("messSreach", "");
        return mv;
    }

    public boolean checkAccount(HttpSession session) {
        if (session.getAttribute("Account").equals("")) {
            return false;
        } else {
            return true;
        }
    }

    // manager-export
    /* add a person */
    @PostMapping("manager-export/addExport")
    public String createExport(PhieuXuat phieuXuat, @ModelAttribute CTPhieuXuatpDto form) {
        // adminService.addAdmin(admin);
        phieuXuatService.addExport(phieuXuat);

        PhieuXuat p = phieuXuatService.FindLastID();
        for (ChiTietPhieuXuat ct : form.getCTPhieuXuats()) {
            ct.setMaphieu(p.getMaphieu());
            ctPhieuXuatService.insertDetailsTicket(ct);
            CayCanh cay = cayCanhService.findOne(ct.getMacay());
            cay.setTonkho(cay.getTonkho() - ct.getSoluong()); // update inventory
            cayCanhService.updateInventoryByID(cay, cay.getMacay());

        }
        return "redirect:/manager-export";
    }

    /* show data edit to modal */
    @PostMapping("/manager-export/findDetailss")
    public ModelAndView findDetailss(@RequestParam("id") int id) {
        // System.out.println(id);
        List<ChiTietPhieuXuat> list = ctPhieuXuatService.FindByIDExport(id);
        PhieuXuat phieuXuat = phieuXuatService.findbyId(id).get(0);
        mv.addObject("phieu", phieuXuat);
        mv.addObject("listCT", list);
        //
        List<CayCanh> listcay = cayCanhService.showList();
        List<NhaCungCap> list1 = NhaCungCapService.showList();
        mv.addObject("listBonsai", listcay);
        mv.addObject("listSup", list1);
        mv.setViewName("export :: #listCT");
        return mv;
    }

    @PostMapping("/manager-export/findEdit")
    public ModelAndView findEditExport(@RequestParam("id") int id) {
        List<ChiTietPhieuXuat> list = ctPhieuXuatService.FindByIDExport(id);
        PhieuXuat phieuXuat = phieuXuatService.findbyId(id).get(0);
        CTPhieuXuatpDto ct = new CTPhieuXuatpDto();
        for (ChiTietPhieuXuat ct1 : list) {
            ct.addDetailsPhieu(ct1);
        }
        mv.addObject("phieuXuat", phieuXuat);
        // mv.addObject("listCT", list);
        mv.addObject("form", ct);
        //
        List<CayCanh> listcay = cayCanhService.showList();
        List<NhaCungCap> list1 = NhaCungCapService.showList();
        mv.addObject("listBonsai", listcay);
        mv.addObject("listSup", list1);
        mv.setViewName("export :: #listCTT");
        return mv;
    }

    /* edit a person */
    @PostMapping("/manager-export/editExport")
    public ModelAndView updateExport(PhieuXuat phieuXuat, @ModelAttribute CTPhieuXuatpDto form) {
        phieuXuatService.editExport(phieuXuat);
        for (ChiTietPhieuXuat ct : form.getCTPhieuXuats()) {
            //
            ChiTietPhieuXuat ctold = ctPhieuXuatService.FindByIDExport(phieuXuat.getMaphieu()).get(0);// chua sl cu
            CayCanh cay = cayCanhService.findOne(ctold.getMacay()); // cay.getTonkho : ton cu
            cay.setTonkho((cay.getTonkho() - ctold.getSoluong()) + ct.getSoluong());
            cayCanhService.updateInventoryByID(cay, cay.getMacay());
            ctPhieuXuatService.updateDetailsTicket(ct);
            System.out.println(ct.toString());
        }
        mv.setViewName("redirect:/manager-export");
        return mv;
    }

    @GetMapping("/manager-export/findExport")
    @ResponseBody
    public PhieuXuat findExport(int id) {
        PhieuXuat phieuXuat = phieuXuatService.findbyId(id).get(0);
        return phieuXuat;
    }

    /* Remove a persen */
    @GetMapping("/manager-export/removeExport")
    public String deleteExport(int id) {
        // adminService.removeAdmin(id);
        ctPhieuXuatService.deleteDetailsTicket(id);
        phieuXuatService.removeExport(id);
        return "redirect:/manager-export";
    }

    // @PostMapping("/manager-export/inventory")
    // public ModelAndView inventoryBonsai(@RequestParam("macay") int macay){
    // CayCanh cay = cayCanhService.findOne(macay);
    // // System.out.println(cay);
    // mv.addObject("inventoryBonsai", cay.getTonkho());
    // mv.setViewName("export :: #inventoryBonsai");
    // return mv;
    // }

    @PostMapping("/manager-export/search")
    public ModelAndView searchExport(String keyword) {
        if (keyword == "" || keyword == null) {
            List<PhieuXuat> list = phieuXuatService.showList();
            mv.addObject("listPhieu", list);
            mv.addObject("messSreach", "");
            mv.setViewName("export :: #listPhieu");
            return mv;
        } else {
            List<PhieuXuat> list = phieuXuatService.searchExport(keyword);
            mv.addObject("listPhieu", list);
            mv.setViewName("export :: #listPhieu");
            if (list.size() == 0) {
                mv.addObject("messSreach", "Không tìm thấy kết quả nào cho từ khóa của bạn");
            }else{
            mv.addObject("messSreach", "");
            }
            return mv;
        }

    }

    // manager Import

    @PostMapping("/manager-import/addImport")
    public String createImport(PhieuNhap PhieuNhap, @ModelAttribute CTPhieuNhapDto form) {
        // adminService.addAdmin(admin);
        phieuNhapService.addImport(PhieuNhap);
        PhieuNhap p = phieuNhapService.findFinalInsert().get(0);
        for (ChiTietPhieuNhap ct : form.getChiTietPhieuNhaps()) {
            ct.setMaphieu(p.getMaphieu());
            ctPhieuNhapService.insertDetailsTicket(ct);
            //
            CayCanh cay = cayCanhService.findOne(ct.getMacay());
            cay.setTonkho(cay.getTonkho() + ct.getSoluong());
            cayCanhService.updateInventoryByID(cay, ct.getMacay());
        }
        return "redirect:/manager-import";
    }

    /* edit a person */
    @PostMapping("/manager-import/editImport")
    public ModelAndView updateImport(PhieuNhap PhieuNhap, @ModelAttribute CTPhieuNhapDto form) {
        phieuNhapService.editImport(PhieuNhap);
        for (ChiTietPhieuNhap ct : form.getChiTietPhieuNhaps()) {
            ChiTietPhieuNhap ctold = ctPhieuNhapService.showList(PhieuNhap.getMaphieu()).get(0);// chua sl cu
            CayCanh cay = cayCanhService.findOne(ctold.getMacay()); // cay.getTonkho : ton cu
            cay.setTonkho((cay.getTonkho() - ctold.getSoluong()) + ct.getSoluong());
            cayCanhService.updateInventoryByID(cay, cay.getMacay());
            ctPhieuNhapService.updateDetailsTicket(ct);
            System.out.println(ct.toString());
        }
        mv.setViewName("redirect:/manager-import");
        return mv;
    }

    @GetMapping("/manager-import/findImport")
    @ResponseBody
    public PhieuNhap findImport(int id) {
        PhieuNhap PhieuNhap = phieuNhapService.findbyId(id).get(0);
        return PhieuNhap;
    }

    /* Remove a persen */
    @GetMapping("/manager-import/removeImport")
    public String deleteImport(int id) {
        // adminService.removeAdmin(id);
        ctPhieuNhapService.deleteDetailsTicket(id);
        phieuNhapService.removeImport(id);
        return "redirect:/manager-import";
    }

    @PostMapping("/manager-import/search")
    public ModelAndView searchImport(String keyword) {
        if (keyword == null || keyword == "") {
            List<PhieuNhap> list = phieuNhapService.showList();
            mv.addObject("listPhieu", list);
            mv.addObject("messSreach", "");
            System.out.println(list);
            mv.setViewName("import :: #listPhieu");
            return mv;
        } else {
            List<PhieuNhap> list = phieuNhapService.searchImport(keyword);
            mv.addObject("listPhieu", list);
            mv.setViewName("import :: #listPhieu");
            if (list.size() == 0) {
                mv.addObject("messSreach", "Không tìm thấy kết quả nào cho từ khóa của bạn");
            }else{
            mv.addObject("messSreach", "");
            }
            return mv;
        }
    }

    @PostMapping("/manager-import/findDetailss")
    public ModelAndView findDetails(@RequestParam("id") int id) {
        List<ChiTietPhieuNhap> list = ctPhieuNhapService.showList(id);
        PhieuNhap PhieuNhap = phieuNhapService.findbyId(id).get(0);
        mv.addObject("phieu", PhieuNhap);
        mv.addObject("listCT", list);
        //
        List<CayCanh> listcay = cayCanhService.showList();
        List<NhaCungCap> list1 = NhaCungCapService.showList();
        mv.addObject("listBonsai", listcay);
        mv.addObject("listSup", list1);
        mv.setViewName("import :: #listCT");
        return mv;
    }

    @PostMapping("/manager-import/findEdit")
    public ModelAndView findEdit(@RequestParam("id") int id) {
        List<ChiTietPhieuNhap> list = ctPhieuNhapService.showList(id);
        PhieuNhap PhieuNhap = phieuNhapService.findbyId(id).get(0);
        CTPhieuNhapDto ct = new CTPhieuNhapDto();
        for (ChiTietPhieuNhap ct1 : list) {
            ct.addCT(ct1);
        }
        mv.addObject("phieuNhap", PhieuNhap);
        // mv.addObject("listCT", list);
        mv.addObject("form", ct);

        //
        List<CayCanh> listcay = cayCanhService.showList();
        List<NhaCungCap> list1 = NhaCungCapService.showList();
        mv.addObject("listBonsai", listcay);
        mv.addObject("listSup", list1);
        mv.setViewName("import :: #listCTT");
        return mv;
    }

    @PostMapping("/manager-report/createReport")
    public ModelAndView createReport() {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        BaoCao bc = new BaoCao();
        bc.setNoidung("Thống kê hàng tồn(" + currentDateTime + ")");
        baoCaoService.InsertRP(bc);
        BaoCao bc1 = baoCaoService.FindReportByContent(bc.getNoidung());
        List<CayCanh> listCay = cayCanhService.showList();
        for (CayCanh cay : listCay) {
            CTBaoCao ct = new CTBaoCao();
            ct.setMaphieu(bc1.getMabaocao());
            ct.setMacay(cay.getMacay());
            ct.setSoluong(cay.getTonkho());
            ct.setGia(cay.getGiacay());
            ctBaoCaoService.InsertDeatailsRP(ct);
        }
        List<BaoCao> list = baoCaoService.showList();
        mv.addObject("list", list);
        mv.setViewName("report :: #listRP");
        return mv;
    }

    @PostMapping("/manager-report/detailsReport")
    public ModelAndView DetailsRP(@RequestParam("id") int id) {
        // List<ChiTietPhieuNhap> list = ctPhieuNhapService.showList(id);
        List<CTBaoCao> list = ctBaoCaoService.showListByIDReport(id);
        // PhieuNhap PhieuNhap = phieuNhapService.findbyId(id).get(0);
        BaoCao baocao = baoCaoService.findRPByID(id);

        mv.addObject("baocao", baocao);
        mv.addObject("listCT", list);
        mv.setViewName("report :: #listCT");
        mv.addObject("listCay", cayCanhService.showList());
        return mv;
    }

    @PostMapping("/manager-report/removeReport")
    public ModelAndView RemoveRP(@RequestParam("id") int id) {
        ctBaoCaoService.removeDetailsReport(id);
        baoCaoService.removeReport(id);
        List<BaoCao> list = baoCaoService.showList();
        mv.addObject("list", list);
        mv.setViewName("report :: #tableRP");
        return mv;
    }

    @PostMapping("/manager-report/searchReport")
    public ModelAndView searchRP(@RequestParam("keyword") String key) {
        if (key == null || key == "") {
            List<BaoCao> list = baoCaoService.showList();
            mv.addObject("list", list);
            mv.addObject("messSreach", "");
            mv.setViewName("report :: #listRP");
            return mv;
        } else {
            List<BaoCao> list = baoCaoService.searchRP(key);
            mv.addObject("list", list);
            if (list.size() == 0) {
                mv.addObject("messSreach", "Không tìm thấy kết quả nào cho từ khóa của bạn");
            }else{
            mv.addObject("messSreach", "");
            }
            mv.setViewName("report :: #listRP");
            return mv;
        }

    }

    /**/
    @PostMapping("/manager-bonsai/loaicay")
    public ModelAndView loaicay(@RequestParam("maloai") int maloai) {
        ModelAndView mv = new ModelAndView();
        System.out.println(maloai);
        mv.addObject("listCay", cayCanhService.showListByML(maloai));
        System.out.println(cayCanhService.showListByML(maloai));
        System.out.println("--------------");
        mv.setViewName("index :: #reloadcay");
        return mv;
    }

    @GetMapping("/load-image-cay/{macay}")
    public void load_image(@PathVariable("macay") int macay, HttpServletResponse response)
            throws IOException, SQLException {
        response.setContentType("image/jpeg");
        Blob ph = (Blob) cayCanhService.findOne(macay).getHinhanh();
        byte[] bytes = ph.getBytes(1, (int) ph.length());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }

    @PostMapping("/manager-addCayCanh")
    public ModelAndView createCayCanh(CayCanh caycanh) throws IOException {
        ModelAndView mv = new ModelAndView();
        cayCanhService.add(caycanh);
        mv.setViewName("redirect:/manager-bonsai");
        return mv;

    }

    @PostMapping("/load-modal-sua-cay")
    public ModelAndView load_modal_sua(@RequestParam("macay") int macay) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("cays", cayCanhService.findOne(macay));
        mv.addObject("listLoai", loaiCanhService.showlist());
        // System.out.println(cayCanhService.findOne(macay));
        mv.setViewName("index :: #sua_cay");
        return mv;
    }

    @PostMapping("/sua-cay")
    public ModelAndView load_modal_sua(CayCanh caycanh) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/manager-bonsai");
        cayCanhService.update(caycanh);
        return mv;
    }

    @PostMapping("/search")
    public ModelAndView news(@RequestParam("tencay") String tencay) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("caycanh", cayCanhService.findlistbyname(tencay));
        mv.setViewName("index :: #cay");
        return mv;
    }

    @PostMapping("/manager-bonsai/search_cay")
    public ModelAndView search_cay(@RequestParam("keyword") String search) {
        ModelAndView mv = new ModelAndView();
        if (search == null || search == "") {
            List<CayCanh> list = cayCanhService.showList();
            mv.addObject("listCay", list);
            mv.addObject("keyword", search);
            mv.setViewName("index :: #reloadcay");
            return mv;

        } else {
            List<CayCanh> list = cayCanhService.findlistbyname(search);
            mv.addObject("listCay", list);
            mv.addObject("keyword", search);
            if (list.size() == 0) {
                System.out.println(list.size());
                mv.addObject("messSreach", "Không tìm thấy kết quả nào cho từ khóa của bạn");
            }
            mv.setViewName("index :: #reloadcay");
            return mv;
        }
    }

    @PostMapping("/manager-bonsai/sortPriceASC")
    public ModelAndView sortPriceASC(@RequestParam("value") int value) {
        ModelAndView mv = new ModelAndView();
        List<CayCanh> list = cayCanhService.orderbyprice(value);
        mv.addObject("listCay", list);
        mv.setViewName("index :: #reloadcay");
        return mv;
    }

    @PostMapping("/xoa_cay")
    public ModelAndView xoa_cay(int macay) {
        ModelAndView mv = new ModelAndView();
        cayCanhService.delete(macay);
        mv.addObject("listCay", cayCanhService.showList());
        mv.setViewName("index :: #reloadcay");
        return mv;
    }

    @PostMapping("/manager-addnhacungcap")
    public ModelAndView createNhaCungCap(NhaCungCap nhacungcap) {
        NhaCungCapService.add(nhacungcap);
        mv.setViewName("redirect:/manager-bonsai");
        return mv;

    }

    @PostMapping("/load-modal-sua-nhacungcap")
    public ModelAndView load_modal_sua_nhacungcap(@RequestParam("manhacungcap") int manhacungcap) {

        mv.addObject("nhacungcap", NhaCungCapService.findOne(manhacungcap));
        // System.out.println(NhaCungCapService.findOne(manhacungcap));
        mv.setViewName("index :: #sua_nhacungcap");
        return mv;
    }

    @PostMapping("/sua-nhacungcap")
    public ModelAndView load_modal_sua_nhacungcap(NhaCungCap nhacungcap) {

        NhaCungCapService.update(nhacungcap);
        int x = NhaCungCapService.update(nhacungcap);
        if (x > 0) {
            System.out.println("OK");
        } else {
            System.out.println("ERRoR");
        }
        mv.setViewName("redirect:/manager-bonsai");
        return mv;
    }

    @PostMapping("/manager-bonsai/search_nhacungcap")
    public ModelAndView search_nhacungcap(@RequestParam("keywords") String searchs) {
        ModelAndView mv = new ModelAndView();
        if (searchs == null || searchs == "") {
            List<NhaCungCap> list = NhaCungCapService.showList();
            mv.addObject("listNCC", list);
            mv.addObject("keywords", searchs);
            mv.setViewName("index :: #nhacungcap");
            return mv;

        } else {
            List<NhaCungCap> list = NhaCungCapService.findlistbyname(searchs);
            mv.addObject("listNCC", list);
            mv.addObject("keywords", searchs);
            if (list.size() == 0) {
                System.out.println(list.size());
                mv.addObject("messSreach", "Không tìm thấy kết quả nào cho từ khóa của bạn");
            }
            mv.setViewName("index :: #nhacungcap");
            return mv;
        }
    }

    @PostMapping("/xoa_nhacungcap")
    public ModelAndView xoa_nhacungcap(int manhacungcap) {
        NhaCungCapService.delete(manhacungcap);
        mv.addObject("listNCC", NhaCungCapService.showList());
        mv.setViewName("index :: #nhacungcap");
        return mv;
    }

    /* manager-staff */
    @GetMapping("manager-user")
    public ModelAndView ManagementNguoiDung(Model model, HttpSession session) {
        if (checkNullTKSession(session) == true) {
            mv.setViewName("login");
            return mv;
        }
        // taikhoan tk = taiKhoanService.findOne((String)
        // session.getAttribute("Account"));
        String role = (String) session.getAttribute("Role");
        System.out.println(role);
        if (!role.endsWith("0")) {
            mv.setViewName("403");
            return mv;
        } else {

        }
        List<taikhoan> list4 = taiKhoanService.showList();

        model.addAttribute("listTK", list4);
        model.addAttribute("number", 0);
        mv.addObject("messSreach", "");
        mv.setViewName("staff");
        return mv;
    }

    @GetMapping("/load-image-user/{taikhoan}")
    public void load_image(@PathVariable("taikhoan") String taikhoan, HttpServletResponse response)
            throws IOException, SQLException {
        response.setContentType("image/jpeg");
        Blob ph = (Blob) taiKhoanService.findOne(taikhoan).getHinhanh();
        byte[] bytes = ph.getBytes(1, (int) ph.length());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }

    @PostMapping("/checkTaiKhoan")
    public ModelAndView checkTK(@PathVariable("taikhoan") String taikhoan) {
        System.out.println(taiKhoanService.CheckTaiKhoanAC(taikhoan));
        if (taiKhoanService.CheckTaiKhoanAC(taikhoan) == true) {
            mv.addObject("messAccount", "Tên đăng nhập đã tồn tại");
            mv.addObject("taikhoan", taikhoan);
            mv.setViewName("staff :: #add");
            return mv;
        }else{
            mv.addObject("taikhoan", taikhoan);
            mv.setViewName("staff");
            mv.addObject("messAccount", "");
            return mv;
        }
    }

    @PostMapping("/load-modal-infor-user")
    public ModelAndView load_modal_infor_user(HttpSession session) {
        String tk = (String) session.getAttribute("Account");
        System.out.println(tk);
        taikhoan tk1 = taiKhoanService.findOne(tk);
        System.out.println(tk1);
        mv.addObject("users", tk1);
        mv.setViewName("staff :: #infor");
        return mv;
    }

    @PostMapping("/manager-addUser")
    public ModelAndView createNguoiDung(taikhoan taikhoan) throws IOException {
        ModelAndView mv = new ModelAndView();
        taiKhoanService.add(taikhoan);
        mv.setViewName("redirect:/manager-user");
        return mv;

    }

    @PostMapping("/load-modal-sua-user")
    public ModelAndView load_modal_sua_user(@RequestParam("taikhoan") String taikhoan) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("users", taiKhoanService.findOne(taikhoan));
        System.out.println(taiKhoanService.findOne(taikhoan));
        mv.setViewName("staff :: #sua_user");
        return mv;
    }

    @PostMapping("/sua_user")
    public ModelAndView load_modal_sua_user(taikhoan taikhoan) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/manager-user");
        taiKhoanService.update(taikhoan);
        return mv;
    }

    @PostMapping("/xoa_user")
    public ModelAndView xoa_user(@RequestParam("taikhoan") String taikhoan) {
        ModelAndView mv = new ModelAndView();
        taiKhoanService.delete(taikhoan);
        mv.addObject("listTK", taiKhoanService.showList());
        mv.setViewName("staff :: #reloaduser");
        return mv;
    }

    @PostMapping("/manager-user/search_user")
    public ModelAndView search_user(@RequestParam("keyword") String search) {
        ModelAndView mv = new ModelAndView();
        if (search == null || search == "") {
            List<taikhoan> list = taiKhoanService.showList();
            mv.addObject("listTK", list);
            mv.addObject("keyword", search);
            mv.addObject("messSreach", "");
            mv.setViewName("staff :: #reloaduser");
            return mv;

        } else {
            List<taikhoan> list = taiKhoanService.findlistbyaccount(search);
            mv.addObject("listTK", list);
            mv.addObject("keyword", search);
            if (list.size() == 0) {
                System.out.println(list.size());
                mv.addObject("messSreach", "Không tìm thấy kết quả nào cho từ khóa của bạn");
            }
            mv.setViewName("staff :: #reloaduser");
            return mv;
        }
    }
    /* End */

    /* Loai cay */
    @PostMapping("/manager-addLoaicay")
    public ModelAndView createLoaiCay(LoaiCay loaicay) {
        ModelAndView mv = new ModelAndView();
        loaiCanhService.add(loaicay);
        mv.setViewName("redirect:/manager-bonsai");
        return mv;

    }

    @PostMapping("/load-modal-sualoaicay")
    public ModelAndView load_modal_sualoaicay(@RequestParam("maloai") int maloai) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("loaicays", loaiCanhService.findOne(maloai));
        System.out.println(loaiCanhService.findOne(maloai));
        mv.setViewName("index :: #sua_loaicay");
        return mv;
    }

    @PostMapping("/sua-loaicay")
    public ModelAndView load_modal_sualoaicay(LoaiCay loaicay) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/manager-bonsai");
        loaiCanhService.update(loaicay);
        return mv;
    }

    @PostMapping("/xoa_loaicay")
    public ModelAndView xoa_loaicay(int maloai) {
        ModelAndView mv = new ModelAndView();
        loaiCanhService.delete(maloai);
        mv.addObject("listLoaiCay", loaiCanhService.showlist());
        mv.setViewName("index :: #reloadloaicay");
        return mv;
    }
    /* end */
}
