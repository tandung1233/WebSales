package com.TanDung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TanDung.dao.SanPhamDao;
import com.TanDung.daoimp.SanPhamImp;
import com.TanDung.entity.SanPham;

@Service
public class SanPhamService implements SanPhamImp {
	@Autowired
	SanPhamDao sanPhamDao;

	@Override
	public List<SanPham> LayDanhSachSanPhamlimit(int spbatdau, int spketthuc) {
		// TODO Auto-generated method stub
		return sanPhamDao.LayDanhSachSanPhamlimit(spbatdau, spketthuc);
	}

	@Override
	public List<SanPham> LayDanhSachChiTietSanPhamTheoMa(int masanpham) {

		return sanPhamDao.LayDanhSachChiTietSanPhamTheoMa(masanpham);
	}

	@Override
	public List<SanPham> laySPTheoDanhMuc(int idDanhMuc) {
		// TODO Auto-generated method stub
		return sanPhamDao.LayDanhSachChiTietSanPhamTheoMa(idDanhMuc);
	}

	@Override
	public boolean XoaSpTheoMa(int id) {
		// TODO Auto-generated method stub
		return sanPhamDao.XoaSpTheoMa(id);
	}

	@Override
	public boolean themSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDao.themSanPham(sanPham);
	}

}
