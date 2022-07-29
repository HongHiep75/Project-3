package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DbContext;
import model.Cart;
import model.Orders;
import model.Product;

public class OrdersDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void inserOrder(Orders o) throws Exception {
		String query = "insert into Orders ("
				+ "user_mail, order_status, order_date, order_discount_code, order_address)"
				+ "VALUES (? , ?, GETDATE() , ?, ?)";
		con = new DbContext().getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, o.getUserMail());
		ps.setInt(2, o.getStatus());
		ps.setString(3, o.getDiscount());
		ps.setString(4, o.getAddress());
		ps.executeUpdate();
	}

	public int getOrderId(Orders o,String user) throws Exception {
		String query = "SELECT top(1) order_id FROM Orders\r\n" + "where user_mail = ? \r\n"
				+ "order by order_id desc";

		con = new DbContext().getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, user);
		rs = ps.executeQuery();
		int id = 0;
		while (rs.next()) {
			id = rs.getInt(1);
		}
		return id;
	}

	public void insertOrders_detail(int id, Product p) throws Exception {
		System.out.println("cc");
		String query = "insert Orders_detail (order_id, product_id, amount_product, price_product)\r\n"
				+ "VALUES (? , ?, ?, ?)";
		con = new DbContext().getConnection();
		ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.setInt(2, p.getId());
		ps.setDouble(3,p.getAmoutn());
		ps.setDouble(4, p.getPrice());
		ps.executeUpdate();
	}

}
