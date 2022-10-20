package com.treemanage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.treemanage.Entity.CayCanh;
import com.treemanage.Entity.NhaCungCap;
import com.treemanage.Service.CayCanhService;

@Controller
public class ManagementController extends Common{
    @Autowired
    CayCanhService cayCanhService;

    @GetMapping("manager-bonsai")
    public String ManagementBonsai(Model model){
        List<CayCanh> list = cayCanhService.showList();
        List<NhaCungCap> list2 = NhaCungCapService.showList();
        
        model.addAttribute("listNCC", list2);
        model.addAttribute("listCay", list);
        model.addAttribute("number", 0);
        return "index";
    }
    @GetMapping("manager-import")
    public ModelAndView importTicket(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("import");
        return mv;
    }
    @GetMapping("manager-export")
    public ModelAndView exportTicket(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("export");
        return mv;
    }
    @GetMapping("manager-report")
    public ModelAndView report(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("report");
        return mv;
    }
}
