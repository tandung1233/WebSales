package com.TanDung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TanDung.entity.DanhMucSanPham;
import com.TanDung.service.DanhMucService;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {

	@Autowired
	DanhMucService danhmucService;

	@GetMapping("/{id}")
	public String Default(ModelMap modelMap, @PathVariable int id) {

		List<DanhMucSanPham> danhMucSanPhams = danhmucService.LayDanhMuc();
		modelMap.addAttribute("danhMucs", danhMucSanPhams);

		return "sanpham";
	}
}
