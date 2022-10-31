package com.TanDung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TanDung.dao.NhanVienDao;
import com.TanDung.daoimp.NhanVienImp;
import com.TanDung.entity.NhanVien;

@Service
public class NhanVienService implements NhanVienImp {
	@Autowired
	NhanVienDao nhanVienDao;

	@Override
	public boolean KiemTraDangNhap(String email, String matkhau) {
		return nhanVienDao.KiemTraDangNhap(email, matkhau);
	}

	@Override
	public boolean ThemNhanVien(NhanVien nhanVien) {
		return nhanVienDao.ThemNhanVien(nhanVien);
	}

}
