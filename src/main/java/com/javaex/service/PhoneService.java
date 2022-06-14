package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Service
public class PhoneService {

	@Autowired
	private PhoneDao pDao;

	public List<PersonVo> getPersonList() {
		return pDao.SelectAll();
	}

	public List<PersonVo> getSearchList(PersonVo pVo) {
		return pDao.Search(pVo);
	}

	public PersonVo getPerson(int personId) {
		return pDao.Select(personId);
	}

	public int NewPerson(PersonVo pVo) {
		return pDao.Insert(pVo);
	}

	public int updatePerson(PersonVo pVo) {
		return pDao.Update(pVo);
	}

	public int deletePerson(int personId) {
		return pDao.Delete(personId);
	}
}
