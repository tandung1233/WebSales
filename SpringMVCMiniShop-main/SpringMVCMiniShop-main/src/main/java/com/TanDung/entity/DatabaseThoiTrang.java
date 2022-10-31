package com.TanDung.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//@Repository // Phải có @ này tại bắt buộc của JDBC trong spring
public class DatabaseThoiTrang {

	private JdbcTemplate jdbcTemplate;// Cái này của spring mvc, cái jdbcTeamplate cho chúng ta kết nối cơ sở dữ liệu
										// mà nó tự tạo ra giao dịch(tran sét sần)

	@Autowired // (tự động có dây) nghĩa là cái này sẽ tự động gán biến dataSoure này bằng 1
	// cái biến có cái id(vd:id=dataSoure hoặc dbthoitrang) giống nó ở trong bean,
	// thay vì ta để aotuWire ở xml thì ta để trong code, nó chỉ hoặc động trên
	// setter nhé
	// Lưu ý: có autowired thì cần có iOC thì aotowired mới add chính xác được hoặc
	// phải có getter và setter
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);// Tạo jdbcTeamplate cả không nó bị null
	}

	// Code truy vấn
	public void getListNhanVien() {
		String sql = "select * from nhanvien";// Câu truy vấn sql
		// Giờ đi thực thi try vấn
		List<NhanVienCuDeHocThoi> listNhanVien = jdbcTemplate.query(sql, new RowMapper<NhanVienCuDeHocThoi>() {
			@Override
			public NhanVienCuDeHocThoi mapRow(ResultSet rs, int rowNum) throws SQLException {
				NhanVienCuDeHocThoi nv = new NhanVienCuDeHocThoi();
				nv.setTenNhanVien(rs.getString("tenNhanVien"));
				nv.setTuoi(rs.getInt("tuoi"));
				return nv;
			}
		});
		for (NhanVienCuDeHocThoi nhanVien : listNhanVien) {
			System.out.println(nhanVien);
		}
	}

}