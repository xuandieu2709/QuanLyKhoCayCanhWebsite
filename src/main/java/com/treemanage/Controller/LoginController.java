package com.treemanage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.treemanage.Entity.taikhoan;


@Controller
public class LoginController extends Common{
	
	@GetMapping({"/login","/"})
	public String home() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(taikhoan taikhoan,Model model) {
		taikhoan tk = taiKhoanService.dangnhap(taikhoan.getTaikhoan(), taikhoan.getMatkhau());
		System.out.println(tk.toString());
		if(tk.getMatkhau().equals("") && tk.getTaikhoan().equals("")) {
			model.addAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng");
			return "redirect:/login";
		}else {
			return "redirect:/manager-bonsai";
		}
	}
}