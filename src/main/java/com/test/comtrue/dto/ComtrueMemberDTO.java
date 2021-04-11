package com.test.comtrue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComtrueMemberDTO {

	private int mno;
	private String name,phone,position,email;
	
}
