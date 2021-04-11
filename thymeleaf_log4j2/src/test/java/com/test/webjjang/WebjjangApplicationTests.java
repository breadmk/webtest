package com.test.webjjang;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.webjjang.sample.Restaurant;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class WebjjangApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Setter(onMethod_ = @Autowired)
	private Restaurant restaurant;
	
	public void testExist() {
		// not null 확인 - null 이면 예외 발생
		assertNotNull(restaurant);
		log.info(restaurant);
		log.info("---------------------------");
		log.info(restaurant.getChef());
	}
}
