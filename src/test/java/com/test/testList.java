package com.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-redis.xml")

public class testList {

	@Autowired
	private RedisTemplate template;
	
	@Test
	public void set1() {
		template.boundListOps("name1").rightPush("1");
		template.boundListOps("name1").rightPush("2");
		template.boundListOps("name1").rightPush("3");
		
		
	}
	
	@Test
	public void get1() {
	List range = template.boundListOps("name1").range(0, 10);
	
	for (Object object : range) {
		System.out.println(object);
	}
	}
	

	@Test
	public void set2() {
		template.boundListOps("name1").leftPush("1");
		template.boundListOps("name1").leftPush("2");
		template.boundListOps("name1").leftPush("3");
		
		
	}

	@Test
	public void searchByIndex() {
		Object index = template.boundListOps("name1").index(1);
		System.out.println(index);
	}
	
	@Test
	public void remove() {
		Object index = template.boundListOps("name1").remove(2, "1");
		System.out.println(index);
	}
	
	
	
}
