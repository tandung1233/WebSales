package com.TanDung.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.TanDung.entity.ChiTietSanPham;
import com.TanDung.entity.DanhMucSanPham;
import com.TanDung.entity.GioHang;
import com.TanDung.entity.MauSanPham;
import com.TanDung.entity.SanPham;
import com.TanDung.entity.SizeSanPham;
import com.TanDung.service.NhanVienService;
import com.TanDung.service.SanPhamService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

//Class controller này đóng trò là api, class này chỉ được gọi bởi ajax
//Chỉ khai báo cá đường dẫn cho ajax lấy dữ liệu
@Controller
@RequestMapping("api/")
@SessionAttributes({ "email", "giohang" }) // Gọi cái này để sử dụng được session
public class ApiController {
	@Autowired
	NhanVienService nhanVienService;

	@Autowired
	SanPhamService spService;

	List<GioHang> gioHangs = new ArrayList<GioHang>();

	@GetMapping("KiemTraDangNhap")
	@ResponseBody
	public String KiemTraDangNhap(@RequestParam String email, @RequestParam String matkhau, ModelMap modelMap) {
		boolean KiemTra = nhanVienService.KiemTraDangNhap(email, matkhau) == true;
		modelMap.addAttribute("email", email);

		return "" + KiemTra;
	}

	private int kiemTraSPTonTaiGioHang(List<GioHang> listGioHangs, HttpSession httpSession, int masp, int mamau,
			int masize) {
		for (int i = 0; i < listGioHangs.size(); i++) {
			if (listGioHangs.get(i).getMasp() == masp && listGioHangs.get(i).getMamau() == mamau
					&& listGioHangs.get(i).getMasize() == masize) {
				return i;
			}
		}
		return -1;
	}

	// Tạo phương thức để lưu session
	@GetMapping("ThemGioHang")
	@ResponseBody
	public void ThemGioHang(@RequestParam String tensp, @RequestParam int maSp, @RequestParam int maSize,
			@RequestParam int maMau, @RequestParam int soLuong, @RequestParam String giaTien,
			@RequestParam String tenMau, @RequestParam String tenSize, HttpSession httpSession,
			@RequestParam int machitiet) {

		if (null == httpSession.getAttribute("giohang")) {
			List<GioHang> giohangs = new ArrayList<>();

			GioHang gioHang = new GioHang();
			gioHang.setGiatien(giaTien);
			gioHang.setMamau(maMau);
			gioHang.setMasize(maSize);
			gioHang.setMasp(maSp);
			gioHang.setSoluong(1);
			gioHang.setTenmau(tenMau);
			gioHang.setTensize(tenSize);
			gioHang.setTensp(tensp);
			gioHang.setMachitiet(machitiet);

			giohangs.add(gioHang);
			httpSession.setAttribute("giohang", giohangs);
		} else {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = kiemTraSPTonTaiGioHang(listGioHangs, httpSession, maSp, maMau, maSize);
			if (vitri == -1) {
				GioHang gioHang = new GioHang();
				gioHang.setGiatien(giaTien);
				gioHang.setMamau(maMau);
				gioHang.setMasize(maSize);
				gioHang.setMasp(maSp);
				gioHang.setSoluong(1);
				gioHang.setTenmau(tenMau);
				gioHang.setTensize(tenSize);
				gioHang.setTensp(tensp);
				gioHang.setMachitiet(machitiet);

				listGioHangs.add(gioHang);
			} else {
				int soluongMoi = listGioHangs.get(vitri).getSoluong() + 1;
				listGioHangs.get(vitri).setSoluong(soluongMoi);
			}
		}
		List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");

		System.out.println(listGioHangs.size());
		for (GioHang gioHang : listGioHangs) {
			System.out.println(gioHang.getMasp() + "-" + gioHang.getTenmau() + "-" + gioHang.getTensize() + ""
					+ gioHang.getSoluong());
		}
	}

