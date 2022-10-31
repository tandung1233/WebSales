package com.TanDung.controller;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TanDung.entity.NhanVien;
import com.TanDung.entity.SanPham;

@Controller // Định danh cái trangchucontroller này là một Controller
@RequestMapping("/")
public class TrangChuController {
	/*
	 * @RequestMapping("/") // Khi người dùng nhập dấu / sẽ vào hàm này
	 * // @ResponseBody//Cho phép trả về nội dung text, cái responsebody này trả dữ
	 * liệu text ở trên trang web luôn mà mình trả về trang jsp rồi nên bỏ đi //
	 * public String ViewTrangChu() { // return "Hello Body"; // } public String
	 * TrangChu() { return "abc";// Trả về view }
	 */

	/*
	 * @RequestMapping("/")
	 * 
	 * @ResponseBody public String TrangChu() { ApplicationContext context = new
	 * ClassPathXmlApplicationContext("IoC.xml");// Truy xuất các IOC đã // lưu sẵn
	 * trong khung // chứa xml đó NhanVien nv = context.getBean(NhanVien.class);
	 * 
	 * nv.getThongBao(); for (String value : nv.getList()) {
	 * System.out.println(value); }
	 * 
	 * System.out.println(nv.getProperties().getProperty("jdbc")); return "abc"; }
	 */

//	Có 2 cách truyền dữ liệu từ Controller sang view
// Lưu ý truyền này thì dữ liệu phải getAtribute còn mà truyền dữ liệu có trên thành url thì lấy giá trị bằng getparametter
//	@RequestMapping("/")
	/*
	 * @RequestMapping(path = "/", method = RequestMethod.GET) // Mặc định method sẽ
	 * là Get rồi nên ghi hay không củng được public String TrangChu(ModelMap
	 * modelMap) { String user = "Nguyen Tan Dung"; // user và pass này ví dụ như là
	 * ta đã lấy được từ model String pass = "123456";
	 * 
	 * // Đây là cách thứ 1 dùng modelAndView; // ModelAndView modelAndView = new
	 * ModelAndView(); // // modelAndView.setViewName("trangchu"); //
	 * modelAndView.addObject("tendangnhap", user); //
	 * modelAndView.addObject("pass", pass); //
	 * modelAndView.addObject(modelAndView); // return modelAndView;
	 * 
	 * NhanVien nv = new NhanVien(); nv.setDiaChi("Hue");
	 * nv.setTenNhanVien("Tan Dung");
	 * 
	 * // Cách thứ 2 là sử dụng modelMap modelMap.addAttribute("tendangnhap", user);
	 * modelMap.addAttribute("pass", pass); modelMap.addAttribute("nhanvien", nv);
	 * return "trangchu"; }
	 * 
	 * // Cái này cách cũ sử dụng requestParam nhược điệm lộ id này nọ ví dụ:
	 * fb.com/id=5/name=dung // @RequestMapping("/chitiet") // Truyền id trên url
	 * trình duyệt với id kiểu int ghi dưới vậy là phải bắt buộc // // có giá trị id
	 * // public String ChiTiet(@RequestParam("id") int id, @RequestParam("tensp")
	 * String tensp, ModelMap modelMap) { // modelMap.addAttribute("id", id); //
	 * modelMap.addAttribute("tensp", tensp); // return "chitiet"; // }
	 * 
	 * // Cái PathVariable này an toàn hơn không lộ thuộc tính ví dụ: fb.com/5/dung
	 * 
	 * @RequestMapping("/chitiet/{id}/{tensp}") // Truyền id trên url trình duyệt
	 * với id kiểu int ghi dưới vậy là phải bắt // buộc // có giá trị id public
	 * String GetChiTiet(@PathVariable("id") int id, @PathVariable("tensp") String
	 * tensp, ModelMap modelMap) { modelMap.addAttribute("id", id);
	 * modelMap.addAttribute("tensp", tensp); return "chitiet"; }
	 * 
	 * @RequestMapping(path = "/chitiet", method = RequestMethod.POST) public String
	 * PostChiTiet(@RequestParam String name, ModelMap modelMap) {
	 * 
	 * modelMap.addAttribute("name", name);
	 * 
	 * return "chitiet"; }
	 */
	@Autowired // Cái aotuwired này sẽ lấy giá trị trong IOC luôn mà phải đặt giống tên nhé nó
	// sẽ lấy các giá trị đã khởi tọ trong file xml rồi mapping vào
	SessionFactory sessionFactory;

