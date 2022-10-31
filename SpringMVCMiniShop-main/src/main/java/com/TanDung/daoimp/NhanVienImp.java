package com.TanDung.daoimp;

import com.TanDung.entity.NhanVien;

public interface NhanVienImp {
	boolean KiemTraDangNhap(String email, String matkhau);

	boolean ThemNhanVien(NhanVien nhanVien);
}
