package com.aang13.springbootredis;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import com.redis.om.spring.annotations.EnableRedisEnhancedRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRedisEnhancedRepositories(basePackages = "com.aang13.springbootredis.hash")
@EnableRedisDocumentRepositories(basePackages = "com.aang13.springbootredis.document")
@SpringBootApplication
public class SpringBootRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisApplication.class, args);
	}

}
