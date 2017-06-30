springboot 整合mybatis

1.创建webapp
2、 加入依赖包

		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>1.1.1</version>
		</dependency>

		<dependency>
			<groupId>com.github.pagehelper</groupId>
			<artifactId>pagehelper</artifactId>
			<version>4.1.0</version>
		</dependency>
		
3、创建mapperdao，通过注解写sql语句

4、app启动类 添加mapper扫描 @MapperScan
		

遇到问题：

1、 查询结果部分字段映射不到
配置添加
mybatis.configuration.mapUnderscoreToCamelCase=true

2、注解方式save和delete 或者update 怎么判断更新成功 ;
答:方法会返回一个long  ,如果是1就是成功

3、mybatis-spring-boot-starter 高于1.1.1的包不能启动



4、
继承带有mapper。xml文件的mybatis；
在application文件中添加
mybatis.mapper-locations=classpath:/mybatis/*Mapper.xml 
mybatis.type-aliases-package=org.jpa.bean
分别是mapper.xml的文件位置，以及bean的位置

在mappper.java文件中添加接口即可
 	