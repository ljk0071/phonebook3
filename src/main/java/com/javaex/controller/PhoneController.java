package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model, @ModelAttribute PersonVo pVo) {
		System.out.println("PhoneController>list()");
		PhoneDao pDao = new PhoneDao();
		List<PersonVo> pList = pDao.SelectAll();
		try {
			if( pVo.name.equals("") && pVo.hp.equals("") && pVo.company.equals("") ) {
				model.addAttribute("pList", null);
				return "/list";
			}
			model.addAttribute("pList", pDao.Search(pVo));
		} catch (NullPointerException e) {
			model.addAttribute("pList", pList);
		}
		return "/list";
	}

	@RequestMapping(value = "/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhoneController>writeForm()");
		return "/writeForm";
	}

	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo pVo) {
		PhoneDao pDao = new PhoneDao();
		pDao.Insert(pVo);

		// 리다이렉트

		return "redirect:/list";
	}

	@RequestMapping(value = "/modify/{personId}", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(Model model, @PathVariable("personId") int personId) {
		System.out.println("PhoneController>modify()");
		PhoneDao pDao = new PhoneDao();
		PersonVo pVo = pDao.Select(personId);
		model.addAttribute("pVo", pVo);
		System.out.println(personId);
		return "/modifyForm";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(@ModelAttribute PersonVo pVo) {
		System.out.println("PhoneController>update()");
		System.out.println(pVo);
		PhoneDao pDao = new PhoneDao();
		pDao.Update(pVo);
		return "redirect:/list";
	}

//	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
//	public String delete(@RequestParam("personId") int personId) {
//		System.out.println("PhoneController>delete()");
//		PhoneDao pDao = new PhoneDao();
//		pDao.Delete(personId);
//		return "redirect:/list";
//	}
	@RequestMapping(value = "/delete/{personId}", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@PathVariable("personId") int personId) {
		System.out.println("PhoneController>delete()");
		PhoneDao pDao = new PhoneDao();
		pDao.Delete(personId);
		return "redirect:/list";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String search() {
		System.out.println("PhoneController>search()");
		return "searchForm";
	}

	@RequestMapping(value = "/test", method = { RequestMethod.GET, RequestMethod.POST })
	public String test() {
		System.out.println("PhoneController>test()");
		return "/test";
	}

}
