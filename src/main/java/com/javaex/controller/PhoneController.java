package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.PhoneService;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {
	
	
	@Autowired
	private PhoneService pService;
	private int cw=0;
	private int cu=0;
	private int cd=0;
	

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model, @ModelAttribute PersonVo pVo) {
		System.out.println("PhoneController>list()");
		List<PersonVo> pList = pService.getPersonList();
		try {
			if (pVo.name.equals("") && pVo.hp.equals("") && pVo.company.equals("")) {
				model.addAttribute("pList", null);
				return "/list";
			}
			model.addAttribute("pList", pService.getSearchList(pVo));
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
		cw += pService.NewPerson(pVo);
		System.out.println(cw);
		// 리다이렉트

		return "redirect:/list";
	}

	@RequestMapping(value = "/modify/{personId}", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(Model model, @PathVariable("personId") int personId) {
		System.out.println("PhoneController>modify()");
		PersonVo pVo = pService.getPerson(personId);
		model.addAttribute("pVo", pVo);
		return "/modifyForm";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(@ModelAttribute PersonVo pVo) {
		System.out.println("PhoneController>update()");
		cu += pService.updatePerson(pVo);
		System.out.println(cu);
		return "redirect:/list";
	}

	@RequestMapping(value = "/delete/{personId}", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@PathVariable("personId") int personId) {
		System.out.println("PhoneController>delete()");
		cd += pService.deletePerson(personId);
		System.out.println(cd);
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
