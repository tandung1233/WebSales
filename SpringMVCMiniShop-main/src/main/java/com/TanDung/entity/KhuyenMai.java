package com.TanDung.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "KhuyenMai")
public class KhuyenMai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int makhuyenmai;
	private String temkhuyenmai;
	private String thoigianbatdau;
	private String thoigianketthuc;
	private String mota;
	private String hinhthuckhuyenmai;
	private int giagiam;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ChiTietKhuyenMai", joinColumns = {
			@JoinColumn(name = "makhuyenmai", referencedColumnName = "makhuyenmai") }, inverseJoinColumns = {
					@JoinColumn(name = "masanpham", referencedColumnName = "masanpham") })
	private Set<SanPham> danhsachsanpham;

	public Set<SanPham> getDanhsachsanpham() {
		return danhsachsanpham;
	}

	public void setDanhsachsanpham(Set<SanPham> danhsachsanpham) {
		this.danhsachsanpham = danhsachsanpham;
	}

	public int getGiagiam() {
		return giagiam;
	}

	public void setGiagiam(int giagiam) {
		this.giagiam = giagiam;
	}

	public int getMakhuyenmai() {
		return makhuyenmai;
	}

	public void setMakhuyenmai(int makhuyenmai) {
		this.makhuyenmai = makhuyenmai;
	}

	public String getTemkhuyenmai() {
		return temkhuyenmai;
	}

	public void setTemkhuyenmai(String temkhuyenmai) {
		this.temkhuyenmai = temkhuyenmai;
	}

	public String getThoigianbatdau() {
		return thoigianbatdau;
	}

	public void setThoigianbatdau(String thoigianbatdau) {
		this.thoigianbatdau = thoigianbatdau;
	}

	public String getThoigianketthuc() {
		return thoigianketthuc;
	}

	public void setThoigianketthuc(String thoigianketthuc) {
		this.thoigianketthuc = thoigianketthuc;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getHinhthuckhuyenmai() {
		return hinhthuckhuyenmai;
	}

	public void setHinhthuckhuyenmai(String hinhthuckhuyenmai) {
		this.hinhthuckhuyenmai = hinhthuckhuyenmai;
	}

}
