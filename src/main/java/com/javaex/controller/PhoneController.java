package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {
	
	@RequestMapping(value="/writeform", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhoneController>writeForm()");
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam("name") String name,@RequestParam("hp") String hp,@RequestParam("company") String company) {
		PhoneDao pDao = new PhoneDao();
		PersonVo personVo = new PersonVo(name, hp, company);
		pDao.Insert(personVo);
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	
	@RequestMapping(value="/test", method= {RequestMethod.GET, RequestMethod.POST})
	public String test() {
		System.out.println("PhoneController>test()");
		return "/WEB-INF/views/test.jsp";
	}
	

}
