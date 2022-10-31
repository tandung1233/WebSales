package com.TanDung.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "ChiTietHoaDon")
public class ChiTietHoaDon {
	@EmbeddedId
	private ChiTietHoatDonid chiTietHoatDonid;
	private int soluong;
	private String giatien;

	public ChiTietHoatDonid getChiTietHoatDonid() {
		return chiTietHoatDonid;
	}

	public void setChiTietHoatDonid(ChiTietHoatDonid chiTietHoatDonid) {
		this.chiTietHoatDonid = chiTietHoatDonid;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

}
