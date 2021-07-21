package com.zlt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages= {"com.zlt.*"})
@MapperScan("com.zlt.dao")
@EnableSwagger2
public class QYApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			SpringApplication.run(QYApplication.class,  args);
	}

}
