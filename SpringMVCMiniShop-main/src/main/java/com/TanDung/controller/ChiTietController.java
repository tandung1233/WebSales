package com.TanDung.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.TanDung.entity.DanhMucSanPham;
import com.TanDung.entity.GioHang;
import com.TanDung.entity.SanPham;
import com.TanDung.service.DanhMucService;
import com.TanDung.service.SanPhamService;

@Controller
@RequestMapping("/chitiet")
@SessionAttributes("giohang")
public class ChiTietController {
	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	DanhMucService danhMucService;

	@GetMapping("/{masanpham}")
	@Transactional
	public String Default(@PathVariable int masanpham, ModelMap modelMap, HttpSession httpSession) {
//		List<SanPham> listSanPhams = sanPhamService.LayDanhSachChiTietSanPhamTheoMa(1);
//		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc();
//
//		SanPham sp = listSanPhams.get(0);
//		modelMap.addAttribute("sanPham", sp);
//		modelMap.addAttribute("danhMucs", danhMucSanPhams);
		List<SanPham> listSanPhams = sanPhamService.LayDanhSachChiTietSanPhamTheoMa(masanpham);
		SanPham sanPham = listSanPhams.get(0);
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc();
		for (DanhMucSanPham danhMucSanPham : danhMucSanPhams) {
			System.out.println(danhMucSanPham.getTendanhmuc());
		}

		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsanphamgiohang", gioHangs.size());
			System.out.println(gioHangs.size());
		}
		modelMap.addAttribute("danhMucs", danhMucSanPhams);
		modelMap.addAttribute("sanPham", sanPham);

		return "chitiet";
	}
}
