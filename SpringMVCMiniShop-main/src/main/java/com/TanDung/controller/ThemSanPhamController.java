package com.TanDung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TanDung.entity.DanhMucSanPham;
import com.TanDung.entity.MauSanPham;
import com.TanDung.entity.SanPham;
import com.TanDung.entity.SizeSanPham;
import com.TanDung.service.DanhMucService;
import com.TanDung.service.MauSanPhamService;
import com.TanDung.service.SanPhamService;
import com.TanDung.service.SizeSanPhamService;

@Controller
@RequestMapping("/themsanpham")
public class ThemSanPhamController {

	@Autowired
	SanPhamService spService;

	@Autowired
	DanhMucService danhmucService;

	@Autowired
	SizeSanPhamService sizeSanPhamService;

	@Autowired
	MauSanPhamService mauSanPhamService;

	@GetMapping
	public String Default(ModelMap modelMap) {
		List<SanPham> lstsp = (List<SanPham>) spService.LayDanhSachSanPhamlimit(0, 5);
		List<SanPham> allSp = (List<SanPham>) spService.LayDanhSachSanPhamlimit(-1, 5);
		List<DanhMucSanPham> danhMucSanPhams = danhmucService.LayDanhMuc();
		List<SizeSanPham> sizeSanPhams = (List<SizeSanPham>) sizeSanPhamService.layDsSize();
		List<MauSanPham> mauSanPhams = (List<MauSanPham>) mauSanPhamService.layDsMau();

		double tongSp = Math.ceil((double) allSp.size() / 5);
		modelMap.addAttribute("lstsp", lstsp);
		modelMap.addAttribute("allSp", allSp);
		modelMap.addAttribute("tongSp", tongSp);
		modelMap.addAttribute("danhMucs", danhMucSanPhams);
		modelMap.addAttribute("sizeSanPhams", sizeSanPhams);
		modelMap.addAttribute("mauSanPhams", mauSanPhams);
		return "themsanpham";
	}
}
