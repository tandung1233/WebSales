package com.TanDung.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

//1 nhân viên có thể thêm nhiều sản phẩm
@Entity(name = "nhanvien") // Cái @ này để chứng tỏ class này mapping với bảng nhanvien trong mysql
public class NhanVien {
	@Id
	@Column(name = "idNhanVien") // Nếu đặc tên không giống thì có cái @Column này còn có rồi thì khỏi
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Thêm cái này để chứng tỏ tự động tăng
	private int idNhanVien;
	private String tenNhanVien;
	private int tuoi;
//mối quân hệ 1 nhiều
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idNhanVien")
	private Set<SanPham> sanPhams;

	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public Set<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(Set<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

	public NhanVien(String tenNhanVien, int tuoi) {
		super();
		this.idNhanVien = idNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.tuoi = tuoi;
	}

	public int getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

}
