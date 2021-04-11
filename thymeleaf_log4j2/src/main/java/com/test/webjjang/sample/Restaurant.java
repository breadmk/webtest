package com.test.webjjang.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	
	// 대신 사용가능한 어노테이션 : @Autowired - Spring  / @Inject - java
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
}
