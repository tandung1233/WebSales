package com.TanDung.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "HoaDon")
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mahoadon;
	private String tenkhachhang;
	private String sodt;
	private String diachigiaohang;
	private Boolean tinhtrang;
	private String ngaylap;
	private String hinhthucgiaohang;
	private String ghichu;

	public String getHinhthucgiaohang() {
		return hinhthucgiaohang;
	}

	public void setHinhthucgiaohang(String hinhthucgiaohang) {
		this.hinhthucgiaohang = hinhthucgiaohang;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "mahoadon")
	Set<ChiTietHoaDon> danhsachchitiethoadon;

	public Set<ChiTietHoaDon> getDanhsachchitiethoadon() {
		return danhsachchitiethoadon;
	}

	public void setDanhsachchitiethoadon(Set<ChiTietHoaDon> danhsachchitiethoadon) {
		this.danhsachchitiethoadon = danhsachchitiethoadon;
	}

	public int getMahoadon() {
		return mahoadon;
	}

	public void setMahoadon(int mahoadon) {
		this.mahoadon = mahoadon;
	}

	public String getTenkhachhang() {
		return tenkhachhang;
	}

	public void setTenkhachhang(String tenkhachhang) {
		this.tenkhachhang = tenkhachhang;
	}

	public String getSodt() {
		return sodt;
	}

	public void setSodt(String sodt) {
		this.sodt = sodt;
	}

	public String getDiachigiaohang() {
		return diachigiaohang;
	}

	public void setDiachigiaohang(String diachigiaohang) {
		this.diachigiaohang = diachigiaohang;
	}

	public Boolean getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(Boolean tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public String getNgaylap() {
		return ngaylap;
	}

	public void setNgaylap(String ngaylap) {
		this.ngaylap = ngaylap;
	}

}