	// Viết Class chuẩn ở trên mình viết ví dụ để học các thuộc tính này nọ thôi
	@GetMapping // Cái này tương đương với @RequestMapping(path = "/", method =
				// RequestMethod.GET) ghi anotision vậy cho gọn
//	public String Default(ModelMap modelMap) {
//		modelMap.addAttribute("ten", "Tan Dũng");
//		modelMap.addAttribute("tuoi", 22);
//		return "trangchu";
//	}
	@Transactional // Khai báo cái này để ta đỡ khỏi phải sử dụng begin và close transaction
	public String Default() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
//		DatabaseThoiTrang databaseThoiTrang = (DatabaseThoiTrang) context.getBean("databasethoitrang");
//		databaseThoiTrang.getListNhanVien();

		// Sử dụng hibernay
		Session session = sessionFactory.getCurrentSession();
		// Cái này là hiển thị list nhân viên
		/*
		 * String sql = "from nhanvien"; List<NhanVien> list =
		 * session.createQuery(sql).getResultList(); for (NhanVien nhanVien : list) {
		 * System.out.println(nhanVien); }
		 */
		// Thêm nhân viên bằng session
//		NhanVien nobita = new NhanVien("Nobita", 30);
//		session.save(nobita);

		// Cách update dữ liệu thứ 1 đơn giản nhất
//		NhanVien xeko = new NhanVien("dung", 1000);
//		xeko.setIdNhanVien(7);
//		xeko.setTuoi(1001);
//		session.update(xeko);
		// Cách 2 update dữ liệu nhớ có constructor mặc định không là lỗi
//		NhanVien xeko = (NhanVien) session.createQuery("from nhanvien where idNhanVien = 7").uniqueResult();
//		xeko.setTuoi(500);
//		session.update(xeko);
		// Cách 3 update
//		NhanVien xeko = session.get(NhanVien.class, 7);
//		xeko.setTuoi(506);
//		session.update(xeko);

		// Xóa dữ liệu bằng hibernate
//		NhanVien xeko = session.get(NhanVien.class, 8);
//		session.delete(xeko);

		// Hoc one to one
//		SanPham sanPham = new SanPham();
//		sanPham.setTenSanPham("Ga ran");
//		sanPham.setGiaTien("100.000 VND");
//
//		NhanVien nhanVien = new NhanVien();
//		nhanVien.setTenNhanVien("Che cong binh");
//		nhanVien.setTuoi(18);
//		sanPham.setNhanVien(nhanVien);
//		session.save(sanPham);
		// Hoc one to many
		SanPham sanPham = new SanPham();
		sanPham.setTenSanPham("Banh my");
		sanPham.setGiaTien("100.000 VND");

		SanPham sanPham1 = new SanPham();
		sanPham1.setTenSanPham("Banh bao");
		sanPham1.setGiaTien("100.000 VND");

		SanPham sanPham2 = new SanPham();
		sanPham2.setTenSanPham("Banh u");
		sanPham2.setGiaTien("100.000 VND");

		Set<SanPham> sanPhams = new HashSet<SanPham>();
		sanPhams.add(sanPham);
		sanPhams.add(sanPham1);
		sanPhams.add(sanPham2);

		NhanVien nhanVien = new NhanVien();
		nhanVien.setTenNhanVien("Le van banh");
		nhanVien.setTuoi(18);

		nhanVien.setSanPhams(sanPhams);

		session.save(nhanVien);
		return "trangchu";
	}

	// Thêm nhân viên bằng hibernate
	@PostMapping
	@Transactional
	public String ThemNhanVien(@RequestParam String tenNhanVien, @RequestParam int tuoi) {
		Session session = sessionFactory.getCurrentSession();
		NhanVien nobita = new NhanVien(tenNhanVien, tuoi);
		session.save(nobita);
		return "trangchu";
	}

	@GetMapping("/{hoten}")
	public String ThemDuongDan(@PathVariable String hoten, ModelMap modelMap) {
		modelMap.addAttribute("hoten", hoten);

		return "trangchu";
	}
}
