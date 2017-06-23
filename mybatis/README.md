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

2、注解方式save和delete 或者update 怎么判断更新成功

3、mybatis-spring-boot-starter 高于1.1.1的包不能启动
 	