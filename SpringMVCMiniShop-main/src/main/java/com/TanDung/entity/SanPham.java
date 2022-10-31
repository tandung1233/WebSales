package com.TanDung.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "SanPham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int masanpham;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "madanhmuc")
	private DanhMucSanPham danhMucSanPham;
	private String tensanpham;
	private String giatien;
	private String mota;
	private String hinhsanpham;
	private String gianhcho;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // cascade = CascadeType.ALL để xóa cái này thì các
																	// sản phẩm tự động xóa theo
	@JoinColumn(name = "masanpham")
	Set<ChiTietSanPham> chiTietSanPhams;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ChiTietKhuyenMai", joinColumns = {
			@JoinColumn(name = "masanpham", referencedColumnName = "masanpham") }, inverseJoinColumns = {
					@JoinColumn(name = "makhuyenmai", referencedColumnName = "makhuyenmai") })
	Set<KhuyenMai> danhsachkhuyenmai;

	public Set<ChiTietSanPham> getChiTietSanPhams() {
		return chiTietSanPhams;
	}

	public void setChiTietSanPhams(Set<ChiTietSanPham> chiTietSanPhams) {
		this.chiTietSanPhams = chiTietSanPhams;
	}

	public Set<KhuyenMai> getDanhsachkhuyenmai() {
		return danhsachkhuyenmai;
	}

	public void setDanhsachkhuyenmai(Set<KhuyenMai> danhsachkhuyenmai) {
		this.danhsachkhuyenmai = danhsachkhuyenmai;
	}

	public String getGianhcho() {
		return gianhcho;
	}

	public void setGianhcho(String gianhcho) {
		this.gianhcho = gianhcho;
	}

	public int getMasanpham() {
		return masanpham;
	}

	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}

	public DanhMucSanPham getDanhMucSanPham() {
		return danhMucSanPham;
	}

	public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
		this.danhMucSanPham = danhMucSanPham;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getHinhsanpham() {
		return hinhsanpham;
	}

	public void setHinhsanpham(String hinhsanpham) {
		this.hinhsanpham = hinhsanpham;
	}

}
