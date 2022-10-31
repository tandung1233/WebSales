package com.TanDung.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TanDung.entity.NhanVien;
import com.TanDung.service.NhanVienService;

@Controller
@RequestMapping("dangnhap/")
//@SessionAttributes("email")// Cách 1: Muốn sử dụng session thì ghi đây
public class DangNhapController {
	@Autowired
	NhanVienService nhanVienService;

	@GetMapping
	public String Default() {// @SessionAttribute("email") String email Đây là cách 2 khi muốn sử dụng giá
								// trị session

		return "dangnhap";
	}

	// Cái này để check gmail xem người dùng nhập chuẩn hay không
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

//Xử lý chức năng đăng ký
	@PostMapping
	public String Dangky(@RequestParam String email, @RequestParam String matkhau, @RequestParam String nhaplaimatkhau,
			ModelMap modelmap) {
		boolean checkmail = validate(email);
		if (checkmail == true) {
			if (matkhau.equals(nhaplaimatkhau)) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setEmail(email);
				nhanVien.setTendangnhap(email);
				nhanVien.setMatkhau(matkhau);
				if (nhanVienService.ThemNhanVien(nhanVien)) {
					modelmap.addAttribute("kiemtradangnhap", "Tao tai khoan thanh cong");
				} else {
					modelmap.addAttribute("kiemtradangnhap", "Tao tai khoan that bai");
				}
			} else {
				modelmap.addAttribute("kiemtradangnhap", "Mật khẩu không trùng khớp");
			}
		} else {
			modelmap.addAttribute("kiemtradangnhap", "Vui lòng nhập đúng email");
		}
		return "dangnhap";
	}
//	@Autowired
//	NhanVienService nhanVienService;// Được bơm dữ liệu thẳng từ service giống IOC

//	@PostMapping
//	@Transactional
//	public String XuLyDangNhap(@RequestParam String email, @RequestParam String matkhau, ModelMap modelmap) {
////		Session session = sessionFactory.getCurrentSession();
////		try {
////			// Sử dụng cái getSingleResult hoặc getResultList
////			NhanVien nhanVien = (NhanVien) session
////					.createQuery("from NhanVien where tendangnhap='" + tendangnhap + "' and matkhau='" + matkhau + "'")
////					.getSingleResult();// getSingleResult Lấy 1 đối tượng nhân viên về
////			System.out.println("dang nhap thanh cong");
////		} catch (Exception e) {
////			System.out.println("dang nhap that bai");
////		}
//
////		if (nhanVienService.KiemTraDangNhap(email, matkhau) == true) {
////			modelmap.addAttribute("kiemtradangnhap", "Dang nhap thanh cong");
////		} else {
////			modelmap.addAttribute("kiemtradangnhap", "Dang nhap that bai");
////		}
//		return "dangnhap";
//	}
}
