package com.TanDung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TanDung.dao.MauSanPhamDAO;
import com.TanDung.daoimp.MauSanPhamImp;
import com.TanDung.entity.MauSanPham;

@Service
public class MauSanPhamService implements MauSanPhamImp {

	@Autowired
	MauSanPhamDAO mauSanPhamDAO;

	@Override
	public List<MauSanPham> layDsMau() {

		return mauSanPhamDAO.layDsMau();
	}

}
