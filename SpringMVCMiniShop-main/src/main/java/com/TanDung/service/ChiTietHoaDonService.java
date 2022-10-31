package com.TanDung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TanDung.dao.ChiTietHoaDonDao;
import com.TanDung.daoimp.ChiTietHoaDonImp;
import com.TanDung.entity.ChiTietHoaDon;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImp {
	@Autowired
	ChiTietHoaDonDao chiTietHoaDonDao;

	@Override
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		// TODO Auto-generated method stub
		return chiTietHoaDonDao.ThemChiTietHoaDon(chiTietHoaDon);
	}

}
