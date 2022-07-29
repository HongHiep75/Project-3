package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DbContext;
import model.Product;

public class ListProductDAO {
	Connection con = null; // ket noi toi sql server
	PreparedStatement ps = null; // dua cau lenh query vao server
	ResultSet rs = null; // nhan ket qua
	
	// tim san pham theo ten

	public List<Product> serch(String name, String soTrang) throws Exception {
		int st = Integer.parseInt(soTrang);
		String query = "SELECT*FROM dbo.Products WHERE product_name like ? order by product_id OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";
		con = new DbContext().getConnection();
		ps = con.prepareStatement(query); // dua cau lenh query vao server
		ps.setString(1, "%" +name +"%");
		ps.setInt(2, (st - 1) * 6);
		rs = ps.executeQuery();
		List<Product> list = new ArrayList<>();

		while (rs.next()) {
			Product a = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
					rs.getString(6), rs.getString(7));
			list.add(a);
		}
		return list;
	}

	public List<Product> listProduct(String soTrang) throws Exception {
		int st = Integer.parseInt(soTrang);
		String query = "SELECT*FROM dbo.Products order by product_id OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";
		con = new DbContext().getConnection();
		ps = con.prepareStatement(query); // dua cau lenh query vao server
		ps.setInt(1, (st - 1) * 6);
		rs = ps.executeQuery();
		List<Product> list = new ArrayList<>();

		while (rs.next()) {
			Product a = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
					rs.getString(6), rs.getString(7));
			list.add(a);
		}
		return list;
	}

	// lay mot san pham theo id
	public Product getProduct(String id) throws Exception {

		String query = "SELECT*FROM dbo.Products WHERE product_id = ?";
		con = new DbContext().getConnection();
		ps = con.prepareStatement(query); // dua cau lenh query vao server
		ps.setString(1, id);
		rs = ps.executeQuery();
		Product a = null;
		while (rs.next()) {
			a = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
					rs.getString(6), rs.getString(7));
		}
		return a;
	}

	// dem so san pham trong bang product
	public int soSanPham(String search) throws Exception {
		String query;
		if (search == null) {
			query = "SELECT count(*)FROM dbo.Products ";
		} else {
			query = "SELECT count(*)FROM dbo.Products WHERE product_name like " + "'%" + search + "%'";
		}

		con = new DbContext().getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}

}
