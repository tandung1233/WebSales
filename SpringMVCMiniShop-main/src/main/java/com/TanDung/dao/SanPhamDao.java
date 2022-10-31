package com.TanDung.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.TanDung.daoimp.SanPhamImp;
import com.TanDung.entity.ChiTietSanPham;
import com.TanDung.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDao implements SanPhamImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<SanPham> LayDanhSachSanPhamlimit(int spbatdau, int spketthuc) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> listSanPhams = new ArrayList<SanPham>();
		if (spbatdau < 0) {
			String query = "from SanPham";
			listSanPhams = (List<SanPham>) session.createQuery(query).getResultList();
			return listSanPhams;
		} else {
			listSanPhams = session.createQuery("from SanPham").setFirstResult(spbatdau).setMaxResults(5)
					.getResultList();
		}
		for (SanPham sanPham : listSanPhams) {
			System.out.println(sanPham.getMasanpham());
		}
		return listSanPhams;
	}

	@Override
	@Transactional
	public List<SanPham> LayDanhSachChiTietSanPhamTheoMa(int masanpham) {
		Session session = sessionFactory.getCurrentSession();

		String query = "from SanPham sp where sp.masanpham=1";// Phải from theo lớp đã ánh xạ tạo ra
		List<SanPham> listSanPhams = (List<SanPham>) session.createQuery(query).getResultList();
		return listSanPhams;
	}

	@Override
	@Transactional
	public List<SanPham> laySPTheoDanhMuc(int idDanhMuc) {
		Session session = sessionFactory.getCurrentSession();
		String query = "from SanPham sp where sp.danhMucSanPham.id = " + idDanhMuc;
		List<SanPham> sanPhams = (List<SanPham>) session.createQuery(query).getSingleResult();
		return sanPhams;
	}

	@Override
	@Transactional
	public boolean XoaSpTheoMa(int id) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sanPham = session.get(SanPham.class, id);

		Set<ChiTietSanPham> chiTietSanPhams = sanPham.getChiTietSanPhams();
		for (ChiTietSanPham chiTietSanPham : chiTietSanPhams) {
			session.createQuery("delete ChiTietHoaDon where machitietsanpham = " + chiTietSanPham.getMachitietsanpham())
					.executeUpdate();
		}
		session.createQuery("delete ChiTietSanPham where masanpham = " + id).executeUpdate();
		session.createQuery("delete SanPham where masanpham = " + id).executeUpdate();
		return false;
	}

	@Override
	@Transactional
	public boolean themSanPham(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(sanPham);
		return false;
	}
}
