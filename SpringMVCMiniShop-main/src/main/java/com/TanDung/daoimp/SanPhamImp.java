package com.TanDung.daoimp;

import java.util.List;

import com.TanDung.entity.SanPham;

public interface SanPhamImp {
	List<SanPham> LayDanhSachSanPhamlimit(int spbatdau, int spketthuc);

	List<SanPham> LayDanhSachChiTietSanPhamTheoMa(int masanpham);

	List<SanPham> laySPTheoDanhMuc(int idDanhMuc);

	boolean XoaSpTheoMa(int id);

	boolean themSanPham(SanPham sanPham);
}
