package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DbContext;
import model.Account;

public class AccountDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// lay acc tu gmail va pass
	public Account getAccount(String gmail, String pass) throws Exception {
		Account acc = null;
		String query = "SELECT*FROM Account WHERE user_mail = ? and password = ?";

		con = new DbContext().getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, gmail);
		ps.setString(2, pass);
		rs = ps.executeQuery();

		while (rs.next()) {
			acc = new Account(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
		}
		return acc;

	}
	
	
	public void setAdress(String gmail,String adress) throws Exception {
		
		String query = "UPDATE Account SET user_address = ? WHERE user_mail = ? ";
		con = new DbContext().getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, adress);
		ps.setString(2, gmail);
		ps.executeUpdate();
		
		System.out.println("thanh cong");
		
	}

	// kiem tra gmail có tồn tại trong sql hay chưa
	public boolean checkGmail(String gmail) throws Exception {
		int a = 0;
		String query = "SELECT  count(*)fROM Account WHERE user_mail = ?";
		con = new DbContext().getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, gmail);
		rs = ps.executeQuery();
		while (rs.next()) {
			a = rs.getInt(1);
		}
		return a == 0;

	}
	
	public void signUp(Account acc) throws Exception {
		
		String insert = "insert into Account (user_mail, password, account_role, user_name, user_address, user_phone) \r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		con = new DbContext().getConnection();
		ps = con.prepareStatement(insert);
		ps.setString(1, acc.getUserMail());
		ps.setString(2, acc.getPassword());
		ps.setInt(3, acc.getRole());
		ps.setString(4, acc.getName());
		ps.setString(5, acc.getAddress());
		ps.setString(6, acc.getPhone());
		ps.executeUpdate();
		
		
		
	}

}
