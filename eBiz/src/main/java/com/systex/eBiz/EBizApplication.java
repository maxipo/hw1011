package com.systex.eBiz;

import com.systex.eBiz.filter.LoginFilter;
import jakarta.servlet.Filter;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class EBizApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EBizApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(EBizApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilter() {
        FilterRegistrationBean<LoginFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoginFilter());
        registrationBean.addUrlPatterns("/*");  // 設定攔截所有請求
        return registrationBean;
    }
}

//}
