package com.springBootDay3.springBootDay3;

import com.springBootDay3.springBootDay3.dao.PersonDAO;
import com.springBootDay3.springBootDay3.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootDay3ApplicationTests {
	@Autowired
	private PersonDAO personDAO;

	@Test
	void contextLoads() {
		System.out.println(personDAO.averageSalary());
	}

}
