package com.TanDung.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TanDung.entity.SanPham;
import com.TanDung.service.SanPhamService;

@Controller // Định danh cái trangchucontroller này là một Controller
@RequestMapping("/")
public class TrangChuController {
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	SanPhamService sanPhamService;

	@GetMapping
	@Transactional
	public String Default(ModelMap modelMap, HttpSession httpSession) {
		if (httpSession.getAttribute("email") != null) {
			String email = (String) httpSession.getAttribute("email");
			String chucaidau = email.substring(0, 1);
			modelMap.addAttribute("chucaidau", chucaidau);
		}
		List<SanPham> listSanPhams = sanPhamService.LayDanhSachSanPhamlimit(0, 20);
//		for (SanPham sanPham : listSanPhams) {
//			System.out.println(sanPham);
//		}
		modelMap.addAttribute("listSanPham", listSanPhams);
		return "trangchu";
	}

}
