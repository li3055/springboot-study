package org.jpa.commond;

import javax.annotation.Resource;

import org.jpa.service.CatService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyStartUpRunner implements CommandLineRunner {
	@Resource
	private CatService catService;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("qidong  执行 -----------------" + catService.findAll());

	}

}
