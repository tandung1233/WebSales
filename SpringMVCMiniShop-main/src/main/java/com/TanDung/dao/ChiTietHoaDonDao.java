package com.TanDung.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.TanDung.daoimp.ChiTietHoaDonImp;
import com.TanDung.entity.ChiTietHoaDon;
import com.TanDung.entity.ChiTietHoatDonid;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDao implements ChiTietHoaDonImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		Session session = sessionFactory.getCurrentSession();
		ChiTietHoatDonid id = (ChiTietHoatDonid) session.save(chiTietHoaDon);
		if (null != id) {
			return true;
		} else {
			return false;
		}
	}

}
