package cokr.oneweeks.demotest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

@Configuration
public class WebConfig implements WebMvcConfigurer{

  @Override
  public void addResourceHandlers(@SuppressWarnings("null") ResourceHandlerRegistry registry) {
    registry
      .addResourceHandler("/**")
      .addResourceLocations("classpath:/static");
  }

  @Bean
  public ServletContextListener servletContextListener(){
    return new ServletContextListener() {
      @Override
      public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("cp", sce.getServletContext().getContextPath() + "/");
      }
    };
  }

  
}
    
        
