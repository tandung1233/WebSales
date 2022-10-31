package com.TanDung.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TanDung.entity.ChiTietHoaDon;
import com.TanDung.entity.ChiTietHoatDonid;
import com.TanDung.entity.GioHang;
import com.TanDung.entity.HoaDon;
import com.TanDung.service.ChiTietHoaDonService;
import com.TanDung.service.HoaDonService;

@Controller
@RequestMapping("/gio-hang")
public class GioHangController {

	@Autowired
	private HoaDonService hoaDonService;

	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;

	@GetMapping
	public String Default(HttpSession httpSession, ModelMap modelMap) {
		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsanphamgiohang", gioHangs.size());
			modelMap.addAttribute("giohang", gioHangs);
		}

		return "giohang";
	}

//	@PostMapping
//	public String themHoaDon(HttpSession httpSession, @RequestParam String tenKhachHang, @RequestParam String sdt,
//			@RequestParam String diaChiGiaoHang, @RequestParam String hinhThucGiaoHang, @RequestParam String ghiChu) {
////		if (null != httpSession.getAttribute("giohang")) {
////			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
////
////			HoaDon hoaDon = new HoaDon();
////			hoaDon.setTenkhachhang(tenKhachHang);
////			hoaDon.setSodt(sdt);
////			hoaDon.setDiachigiaohang(diaChiGiaoHang);
////			hoaDon.setHinhThucGiaoHang(hinhThucGiaoHang);
////			hoaDon.setGhiChu(ghiChu);
////
////			int idHoadon = hoaDonService.themHoaDon(hoaDon);
////			if (idHoadon > 0) {
////				Set<ChiTietHoaDon> listChiTietHoaDons = new HashSet<>();
////
////				for (GioHang gioHang : gioHangs) {
////					ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
////					chiTietHoaDonId.setChiTietSanPhamId(gioHang.getMaChiTiet());
////					chiTietHoaDonId.setHoaDonID(hoaDon.getId());
////
////					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
////					chiTietHoaDon.setChiTietHoaDonId(chiTietHoaDonId);
////					chiTietHoaDon.setGiaTien(gioHang.getGiaTien().toString());
////					chiTietHoaDon.setSoLuong(gioHang.getSoLuong());
////
////					chiTietHoaDonService.themChiTietHoaDon(chiTietHoaDon);
////				}
////			} else {
////				System.out.println("them that bai");
////			}
////		}
//
//		return "giohang";
//	}

	@PostMapping
	public String themHoaDon(HttpSession httpSession, @RequestParam String tenKhachHang, @RequestParam String sdt,
			@RequestParam String diaChiGiaoHang, @RequestParam String hinhThucGiaoHang, @RequestParam String ghiChu) {
		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");

			HoaDon hoaDon = new HoaDon();
			hoaDon.setTenkhachhang(tenKhachHang);
			hoaDon.setSodt(sdt);
			hoaDon.setDiachigiaohang(diaChiGiaoHang);
			hoaDon.setHinhthucgiaohang(hinhThucGiaoHang);
			hoaDon.setGhichu(ghiChu);

			int idHoadon = hoaDonService.ThemHoaDon(hoaDon);
			if (idHoadon > 0) {
				Set<ChiTietHoaDon> listChiTietHoaDons = new HashSet<>();

				for (GioHang gioHang : gioHangs) {
					ChiTietHoatDonid chiTietHoaDonId = new ChiTietHoatDonid();
					chiTietHoaDonId.setMachitietsanpham(gioHang.getMachitiet());
					chiTietHoaDonId.setMahoadon(hoaDon.getMahoadon());

					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
					chiTietHoaDon.setChiTietHoatDonid(chiTietHoaDonId);
					chiTietHoaDon.setGiatien(gioHang.getGiatien().toString());
					chiTietHoaDon.setSoluong(gioHang.getSoluong());

					chiTietHoaDonService.ThemChiTietHoaDon(chiTietHoaDon);
				}
			} else {
				System.out.println("them that bai");
			}
		}

		return "giohang";
	}
}
