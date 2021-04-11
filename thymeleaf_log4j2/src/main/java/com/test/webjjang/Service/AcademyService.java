package com.test.webjjang.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.webjjang.model.AcademyModel;

@Service
public interface AcademyService {

	public List<AcademyModel> list();
}
