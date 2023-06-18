package com.pooltpv.api.jwtpool;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class JwtpoolApplicationTests {

	Calculator underTest = new Calculator();
	@Test
	void isShoudAddNumbers(){

		int numberOne = 20;
		int numberTwo = 30;
		int result = underTest.add(numberOne,numberTwo);
		int expected = 50;
		assertThat(result).isEqualTo(expected);
	}
	class Calculator{
		int add(int a, int b){
			return a+b;
		}
	}
}
