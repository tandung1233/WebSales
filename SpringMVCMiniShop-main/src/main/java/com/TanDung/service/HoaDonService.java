package com.TanDung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TanDung.dao.HoaDonDao;
import com.TanDung.daoimp.HoaDonImp;
import com.TanDung.entity.HoaDon;

@Service
public class HoaDonService implements HoaDonImp {
	@Autowired
	HoaDonDao hoaDonDao;

	@Override
	public int ThemHoaDon(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		return hoaDonDao.ThemHoaDon(hoaDon);
	}

}
