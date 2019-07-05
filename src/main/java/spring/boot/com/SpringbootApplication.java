package spring.boot.com;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.Reader;

//@EnableScheduling
@SpringBootApplication
public class SpringbootApplication {
	private static String env = "local";
	public static SqlSessionFactory sqlSessionFactory;

	private static Logger logger = LoggerFactory.getLogger(SpringbootApplication.class.getName());

	public static void main(String[] args) {
//		new  SpringbootApplication().init();
		SpringApplication.run(SpringbootApplication.class, args);
	}

	public void init (){
		//初始化数据库-单个数据库
		initMySql();

	}


	/**
	 * 单个数据库
	 */
	private void initMySql(){
		try{
			String resource = String.format("mybatis-config-%s.xml", SpringbootApplication.env);
			Reader reader = Resources.getResourceAsReader(resource);
			SpringbootApplication.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
