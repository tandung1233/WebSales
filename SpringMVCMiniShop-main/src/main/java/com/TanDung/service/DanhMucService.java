package com.TanDung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TanDung.dao.DanhMucDao;
import com.TanDung.daoimp.DanhMucImp;
import com.TanDung.entity.DanhMucSanPham;

@Service
public class DanhMucService implements DanhMucImp {
	@Autowired
	DanhMucDao danhMucDao;

	@Override
	public List<DanhMucSanPham> LayDanhMuc() {
		// TODO Auto-generated method stub
		return danhMucDao.LayDanhMuc();
	}

}
