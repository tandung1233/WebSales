package com.TanDung.entity;

import java.util.List;
import java.util.Properties;

public class NhanVienCuDeHocThoi {
	// Phải có getter và setter để bean đọc được
	private String tenNhanVien;
	private String diaChi;
	private int tuoi;
	List<String> list;// Nếu list là đối tượng thì xem lại video chế công bình

	Properties properties; // Cái này tương tư như list vậy

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public NhanVienCuDeHocThoi() {
		// TODO Auto-generated constructor stub
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	// Phương thức khởi tạo của bean
	public void Start() {
		System.out.println("Hello init");
	}

	// Phương thức hủy bỏ của bean
	public void Destroy() {
		System.out.println("Hello destroy");
	}

	public void getThongBao() {
		System.out.println("Hello đây là thông báo từ class nhanvien " + tenNhanVien);
	}

	// Phương thức khởi tạo nhân viên thay vì ta khởi tạo NhanVien nv = new NhanVien
	// thì ta nv = NhanVien.createNhanVien();
	public static NhanVienCuDeHocThoi createNhanVien() {
		NhanVienCuDeHocThoi nv = new NhanVienCuDeHocThoi();
		nv.setTenNhanVien("Phan Anh Thu");
		return nv;
	}

	@Override
	public String toString() {
		return "NhanVien [tenNhanVien=" + tenNhanVien + ", diaChi=" + diaChi + ", tuoi=" + tuoi + ", list=" + list
				+ ", properties=" + properties + "]";
	}

}
