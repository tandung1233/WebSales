package com.TanDung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TanDung.entity.NhanVienCuDeHocThoi;

@Controller
@RequestMapping("/chitiet")
public class ChiTietController {
	@GetMapping
	public String Default() {

		return "chitiet";
	}

	@PostMapping
	public String HienThiThongTinNguoiDung(@ModelAttribute NhanVienCuDeHocThoi nv, ModelMap modelMap) {
		// Cái @ModelAttribute này để cho ngắn hơn thay vì chúng ta gọi @RequestParam
		// ten,@RequestParam tuoi,... ví dụ mình ghi rất nhiều thì nó rất dài và mình
		// dùng cái đó để nó lấy luôn đối tượng và mapping chúng với nhau
		// Nhưng nó chỉ lấy dữ liệu cơ bản thôi nhé String,int này nọ kiểu GiamDoc là nó
		// k map được. Đọc không hiểu thì xem lại video chế công bình
		// Lưu ý cái này là ta phải truyền đầy đủ time số cho nó ở lúc chúng ta nhập dữ
		// liệu nhé @ModelAttribute không thì sẽ lỗi
		modelMap.addAttribute("nv", nv);
		return "chitiet";
	}
}
