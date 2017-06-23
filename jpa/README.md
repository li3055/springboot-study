springboot 热部署配置

1、加入依赖包
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

  <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
		
		
2、配置中数据库信息 以及jpa信息  application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/test2
spring.datasource.username=root
spring.datasource.password=123
spring.datasource.driver-class-name=com.mysql.jdbc.Driver


spring.jpa.database=MYSQL
spring.jpa.show-sql=true	
spring.jpa.properties.hibernate.hbm2ddl.auto=update


3、设置Entity 实体类，指定id 以及生成策略

4、建立dao接口，实现 CrudRepository接口
