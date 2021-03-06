package org.jpa.commond;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MyEnvironmentAware implements EnvironmentAware {

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println(environment.getProperty("JAVA_HOME"));

		// 通过 environment 同样能获取到application.properties配置的属性.

		System.out.println(environment.getProperty("spring.datasource.url"));

	}

}
