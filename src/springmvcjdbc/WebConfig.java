
package springmvcjdbc;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
// @ComponentScan(basePackageClasses={WebConfig.class,DB<T>(){}.class})
@ComponentScan({ "springmvcjdbc", "db" })
public class WebConfig extends WebMvcConfigurerAdapter {

	// /**
	// * 配置视图解析器
	// */
	// @Bean
	// public ViewResolver viewResovler() {
	// InternalResourceViewResolver resolver = new
	// InternalResourceViewResolver();
	// resolver.setPrefix("/WEB-INF/views/");
	// resolver.setExposeContextBeansAsAttributes(true);
	// resolver.setSuffix(".jsp");
	// resolver.setViewClass(JstlView.class);//
	// InternalResourceViewResolver将视图解析为JstlView
	// return resolver;
	// }

	/**
	 * 配置静态资源处理
	 */
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();

	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://106.14.125.158:3306/test?characterEncoding=utf-8");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public FreeMarkerConfig freeMarkerConfig() {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPath("WEB-INF/");
		return configurer;
	}

	@Bean
	public FreeMarkerViewResolver freeMarkerViewResolver() {
		FreeMarkerViewResolver freeMarker = new FreeMarkerViewResolver();
		freeMarker.setSuffix(".ftl");
		freeMarker.setContentType("utf8");
		return freeMarker;
	}

}
