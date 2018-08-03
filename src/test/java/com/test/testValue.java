package com.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-redis.xml")
public class testValue {

	@Autowired
	private RedisTemplate template;
	
	@Test
	public void setValue() {
		template.boundValueOps("name").set("xiaomi2ng");
		
	}
	
	@Test
	public void getname() {
		String object = (String) template.boundValueOps("name").get();
		if(object!=null){
			System.out.println(object);
		}
	}
	
	@Test
	public void delete() {
		template.delete("name");
		
	}

}
