package com.treemanage.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.treemanage.Entity.taikhoan;


@Controller
public class LoginController extends Common{
	
	@GetMapping({"/login","/"})
	public String home() {
		return "login";
	}
	
	@PostMapping("/login")
	public ModelAndView login(taikhoan taikhoan,Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		taikhoan tk = taiKhoanService.dangnhap(taikhoan.getTaikhoan(), taikhoan.getMatkhau());
		System.out.println(tk.toString());
		if(tk.getMatkhau().equals("") && tk.getTaikhoan().equals("")) {
			mv.addObject("messTB", "Tên đăng nhập hoặc mật khẩu không đúng");
			// model.addAttribute("messTB", "Tên đăng nhập hoặc mật khẩu không đúng");
			mv.setViewName("login");
			return mv;
		}else {
			session.setMaxInactiveInterval(60*60*24);
			session.setAttribute("Account", taikhoan.getTaikhoan());
			mv.setViewName("redirect:/manager-bonsai");
			return mv;
		}
	}
	public boolean checkAccount(HttpSession session){
		if(session.getAttribute("Account").equals("")){
			return false;
		}else{
			return true;
		}
	}
}