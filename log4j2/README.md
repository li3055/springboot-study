 1、 springboot 整合log4j2
 因为springboot 默认整合的是logback,所以需要另外配置log4j2
 
 剔除spring-boot-starter-logging
 <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-logging</artifactId>
				</exclusion>
			</exclusions>
		</dependency>

引入spring log4j2

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-log4j2</artifactId>
			<version>1.5.3.RELEASE</version>
		</dependency>

springboot 默认加载resources下的 log4j2.xml

3 xml配置
三个部分 appenders  定义记录哪些包下的日志，以及日志级别，以及定义文件输出 以及控制台日志
loggers 日志的入口，appenders要想生效，必须配置进这里
 Properties 定义自己的参数
		