	@GetMapping("laysoluonggiohang")
	@ResponseBody
	public String laySoLuongGioHang(HttpSession httpSession) {
		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			return gioHangs.size() + "";
		}
		return "";
	}

	@GetMapping("capnhatgiohang")
	@ResponseBody
	public void capNhatGioHang(HttpSession httpSession, @RequestParam int soluong, @RequestParam int masp,
			@RequestParam int mamau, @RequestParam int masize) {
		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = kiemTraSPTonTaiGioHang(listGioHangs, httpSession, masp, mamau, masize);
			listGioHangs.get(vitri).setSoluong(soluong);
		}
	}

	@GetMapping("xoagiohang")
	@ResponseBody
	public void xoagiohang(HttpSession httpSession, @RequestParam int masp, @RequestParam int mamau,
			@RequestParam int masize) {
		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = kiemTraSPTonTaiGioHang(listGioHangs, httpSession, masp, mamau, masize);
			listGioHangs.remove(vitri);
		}
	}

	@GetMapping(path = "laysplimit", produces = "plain/text;charset=utf-8")
	@ResponseBody
	public String laysplimit(@RequestParam int spBatDau) {
		String html = "";
		List<SanPham> lstSp = spService.LayDanhSachSanPhamlimit(spBatDau, 5);
		for (SanPham sanPham : lstSp) {
			html += "<tr>";
			html += "<td>\r\n" + "	<div class=\"checkbox\">\r\n" + "		<label>\r\n"
					+ "			<input type=\"checkbox\" class=\"checkboxsanpham\" value=\" " + sanPham.getMasanpham()
					+ "  \">\r\n" + "		</label>\r\n" + "	</div>\r\n" + "</td>";
			html += "<td class=\"tensp\" data-masp=\" " + sanPham.getMasanpham() + " + \"> " + sanPham.getTensanpham()
					+ "</td>";
			html += "<td class=\"giatien\" data-value=\"" + sanPham.getGiatien() + "\">" + sanPham.getGiatien()
					+ "</td>";
			html += "<td class=\"gianhcho\" data-value=\" " + sanPham.getGianhcho() + " \"> " + sanPham.getGianhcho()
					+ " </td>";
			html += "<td class=\"btn btn-warning capnhatsanpham\" data-id=\" " + sanPham.getMasanpham()
					+ " \">Sua</td>";
			html += "</tr>";
		}
		System.out.println("hello");
		return html;
	}

	@GetMapping(path = "xoasanpham", produces = "plain/text;charset=utf-8")
	@ResponseBody
	public String xoaSanPhamTheoMa(@RequestParam int id) {
		spService.XoaSpTheoMa(id);
		System.out.println("da xoa");
		return "";
	}

	@PostMapping("themsanpham")
	@ResponseBody
	public void themsanpham(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();

		JsonNode jsonObject;
		try {
			SanPham sanPham = new SanPham();
			DanhMucSanPham danhMucSanPham = new DanhMucSanPham();

			jsonObject = objectMapper.readTree(dataJson);
			danhMucSanPham.setMadanhmuc(jsonObject.get("danhMucSanPham").asInt());

			JsonNode jsonchitet = jsonObject.get("chiTietSanPhams");
			Set<ChiTietSanPham> lstChiTiet = new HashSet<>();
			for (JsonNode objchiTiet : jsonchitet) {
				ChiTietSanPham chiTietSanPham = new ChiTietSanPham();

				MauSanPham mauSanPham = new MauSanPham();
				mauSanPham.setMamau(objchiTiet.get("mau").asInt());

				SizeSanPham sizeSanPham = new SizeSanPham();
				sizeSanPham.setMasize(objchiTiet.get("size").asInt());

				chiTietSanPham.setMauSanPham(mauSanPham);
				;
				chiTietSanPham.setSizeSanPham(sizeSanPham);
				chiTietSanPham.setSoluong(objchiTiet.get("soluong").asInt());

				lstChiTiet.add(chiTietSanPham);
			}

			String tensp = jsonObject.get("tenSanPham").asText();
			String giatien = jsonObject.get("giaTien").asText();
			String mota = jsonObject.get("moTa").asText();
			String gianhcho = jsonObject.get("gianhCho").asText();
			String hinhsp = jsonObject.get("hinhSanPham").asText();

			sanPham.setChiTietSanPhams(lstChiTiet);
			sanPham.setDanhMucSanPham(danhMucSanPham);
			sanPham.setTensanpham(tensp);
			sanPham.setGiatien(giatien);
			sanPham.setMota(mota);
			sanPham.setGianhcho(gianhcho);
			sanPham.setHinhsanpham(hinhsp);

			spService.themSanPham(sanPham);
			System.out.println("them thanh cong");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
