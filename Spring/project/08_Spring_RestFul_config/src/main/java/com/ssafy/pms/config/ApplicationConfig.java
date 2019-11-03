package com.ssafy.pms.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan("com.ssafy.pms")
public class ApplicationConfig {
//	<bean  id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"  destroy-method="close">
//		<property name="driverClassName"  	value="com.mysql.cj.jdbc.Driver" />
//		<property name="url"  				value="jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC&amp;useSSL=false&amp;allowPublicKeyRetrieval=true" />
//		<property name="username"  			value="ssafy" />
//		<property name="password"  			value="ssafy" />
//		<property name="maxActive"  		value="20" />
//	</bean>

	// DB 설정
	@Bean
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		bds.setUsername("ssafy");
		bds.setPassword("ssafy");
		bds.setMaxActive(20);
		return bds;
	}

//	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
//		<property name="dataSource"  ref="dataSource"/>
//		<property name="configLocation"  value="classpath:spring/SqlMapConfig.xml"/>
//	</bean>

	// MyBatis 설정
	@Bean
	public SqlSessionFactoryBean aqlSessionFactoryBean(DataSource ds) {
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(ds);
		String configLoc = "classpath:spring/SqlMapConfig.xml";
		ssfb.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(configLoc));
		return ssfb;
	}

//	<bean  id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
//		<constructor-arg ref="sqlSessionFactory"/>		
//	</bean> 
	@Bean
	public SqlSession sqlSession(SqlSessionFactoryBean fac) throws Exception {
		return new SqlSessionTemplate(fac.getObject());
	}

	// 트랜잭션 설정
	@Bean
	public PlatformTransactionManager platformTransactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
}
