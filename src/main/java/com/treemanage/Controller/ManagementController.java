package com.treemanage.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.treemanage.Entity.BaoCao;
import com.treemanage.Entity.CayCanh;
import com.treemanage.Entity.NhaCungCap;
import com.treemanage.Entity.PhieuNhap;
import com.treemanage.Entity.PhieuXuat;
import com.treemanage.Service.CayCanhService;

@Controller
public class ManagementController extends Common{
    @Autowired
    CayCanhService cayCanhService;
    

    @GetMapping("manager-bonsai")
    public String ManagementBonsai(Model model,HttpSession session){
        // if(checkAccount(session) == true){
        List<CayCanh> list = cayCanhService.showList();
        List<NhaCungCap> list2 = NhaCungCapService.showList();
        
        model.addAttribute("listNCC", list2);
        model.addAttribute("listCay", list);
        model.addAttribute("number", 0);
        return "index";
    }
    @GetMapping("manager-import")
    public ModelAndView importTicket(){
        List<PhieuNhap> list = phieuNhapService.showList();
        mv.addObject("listPhieu", list);
        mv.setViewName("import");
        return mv;
    }
    @GetMapping("manager-export")
    public ModelAndView exportTicket(){
        List<PhieuXuat> list = phieuXuatService.showList();
        mv.addObject("listPhieu", list);
        mv.setViewName("export");
        return mv;
    }
    @GetMapping("manager-report")
    public ModelAndView report(){
        List<BaoCao> list = baoCaoService.showList();
        mv.addObject("list", list);
        mv.setViewName("report");
        return mv;
    }
    
	public boolean checkAccount(HttpSession session){
		if(session.getAttribute("Account").equals("")){
			return false;
		}else{
			return true;
		}
	}
    // manager-export
    /* add a person */
    @PostMapping("manager-export/addExport")
    public String createExport(PhieuXuat phieuXuat) {
        // adminService.addAdmin(admin);
        phieuXuatService.addExport(phieuXuat);
        return "redirect:/manager-export";
    }

    /* edit a person */
    @PostMapping("/manager-export/editExport")
    public ModelAndView updateExport(PhieuXuat phieuXuat) {
        // int a = adminService.editAdmin(admin);
        // // if(a>0){
        // //     System.out.println("Sua thanh cong");
        // // }else{
        // //     System.out.println("Sua that bai");
        // // }
        phieuXuatService.editExport(phieuXuat);
        mv.setViewName("redirect:/manager-export");
		return mv;
    }
    

    @GetMapping("/manager-export/findExport")
    @ResponseBody
    public PhieuXuat findExport(int id) {
        PhieuXuat phieuXuat = phieuXuatService.findbyId(id).get(0);
        return phieuXuat;
    }

    /* Remove a persen*/
    @GetMapping("/manager-export/removeExport")
	public String deleteExport(int id) {
		// adminService.removeAdmin(id);
        phieuXuatService.removeExport(id);
		return "redirect:/manager-export";
	}

    @PostMapping("/manager-export/search")
    public ModelAndView searchExport(String keyword) {
        List<PhieuXuat> list = phieuXuatService.searchExport(keyword);
        mv.addObject("listPhieu", list);
        mv.setViewName("export :: #listPhieu");
        return mv;
    }

    // manager Import
    
    @PostMapping("manager-import/addImport")
    public String createImport(PhieuNhap PhieuNhap) {
        // adminService.addAdmin(admin);
        phieuNhapService.addImport(PhieuNhap);
        return "redirect:/manager-import";
    }

    /* edit a person */
    @PostMapping("/manager-import/editImport")
    public ModelAndView updateImport(PhieuNhap PhieuNhap) {
        phieuNhapService.editImport(PhieuNhap);
        mv.setViewName("redirect:/manager-import");
		return mv;
    }
    

    @GetMapping("/manager-import/findImport")
    @ResponseBody
    public PhieuNhap findImport(int id) {
        PhieuNhap PhieuNhap = phieuNhapService.findbyId(id).get(0);
        return PhieuNhap;
    }

    /* Remove a persen*/
    @GetMapping("/manager-import/removeImport")
	public String deleteImport(int id) {
		// adminService.removeAdmin(id);
        phieuNhapService.removeImport(id);
		return "redirect:/manager-import";
	}

    @PostMapping("/manager-import/search")
    public ModelAndView searchImport(String keyword) {
        List<PhieuNhap> list = phieuNhapService.searchImport(keyword);
        mv.addObject("listPhieu", list);
        mv.setViewName("import :: #listPhieu");
        return mv;
    }
}
