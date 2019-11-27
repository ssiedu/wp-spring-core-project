package com.ssi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public void addProducts() throws Exception {
		productDAO.saveProduct(111, "AAA", 5000);
		System.out.println("PRODUCT SUCCESSFULLY ADDED");
	}
	
	public static void main(String args[]) throws Exception {
		System.out.println("Application Started");
		
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		ProductService service=context.getBean("productService",ProductService.class);
		service.addProducts();
		
		String name=context.getMessage("author",null, "admin", null);
		System.out.println("Author of This Code  : "+name);
		
		//service.addProducts();
		//Connection con=context.getBean("connection",Connection.class);
		//System.out.println(con);
		//ProductDAO dao=context.getBean("productDAO",ProductDAO.class);
		//System.out.println(dao.getCon());
		//System.out.println(service.productDAO);
		
		
	}
	
	
}
