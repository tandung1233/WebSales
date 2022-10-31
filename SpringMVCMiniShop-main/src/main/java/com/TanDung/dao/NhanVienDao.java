package com.TanDung.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.TanDung.daoimp.NhanVienImp;
import com.TanDung.entity.NhanVien;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS) // chỉ định giới hạn của cái proxy
public class NhanVienDao implements NhanVienImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional // Cẩn thận lỗi proxy
	public boolean KiemTraDangNhap(String email, String matkhau) {
		Session session = sessionFactory.getCurrentSession();
		try {
			// Sử dụng cái getSingleResult hoặc getResultList
			NhanVien nhanVien = (NhanVien) session
					.createQuery("from NhanVien where email='" + email + "' and matkhau='" + matkhau + "'")
					.getSingleResult();// getSingleResult Lấy 1 đối tượng nhân viên về
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	@Transactional
	public boolean ThemNhanVien(NhanVien nhanVien) {
		Session session = sessionFactory.getCurrentSession();
		int manhanvien = (int) session.save(nhanVien);
		System.out.println(manhanvien);
		if (manhanvien > 0) {
			return true;
		} else {
			return false;
		}
	}

}
