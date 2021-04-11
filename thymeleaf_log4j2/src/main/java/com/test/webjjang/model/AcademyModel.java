package com.test.webjjang.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademyModel {
	
	private int no,score;
	private String location, name, content, process, writedate,teacher,pwd;
	
	
}
