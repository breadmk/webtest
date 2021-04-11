package com.test.webjjang.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.webjjang.model.AcademyModel;

@Mapper
public interface AcademyRepository {

	public List<AcademyModel> list();
}
