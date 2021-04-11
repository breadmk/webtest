package com.test.webjjang.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.webjjang.model.AcademyModel;
import com.test.webjjang.repository.AcademyRepository;

@Service
public class AcademyServiceImpl implements AcademyService{

	@Autowired
	AcademyRepository academyRepository;
	
	@Override
	public List<AcademyModel> list() {
		return academyRepository.list();
	}

}
