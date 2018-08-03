package com.test;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-redis.xml")
public class testSet {

	@Autowired
	private RedisTemplate template;
	
	@Test
	public void setValue() {
		template.boundSetOps("name").add("xiaoming");
		template.boundSetOps("name").add("xiaohong");
		template.boundSetOps("name").add("xiaolan");
		
	}
	
	@Test
	public void getname() {
		Set members = template.boundSetOps("name").members();
		System.out.println(members);
	}
	
	@Test
	public void remove() {
		template.boundSetOps("name").remove("xiaolan");
	
	}


	@Test
	public void delete() {
		template.delete("name");
	
	}
}
