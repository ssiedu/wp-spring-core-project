package com.ssi;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Connector {
	
	@Autowired
	private MessageSource messageSource;
	
	public  Connection connect() throws Exception {
		String driver=messageSource.getMessage("connection.driver_name",null,null, null);
		String url=messageSource.getMessage("connection.url",null,null, null);
		String uid=messageSource.getMessage("connection.userid",null,null, null);
		String pw=messageSource.getMessage("connection.password",null,null, null);
		//System.out.println(driver+","+url+","+uid+","+pw);
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,uid,pw);
		return con;
	}
	
}
