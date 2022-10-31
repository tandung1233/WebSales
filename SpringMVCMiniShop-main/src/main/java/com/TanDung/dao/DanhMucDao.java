package com.TanDung.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.TanDung.daoimp.DanhMucImp;
import com.TanDung.entity.DanhMucSanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDao implements DanhMucImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<DanhMucSanPham> LayDanhMuc() {
		Session session = sessionFactory.getCurrentSession();
		String query = "from DanhMucSanPham";
		List<DanhMucSanPham> danhMucSanPhams = session.createQuery(query).getResultList();

		return danhMucSanPhams;
	}

}
