package com.ssi;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDAO {
	
	@Autowired
	private Connection con;
	
	@Autowired
	private MessageSource messageSource;
	
	
	public int saveProduct(int code, String name, int price) throws Exception {
		
		String authorname=messageSource.getMessage("author",null, "admin", null);
		System.out.println("Product Saved By : "+authorname);
		PreparedStatement ps=con.prepareStatement("insert into products values(?,?,?)");
		ps.setInt(1, code);
		ps.setString(2, name);
		ps.setInt(3,price);
		int n=ps.executeUpdate();
		return n;
	}
}
