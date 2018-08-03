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
public class testHash {

	@Autowired
	private RedisTemplate template;
	
	@Test
	public void set() {
		template.boundHashOps("hash").put("a", "aa");
		template.boundHashOps("hash").put("b", "bb");
		template.boundHashOps("hash").put("c", "cc");
		template.boundHashOps("hash").put("d", "dd");
	}
	
	
	@Test
	public void getKeys() {
		Set keys = template.boundHashOps("hash").keys();
		System.out.println(keys);
	}
	@Test
	public void getValues() {
		List values = template.boundHashOps("hash").values();
		System.out.println(values);
	}
	@Test
	public void getValueByKey() {
		Object values = template.boundHashOps("hash").get("a");
		System.out.println(values);
	}
	
	@Test
	public void deleteByKey() {
		template.boundHashOps("hash").delete("b");
		
	}
	
	
	
	
}
