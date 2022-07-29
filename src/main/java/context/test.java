package context;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dao.AccountDao;
import dao.ListProductDAO;
import dao.OrdersDao;
import model.Account;
import model.Orders;
import model.Product;

public class test {

	public static void main(String[] args) throws Exception {
//	       Date d = new Date(System.currentTimeMillis());
//	       System.out.println((d.getYear()+ 1900) + "/" + (d.getMonth()+1) + "/" + (d.getDate()));
//	       Calendar c = Calendar.getInstance();
//	       System.out.println(c.get((Calendar.MONTH)));
//		  java.util.Date javaDate = new java.util.Date();
//	      long javaTime = javaDate.getTime();
//	      System.out.println("Java Date la:" + 
//	             javaDate.toString());
		  
		  Orders o = new Orders(0, "hanoi", null,"honghiep@gmail.com", null, null);
		  OrdersDao oo = new OrdersDao();
		
	    		   
	       
	}
}
