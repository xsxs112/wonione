package cafe24.wio.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value="cafe24.wio.mapper", sqlSessionFactoryRef = "mybatisSqlSessionFactory")
public class WioConfig {
	
	@Bean(name="mybatisSqlSessionFactory")
	public SqlSessionFactory mybatisSqlSessionFactory(DataSource datasource,
											ApplicationContext context) throws Exception {
		SqlSessionFactoryBean mybatisSqlSessionFactoryBean = 
				new SqlSessionFactoryBean();
		
		mybatisSqlSessionFactoryBean.setDataSource(datasource);
		mybatisSqlSessionFactoryBean.setMapperLocations(context.getResources("classpath:mapper/**/*.xml"));
		mybatisSqlSessionFactoryBean.setTypeAliasesPackage("cafe24.wio.bean");
		
		return mybatisSqlSessionFactoryBean.getObject();
	}

}
