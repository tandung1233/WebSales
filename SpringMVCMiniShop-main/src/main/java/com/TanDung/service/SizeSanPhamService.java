package com.TanDung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TanDung.dao.SizeSanPhamDAO;
import com.TanDung.daoimp.SizeSanPhamImp;
import com.TanDung.entity.SizeSanPham;

@Service
public class SizeSanPhamService implements SizeSanPhamImp {

	@Autowired
	SizeSanPhamDAO sizeSanPhamDAO;

	@Override
	public List<SizeSanPham> layDsSize() {

		return sizeSanPhamDAO.layDsSize();
	}

}
