package com.webapp.demo.ecommController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.demo.ecommDao.EcommDao;
import com.webapp.demo.ecomm.Ecomm;

@RestController
public class EcommController {

	@Autowired
	EcommDao dao;
	@RequestMapping("/saveProduct")
	@ResponseBody
	public void saveProduct(@RequestParam String id, String name,String desc,String qnt,String price,String type,Ecomm obj) {
	
	obj.setDescription(desc);
	obj.setProductId(id);
	obj.setProductName(name);
	obj.setQuantity(qnt);
	obj.setType(type);
	dao.save(obj);
	System.out.print("added");
		
	}
	
	@RequestMapping("/getByType")
	@ResponseBody
	public List<Ecomm> getByType(@RequestParam String type) {
		
		return dao.byType(type);
		
		
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteProduct(@RequestParam String id) {
		
		System.out.println("product deleted");
		dao.delete(id);
		
	
}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Ecomm> getAll() {
		
		return dao.findAll();
	}
	
	@RequestMapping("/getById")
	@ResponseBody
	public List<Ecomm> getById(@RequestParam String id) {
		System.out.println("ecommerce by id");
		return dao.byId(id);
		
	}
	
}