1、 创建maven project  

2、pom引入 springboot 配置

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.3.3.RELEASE</version>
	</parent>
	
	和
		<dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-web</artifactId>
      </dependency>
      
 3、建立controller，类注解为 @RestController
 
 4、建立springboot的启动类
 @SpringBootApplication 
public class App 
{
    public static void main( String[] args )
    {
       SpringApplication.run(App.class, args);
    }
}
 
	
