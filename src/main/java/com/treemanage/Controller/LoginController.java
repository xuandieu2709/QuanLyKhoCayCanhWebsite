package com.treemanage.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.treemanage.Entity.taikhoan;

@Controller
public class LoginController extends Common {

	@GetMapping({ "/login", "/" })
	public String home() {
		return "login";
	}

	@PostMapping("/login")
	public ModelAndView login(taikhoan taikhoan, Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		boolean checkExist = taiKhoanService.CheckAccount(taikhoan.getTaikhoan(), taikhoan.getMatkhau());
		taikhoan tk = taiKhoanService.findOne(taikhoan.getTaikhoan());
		if (checkExist == true) {
			session.setAttribute("Account", taikhoan.getTaikhoan());
			session.setAttribute("Role", tk.getVaitro());
			System.out.println((String) session.getAttribute("Account") + " " + (String) session.getAttribute("Role"));
			session.setMaxInactiveInterval(60 * 60 * 24);
			if (tk.getVaitro().endsWith("0")) {
				mv.setViewName("redirect:/manager-user");
				return mv;
			}
			mv.setViewName("redirect:/manager-bonsai");
			return mv;
		} else {
			mv.addObject("messTB", "Tên đăng nhập hoặc mật khẩu không đúng");
			mv.setViewName("login");
			return mv;
		}
	}

	@GetMapping("/logout")
	public ModelAndView Logout(HttpSession session) {
		session.removeAttribute("Account");
		session.removeAttribute("Role");
		mv.setViewName("redirect:/login");
		return mv;
	}
	/* Change PassWord*/
	@PostMapping("/changePassWord")
	public ModelAndView changePassWord(@PathVariable("passOld")  String passOld,@PathVariable("passNew") String passNew ,HttpSession session){
		taikhoan tk = taiKhoanService.findOne((String)session.getAttribute("Role"));
		if(passOld == tk.getMatkhau()){
			tk.setMatkhau(passNew);
			taiKhoanService.changPass(tk);
		}
		mv.setViewName("index :: #");
		return mv;
	}
}