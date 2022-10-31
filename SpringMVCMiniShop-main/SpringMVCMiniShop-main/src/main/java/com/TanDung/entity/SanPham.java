package com.TanDung.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

//Hoc one to one hibernate sử dụng các anotision tên định danh
//Nhân viên có quan hệ 1 - n với sản phẩm
//Sản phẩm có quan hệ 1 - 1 với nhân viên
@Entity(name = "SanPham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSanPham;
	private String tenSanPham;
	private String giaTien;
//	private int idNhanVien;//Bỏ cái này bởi vì trùng tên cột
// cascade = CascadeType.ALL  nó thêm luôn cả nhân viên và sản phẩm
	@OneToOne(cascade = CascadeType.ALL) // Thêm cái này để nói rằng sản phẩm có quan hệ 1 - 1 với nhân viên
	@JoinColumn(name = "idNhanVien") // Thêm cái này để biết liên kết nhờ cột nào
	private NhanVien nhanVien;

	public String getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(String giaTien) {
		this.giaTien = giaTien;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public int getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

}
